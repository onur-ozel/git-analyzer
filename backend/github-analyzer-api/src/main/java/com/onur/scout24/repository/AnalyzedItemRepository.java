package com.onur.scout24.repository;

import com.onur.scout24.model.AnalyzedRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzedItemRepository extends PagingAndSortingRepository<AnalyzedRepository, Long> {

}