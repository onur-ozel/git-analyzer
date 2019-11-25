package com.onur.scout24.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "repository")
public class AnalyzedRepository implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @Column(name = "repository_id")
  private Long repositoryId;
  @Column(name = "full_name")
  private String fullName;
  @Column(name = "is_private")
  private Boolean isPrivate;
  private String owner;
  private String url;
  private String description;
  @Column(name = "is_forked")
  private Boolean isForked;
  @Column(name = "star_gazers_count")
  private Integer starGazersCount;
  @Column(name = "watchers_count")
  private Integer watchersCount;
  @Column(name = "forks_count")
  private Integer forksCount;
  @Column(name = "open_issues_count")
  private Integer openIssuesCount;
  @Column(name = "commits_count")
  private Integer commitsCount;
  @Column(name = "pulls_count")
  private Integer pullsCount;
  @Column(name = "contributers_count")
  private Integer contributersCount;
  private String language;
}