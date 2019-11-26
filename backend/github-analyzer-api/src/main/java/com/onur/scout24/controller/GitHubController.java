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

  @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto getUserInfo(Principal principal) {

    return service.getUserInfo(principal.getName());
  }

  @RequestMapping(value = "/readme", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
  public String getReadme(@RequestParam(name = "userName", required = true) String userName,
      @RequestParam(name = "repoName", required = true) String repoName) {

    return service.getReadme(userName, repoName);
  }

  @RequestMapping(value = "/repos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public RepoDto[] getRepos(Principal principal) {

    return service.getRepos(principal.getName());
  }

  @RequestMapping(value = "/followers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto[] getFollowers(Principal principal) {

    return service.getFollowerUsers(principal.getName());
  }

  @RequestMapping(value = "/followings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto[] getFollowings(Principal principal) {

    return service.getFollowingUsers(principal.getName());
  }

  @Cacheable(value = "search-repo")
  @RequestMapping(value = "/search-repo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchRepoResponse getRepos(@RequestParam(name = "userName", required = true) String userName,
      @RequestParam(name = "repoName", required = true) String repoName) {

    return service.searchRepositories(userName, repoName);
  }
}