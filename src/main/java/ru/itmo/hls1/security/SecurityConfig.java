package ru.itmo.hls1.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        private final UserDetailsService userDetailsService;
        private final PasswordEncoder passwordEncoder;
        private final long expirationTime;
        private final String secretKey;

        public SecurityConfig(UserDetailsService userDetailsService,
                              PasswordEncoder passwordEncoder,
                              @Value("${jwt.expirationTime}") long expirationTime,
                              @Value("${jwt.secretKey}") String secretKey) {
                this.userDetailsService = userDetailsService;
                this.passwordEncoder = passwordEncoder;
                this.expirationTime = expirationTime;
                this.secretKey = secretKey;
        }

        private static final String[] AUTH_WHITELIST = {
                "**/swagger-resources/**",
                "/swagger-ui.html",
                "/v2/api-docs",
                "/webjars/**"
        };

        /* to be continue ...*/
}
