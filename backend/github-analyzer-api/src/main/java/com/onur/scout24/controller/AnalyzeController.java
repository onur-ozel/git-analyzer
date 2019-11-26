package com.onur.scout24.controller;

import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.onur.scout24.model.AnalyzedRepo;
import com.onur.scout24.service.AnalyzeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/analyze")
public class AnalyzeController {

  @Autowired
  AnalyzeService service;

  @RequestMapping(value = "/{userName}/{repoName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public AnalyzedRepo analyze(Principal principal, @PathVariable(name = "userName", required = true) String userName,
      @PathVariable(name = "repoName", required = true) String repoName)
      throws InterruptedException, ExecutionException {

    @SuppressWarnings("unchecked")
    Number userId = (Number) (((Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication()
        .getDetails()).get("id"));

    return service.analyze(userName, repoName, userId.longValue());
  }

  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<AnalyzedRepo> getAll(Principal principal) {

    @SuppressWarnings("unchecked")
    Number userId = (Number) (((Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication()
        .getDetails()).get("id"));

    Iterable<AnalyzedRepo> response = service.getAll(userId.longValue());
    return response;
  }

  @Cacheable(value = "analyzed_repository", key = "#id")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public AnalyzedRepo getById(@PathVariable(name = "id", required = true) Long id) {
    AnalyzedRepo repo = service.getById(id);

    return repo;
  }
}