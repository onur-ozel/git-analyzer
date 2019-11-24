package com.onur.scout24.controller;

import com.onur.scout24.dto.RepositoryDto;
import com.onur.scout24.dto.SearchRepositoryResponse;
import com.onur.scout24.dto.UserDto;
import com.onur.scout24.service.GitHubService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/github")
public class GitHubController {
  @Autowired
  GitHubService service;

  @RequestMapping(value = "/repos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public RepositoryDto[] getRepos() {
    return service.getRepositories();
  }

  @RequestMapping(value = "/repos/{userName}/{repositoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchRepositoryResponse getRepos(@PathVariable(name = "userName", required = true) String userName,
      @PathVariable(name = "repositoryName", required = true) String repositoryName) {
    return service.searchRepositories(userName, repositoryName);
  }

  @RequestMapping(value = "/followers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto[] getFollowers() {
    return service.getFollowerUsers();
  }

  @RequestMapping(value = "/followings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto[] getFollowings() {
    return service.getFollowingUsers();
  }
}