package com.onur.scout24.controller;

import com.onur.scout24.model.AnalyzedRepository;
import com.onur.scout24.service.AnalyzedRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analyze/test")
public class AnalyzeController {

  @Autowired
  AnalyzedRepositoryService service;

  @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
  public void add() {
    AnalyzedRepository a = new AnalyzedRepository();
    a.setInterest(23.2);
    a.setId("onur122222");
    service.add(a);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public AnalyzedRepository getById(@PathVariable(name = "id", required = true) String id) {
    return service.getById(id);
  }
}