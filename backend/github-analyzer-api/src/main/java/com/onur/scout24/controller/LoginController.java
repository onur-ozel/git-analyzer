package com.onur.scout24.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @GetMapping("/user")
  public Principal user(Principal principal) {
    return principal;
  }

  @GetMapping("/auth-required")
  public String user() {
    return "asd";
  }

  @GetMapping("/onur")
  public String onur() {
    return "hello";
  }
}