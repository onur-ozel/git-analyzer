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

    SearchRepoResponse response = service.getTopStarredRepos();

    return response;
  }

  @Cacheable(value = "top-reacted-issues")
  @RequestMapping(value = "/top-reacted-issues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchIssueResponse getTopReactedIssues() {

    SearchIssueResponse response = service.getTopReactedIssues();

    return response;
  }

  @Cacheable(value = "top-followed-users")
  @RequestMapping(value = "/top-followed-users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public SearchUserResponse getTopFollowedUsers() {

    SearchUserResponse response = service.getTopFollowedUsers();

    return response;
  }
}