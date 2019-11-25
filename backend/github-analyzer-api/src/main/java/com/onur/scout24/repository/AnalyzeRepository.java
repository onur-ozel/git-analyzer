package com.onur.scout24.repository;

import com.onur.scout24.model.AnalyzedRepo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzeRepository extends PagingAndSortingRepository<AnalyzedRepo, Long> {

}