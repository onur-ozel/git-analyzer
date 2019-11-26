package com.onur.scout24.repository;

import java.util.List;

import com.onur.scout24.model.AnalyzedRepo;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzeRepository extends PagingAndSortingRepository<AnalyzedRepo, Long> {
  List<AnalyzedRepo> findByUserId(Long userId, Sort sort);
}