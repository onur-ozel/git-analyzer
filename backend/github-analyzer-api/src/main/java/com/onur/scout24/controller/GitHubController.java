package com.onur.scout24.controller;

import java.security.Principal;

import com.onur.scout24.dto.RepoDto;
import com.onur.scout24.dto.SearchRepoResponse;
import com.onur.scout24.dto.UserDto;
import com.onur.scout24.service.GitHubService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/github")
public class GitHubController {
  @Autowired
  GitHubService service;

  @RequestMapping(value = "/repos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public RepoDto[] getRepos(Principal principal) {

    RepoDto[] response = service.getRepos(principal.getName());

    return response;
  }

  @RequestMapping(value = "/followers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto[] getFollowers(Principal principal) {

    UserDto[] response = service.getFollowerUsers(principal.getName());

    return response;
  }

  @RequestMapping(value = "/followings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto[] getFollowings(Principal principal) {

    UserDto[] response = service.getFollowingUsers(principal.getName());

    return response;
  }

  @Cacheable(value = "search-repo")
  @RequestMapping(value = "/search-repo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchRepoResponse getRepos(@RequestParam(name = "userName", required = true) String userName,
      @RequestParam(name = "repoName", required = true) String repoName) {

    SearchRepoResponse response = service.searchRepositories(userName, repoName);

    return response;
  }
}