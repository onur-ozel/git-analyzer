package com.onur.scout24.controller;

import com.onur.scout24.dto.SearchIssueResponse;
import com.onur.scout24.dto.SearchRepositoryResponse;
import com.onur.scout24.dto.SearchUserResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("github/v1/statistics")
@PropertySource("classpath:config.properties")
public class StatisticsController {
  @Value("${testonur}")
  private String testuri;

  @RequestMapping(value = "/top-starred-repos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<SearchRepositoryResponse> topStarredRepos() {

    final String uri = "https://api.github.com/search/repositories?q=is:public&sort=stars&order=desc&page=1&per_page=5";

    final RestTemplate restTemplate = new RestTemplate();
    final SearchRepositoryResponse response = restTemplate.getForObject(uri, SearchRepositoryResponse.class);

    return new ResponseEntity<SearchRepositoryResponse>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "/top-reacted-issues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<SearchIssueResponse> topReactedIssues() {
    final String uri = "https://api.github.com/search/issues?q=is:open is:issue&sort=reactions&order=desc&page=1&per_page=5";

    RestTemplate restTemplate = new RestTemplate();
    final SearchIssueResponse response = restTemplate.getForObject(uri, SearchIssueResponse.class);

    return new ResponseEntity<SearchIssueResponse>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "/top-followed-users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<SearchUserResponse> topFollowedUsers() {
    final String uri = "https://api.github.com/search/users?q=followers:>=0&sort=followers&order=desc&page=1&per_page=5";

    final RestTemplate restTemplate = new RestTemplate();
    final SearchUserResponse response = restTemplate.getForObject(uri, SearchUserResponse.class);

    return new ResponseEntity<SearchUserResponse>(response, HttpStatus.OK);
  }
}