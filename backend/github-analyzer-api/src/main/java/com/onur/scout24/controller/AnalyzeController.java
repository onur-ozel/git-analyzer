package com.onur.scout24.controller;

import com.onur.scout24.model.AnalyzedRepository;
import com.onur.scout24.service.AnalyzedItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/analyze")
public class AnalyzeController {

  @Autowired
  AnalyzedItemService service;

  @RequestMapping(value = "/{userName}/{repositoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public AnalyzedRepository analyze(@PathVariable(name = "userName", required = true) String userName,
      @PathVariable(name = "repositoryName", required = true) String repositoryName) {
    AnalyzedRepository a = new AnalyzedRepository();
    a.setOwner(userName);
    a.setName(repositoryName);

    service.add(a);

    return a;
  }

  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<AnalyzedRepository> getAll() {
    return service.getAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public AnalyzedRepository getById(@PathVariable(name = "id", required = true) Long id) {
    return service.getById(id);
  }
}