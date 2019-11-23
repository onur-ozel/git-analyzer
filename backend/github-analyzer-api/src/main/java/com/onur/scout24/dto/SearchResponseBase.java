package com.onur.scout24.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({ "totalCount", "incompleteResults", "items" })
public abstract class SearchResponseBase<E> implements Serializable {
  private Long totalCount;
  private Boolean incompleteResults;
  private List<E> items;

  @JsonGetter("totalCount")
  public Long getTotalCount() {
    return this.totalCount;
  }

  @JsonSetter("total_count")
  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  @JsonGetter("incompleteResults")
  public Boolean getIncompleteResults() {
    return this.incompleteResults;
  }

  @JsonSetter("incomplete_results")
  public void setIncompleteResults(Boolean incompleteResults) {
    this.incompleteResults = incompleteResults;
  }

  public List<E> getItems() {
    return this.items;
  }

  public void setItems(List<E> items) {
    this.items = items;
  }
}