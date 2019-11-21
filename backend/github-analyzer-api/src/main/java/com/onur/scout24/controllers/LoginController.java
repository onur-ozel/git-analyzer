package com.onur.scout24.controllers;

import java.security.Principal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
// @RequestMapping("github/v1/login")
public class LoginController {

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  String login() {

    final String uri = "https://api.github.com/search/repositories?q=is:public&sort=stars&order=desc&page=1&per_page=5";

    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(uri, String.class);

    return response;
  }

  @GetMapping("/user")
  public Principal user(Principal principal) {
    return principal;
  }

  @GetMapping("/auth-required")
  public String user() {
    return "authenticated";
  }

}