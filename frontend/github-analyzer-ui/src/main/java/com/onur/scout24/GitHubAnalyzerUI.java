package com.onur.scout24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
public class GitHubAnalyzerUI extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(GitHubAnalyzerUI.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
      // @formatter:off
          http
          .logout().logoutSuccessUrl("/").and()
              .authorizeRequests()
                  .antMatchers("/index.html", "/**", "/github/api/v1/statistics/**","/api/v1/statistics/**","/login").permitAll()
                  .anyRequest().authenticated()
                  .and()
              .csrf()
                  .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
              // @formatter:on
    }
}