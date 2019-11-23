package com.onur.scout24.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SsoConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/", "/github/v1/statistics/**", "/analyze/test/**", "/login", "/error**")
        .permitAll().anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll();
    http.csrf().disable();
  }
}