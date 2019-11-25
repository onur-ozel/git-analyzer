package com.onur.scout24.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RepoDto extends BaseDto {
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private String fullName;
  private Boolean isPrivate;
  private UserDto owner;
  private String url;
  private String description;
  private Boolean isForked;
  private Integer starGazersCount;
  private Integer watchersCount;
  private Integer forksCount;
  private Integer openIssuesCount;
  private String language;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonGetter("fullName")
  public String getFullName() {
    return fullName;
  }

  @JsonSetter("full_name")
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @JsonGetter("isPrivate")
  public Boolean getIsPrivate() {
    return isPrivate;
  }

  @JsonSetter("private")
  public void setIsPrivate(Boolean isPrivate) {
    this.isPrivate = isPrivate;
  }

  public UserDto getOwner() {
    return owner;
  }

  public void setOwner(UserDto owner) {
    this.owner = owner;
  }

  @JsonGetter("url")
  public String getUrl() {
    return url;
  }

  @JsonSetter("html_url")
  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @JsonGetter("isForked")
  public Boolean getIsForked() {
    return isForked;
  }

  @JsonSetter("fork")
  public void setIsForked(Boolean isForked) {
    this.isForked = isForked;
  }

  @JsonGetter("starGazersCount")
  public Integer getStarGazersCount() {
    return starGazersCount;
  }

  @JsonSetter("stargazers_count")
  public void setStarGazersCount(Integer starGazersCount) {
    this.starGazersCount = starGazersCount;
  }

  @JsonGetter("watchersCount")
  public Integer getWatchersCount() {
    return watchersCount;
  }

  @JsonSetter("watchers_count")
  public void setWatchersCount(Integer watchersCount) {
    this.watchersCount = watchersCount;
  }

  @JsonGetter("forksCount")
  public Integer getForksCount() {
    return forksCount;
  }

  @JsonSetter("forks_count")
  public void setForksCount(Integer forksCount) {
    this.forksCount = forksCount;
  }

  @JsonGetter("openIssuesCount")
  public Integer getOpenIssuesCount() {
    return openIssuesCount;
  }

  @JsonSetter("open_issues")
  public void setOpenIssuesCount(Integer openIssuesCount) {
    this.openIssuesCount = openIssuesCount;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}