package com.onur.scout24.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("github/v1/statistics")
public class StatisticsController {

  @RequestMapping(value = "/top-starred-repos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  String topStarredRepos() {

    final String uri = "https://api.github.com/search/repositories?q=is:public&sort=stars&order=desc&page=1&per_page=5";

    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(uri, String.class);

    return response;
  }

  @RequestMapping(value = "/top-reacted-issues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  String topReactedIssues() {

    final String uri = "https://api.github.com/search/issues?q=is:open+is:issue&sort=reactions&order=desc&page=1&per_page=5";

    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(uri, String.class);

    return response;
  }

  @RequestMapping(value = "/top-followed-users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  String topFollowedUsers() {

    final String uri = "https://api.github.com/search/users?q=followers:%3E=0&sort=followers&order=desc&page=1&per_page=5";

    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(uri, String.class);

    return response;
  }
}