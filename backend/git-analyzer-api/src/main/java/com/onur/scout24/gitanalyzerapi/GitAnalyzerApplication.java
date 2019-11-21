package com.onur.scout24.gitanalyzerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableOAuth2Sso
public class GitAnalyzerApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(GitAnalyzerApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
				.antMatchers("/", "/github/v1/oauth2/callback", "/login**", "/webjars/**", "/error**").permitAll().anyRequest()
				.authenticated();
	}
}
