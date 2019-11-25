package com.onur.scout24.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.onur.scout24.dto.RepoDto;
import com.onur.scout24.model.AnalyzedRepo;
import com.onur.scout24.service.AnalyzeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/analyze")
public class AnalyzeController {

  @Autowired
  AnalyzeService service;

  @CrossOrigin(allowedHeaders = "*")
  @RequestMapping(value = "/{userName}/{repoName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public AnalyzedRepo analyze(@PathVariable(name = "userName", required = true) String userName,
      @PathVariable(name = "repoName", required = true) String repoName)
      throws InterruptedException, ExecutionException {

    CompletableFuture<AnalyzedRepo> gitRepoDetail = service.getGitRepoDetail(userName, repoName);
    CompletableFuture<Integer> pullCountFuture = service.getGitRepoPullCount(userName, repoName);
    CompletableFuture<Integer> commitCountFuture = service.getGitRepoCommitCount(userName, repoName);
    CompletableFuture<Integer> contributerCountFuture = service.getGitRepoContributerCount(userName, repoName);

    AnalyzedRepo repoDetail = new AnalyzedRepo();

    repoDetail = gitRepoDetail.get();
    repoDetail.setPullsCount(pullCountFuture.get());
    repoDetail.setCommitsCount(commitCountFuture.get());
    repoDetail.setContributersCount(contributerCountFuture.get());

    service.add(repoDetail);

    return repoDetail;
  }

  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<AnalyzedRepo>> getAll() {
    Iterable<AnalyzedRepo> response = service.getAll();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Cacheable(value = "analyzed_repository", key = "#id")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AnalyzedRepo> getById(@PathVariable(name = "id", required = true) Long id) {
    AnalyzedRepo repo = service.getById(id);

    return new ResponseEntity<>(repo, HttpStatus.OK);
  }
}