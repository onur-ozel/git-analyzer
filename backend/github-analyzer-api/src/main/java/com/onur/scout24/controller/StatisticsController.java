package com.onur.scout24.controller;

import com.onur.scout24.dto.SearchIssueResponse;
import com.onur.scout24.dto.SearchRepoResponse;
import com.onur.scout24.dto.SearchUserResponse;
import com.onur.scout24.service.StatisticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/statistics")
public class StatisticsController {
  @Autowired
  StatisticService service;

  @Cacheable(value = "top-starred-repos")
  @RequestMapping(value = "/top-starred-repos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchRepoResponse getTopStarredRepos() {

    return service.getTopStarredRepos();
  }

  @Cacheable(value = "top-reacted-issues")
  @RequestMapping(value = "/top-reacted-issues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchIssueResponse getTopReactedIssues() {

    return service.getTopReactedIssues();
  }

  @Cacheable(value = "top-followed-users")
  @RequestMapping(value = "/top-followed-users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchUserResponse getTopFollowedUsers() {

    return service.getTopFollowedUsers();
  }
}