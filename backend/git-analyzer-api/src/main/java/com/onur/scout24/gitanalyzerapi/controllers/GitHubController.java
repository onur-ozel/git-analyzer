package com.onur.scout24.gitanalyzerapi.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("github/v1")
public class GitHubController {
  // Client ID
  // e46ca26359ef71b5285c
  // Client Secret
  // 043750121445470d60ad1b43e85b94376f48062b
  @RequestMapping(value = "/oauth2/callback", method = RequestMethod.GET, produces = "application/json")
  public String get(Principal principal) throws Exception {

    // RestTemplate restTemplate = new RestTemplate();
    // String result = restTemplate.getForObject(uri, String.class);
    return "Hi " + principal.getName() + " welcome to SpringCloudOauth2ExampleApplication";
  }
}