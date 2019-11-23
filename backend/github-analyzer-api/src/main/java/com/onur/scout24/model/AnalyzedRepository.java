package com.onur.scout24.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repository")
public class AnalyzedRepository {
  @Id
  @Column(name = "id")
  private String id = null;

  @Column(name = "interest")
  private Double interest = null;

  public Double getInterest() {
    return interest;
  }

  public void setInterest(Double interest) {
    this.interest = interest;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}