package com.onur.scout24.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "analyzed_repo")
public class AnalyzedRepo implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonIgnore()
  @Column(name = "user_id")
  private Long userId;

  private String name;
  @Column(name = "repo_id")
  private Long repoId;
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

  @CreationTimestamp
  private Date createDateTime;
}