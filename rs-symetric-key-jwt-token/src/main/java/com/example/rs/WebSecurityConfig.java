package com.example.rs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author: R K Rahu
 *
 * It uses the same key of Authorization Server signed key for JWT token validation.
 * In legacy version we have to extend "ResourceServerConfigurerAdapter"
 * and "@EnableResourceServer" for Resource configuration.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    static String KEY_VALUE = "abcdefghijklmnopqrstuvwxyz123456";
    static String ALGORITHM = "AES";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .oauth2ResourceServer().jwt().decoder(getDecoder());

        http
                .authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public JwtDecoder getDecoder() {
        SecretKey secretKey = new SecretKeySpec(KEY_VALUE.getBytes(), 0, KEY_VALUE.getBytes().length, ALGORITHM);

        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }
}
