package com.onur.scout24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableCaching
@SpringBootApplication
@EnableResourceServer
public class GitHubAnalyzerApi extends WebSecurityConfigurerAdapter {
  public static void main(final String[] args) {
    SpringApplication.run(GitHubAnalyzerApi.class, args);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    // @formatter:off
          http
            .authorizeRequests()
                  .antMatchers( "/api/v1/statistics/**").permitAll()
                  .anyRequest().authenticated()
                  .and()
              .csrf()
                  .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
              // @formatter:on
  }
}
