package br.com.fiap.Sprint_SOA_XP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa CSRF para facilitar testes via Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/clientes/**").hasRole("ADMIN") // somente ADMIN pode acessar /clientes
                        .anyRequest().authenticated() // outros endpoints precisam estar autenticados
                )
                .httpBasic(); // autenticação básica (user/password)
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        // Criação de um usuário admin em memória
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}fiap123") // {noop} indica que a senha não é criptografada
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
