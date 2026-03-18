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
                        // --- 1. ACCESO PÚBLICO (Sin login) ---
                        .requestMatchers("/auth/**", "/usuario/login", "/usuario", "/contacto").permitAll()
                        .requestMatchers(HttpMethod.GET, "/comunidad/resenas", "/donaciones/ranking",
                                "/donaciones/ultima")
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, "/productos/**", "/images/**").permitAll() // ¡Vital para ver
                                                                                                    // fotos!
                        .requestMatchers("/terminos", "/ranking", "/h2-console/**").permitAll()

                        // --- 2. ACCESO SOLO PARA ADMIN ---
                        .requestMatchers("/contacto/todos", "/usuario/count", "/usuario").hasRole("ADMIN")
                        .requestMatchers("/solicitudes/todas", "/donaciones").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/productos/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/donaciones/**").hasRole("ADMIN")

                        // --- 3. ACCESO AUTENTICADO (Cualquier usuario logueado) ---
                        .requestMatchers("/usuario/perfil", "/usuario/cambiar-password", "/auth/check").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/usuario").authenticated() // Actualizar sus propios datos
                        .requestMatchers("/solicitudes/**", "/donaciones/**").authenticated()
                        .requestMatchers("/donation-states/**").authenticated()

                        // --- 4. CIERRE DE SEGURIDAD ---
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