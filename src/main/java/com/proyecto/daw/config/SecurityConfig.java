package com.proyecto.daw.config;

import com.proyecto.daw.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Bela
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable()) // Deshabilitado para peticiones desde React
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(auth -> auth
                        // 1. ACCESO PÚBLICO (Frontend y API general)
                        .requestMatchers("/auth/**", "/usuario/login", "/contacto", "/donar", "/perfil/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuario").permitAll() 
                        .requestMatchers(HttpMethod.GET, "/comunidad/resenas", "/donaciones/ranking", "/donaciones/ultima").permitAll()
                        .requestMatchers(HttpMethod.GET, "/productos/**", "/images/**").permitAll()
                        .requestMatchers("/terminos", "/ranking", "/h2-console/**").permitAll()

                        // 2. ACCESO ADMIN (Gestión y CRUDs)
                        .requestMatchers(HttpMethod.PUT, "/solicitudes/*/status", "/donaciones/*/status").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/donaciones/**", "/solicitudes/**").hasRole("ADMIN")
                        .requestMatchers("/solicitudes/todas", "/contacto/todos", "/usuario/count").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/usuario").hasRole("ADMIN") 
                        .requestMatchers(HttpMethod.POST, "/productos/**").hasRole("ADMIN")

                        // 3. ACCESO AUTENTICADO (Área personal del usuario/empresa)
                        .requestMatchers("/auth/check", "/usuario/perfil", "/usuario/cambiar-password").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/usuario").authenticated()
                        .requestMatchers("/solicitudes/**", "/donaciones/**").authenticated()
                        .requestMatchers("/donation-states/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/usuario/**").authenticated()

                        // 4. CIERRE
                        .anyRequest().authenticated())
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(Arrays.asList(
                "http://localhost:5173",
                "http://*.amazonaws.com",
                "https://*.amazonaws.com"));
        // Puerto por defecto de Vite/React
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173", "http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}