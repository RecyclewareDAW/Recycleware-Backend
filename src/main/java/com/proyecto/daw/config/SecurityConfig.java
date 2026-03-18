package com.proyecto.daw.config;

import com.proyecto.daw.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            )
            .authorizeHttpRequests(auth -> auth
                // --- ACCESO PÚBLICO ---
                .requestMatchers("/usuario/login", "/usuario", "/contacto", "/auth/login", "/auth/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/productos/**", "/donations/ranking", "/donation-states/**", "/comunidad/resenas").permitAll()
                
                // --- ROLES ESPECÍFICOS ---
                // 1. PRODUCTOS: Solo ADMIN puede crear/editar/borrar (si añades esos métodos)
                .requestMatchers(HttpMethod.POST, "/productos/**").permitAll()
                
                // 2. SOLICITUDES: PARTICULAR y EMPRESA pueden crear, ADMIN puede ver todas y cambiar estado
                .requestMatchers(HttpMethod.POST, "/solicitudes").permitAll()
                .requestMatchers(HttpMethod.GET, "/solicitudes/usuario/**").permitAll()
                .requestMatchers("/solicitudes/todas", "/solicitudes/*/status").permitAll()
                
                // 3. DONACIONES: Cualquier usuario logueado puede donar
                .requestMatchers(HttpMethod.POST, "/donations").permitAll()
                .requestMatchers("/donations/*/status").permitAll()
                
                // 4. CONTACTO: Ver mensajes solo ADMIN
                .requestMatchers("/contacto/todos").permitAll()
                
                .requestMatchers(HttpMethod.PUT, "/usuario/update-password").permitAll()
                // 5. USUARIOS: Gestión total solo ADMIN
                // .requestMatchers("/usuario/**").hasRole("ADMIN")
                
                // --- CONSOLA H2 ---
                .requestMatchers("/h2-console/**").permitAll()

                .anyRequest().permitAll()
            )
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