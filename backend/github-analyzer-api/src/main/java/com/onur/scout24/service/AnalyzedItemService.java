package com.onur.scout24.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.onur.scout24.model.AnalyzedRepository;
import com.onur.scout24.repository.AnalyzedItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyzedItemService {
    @Autowired
    AnalyzedItemRepository repository;

    @PersistenceContext
    private EntityManager em;

    public void add(AnalyzedRepository repo) {
        repository.save(repo);
    }

    public AnalyzedRepository getById(Long id) {
        return repository.findOne(id);
    }

    public Iterable<AnalyzedRepository> getAll() {
        return repository.findAll();
    }
}
