package com.onur.scout24;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@EnableCaching
@SpringBootApplication
@EnableResourceServer
public class GitHubAnalyzerApi extends ResourceServerConfigurerAdapter {
  public static void main(final String[] args) {
    SpringApplication.run(GitHubAnalyzerApi.class, args);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {

    // @formatter:off
          http
            .cors().and()
            .authorizeRequests()
                  .antMatchers( "/api/v1/statistics/**").permitAll()
                  .anyRequest().authenticated();
              // @formatter:on
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}
