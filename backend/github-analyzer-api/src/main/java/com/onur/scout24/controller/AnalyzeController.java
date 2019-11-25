package com.onur.scout24.controller;

import com.onur.scout24.dto.RepositoryDto;
import com.onur.scout24.model.AnalyzedRepository;
import com.onur.scout24.service.AnalyzedItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/analyze")
public class AnalyzeController {

  @Autowired
  AnalyzedItemService service;

  @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public AnalyzedRepository analyze(@RequestBody RepositoryDto repository) {
    AnalyzedRepository a = new AnalyzedRepository();
    a.setOwner(repository.getOwner().getName());
    a.setName(repository.getName());

    service.add(a);

    return a;
  }

  // @Cacheable(value = "analyzed_repositories")
  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<AnalyzedRepository>> getAll() {
    Iterable<AnalyzedRepository> response = service.getAll();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Cacheable(value = "analyzed_repository", key = "#id")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AnalyzedRepository> getById(@PathVariable(name = "id", required = true) Long id) {
    AnalyzedRepository repository = service.getById(id);

    return new ResponseEntity<>(repository, HttpStatus.OK);
  }
}