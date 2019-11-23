package com.onur.scout24.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * IssueDto
 */
public class IssueDto {
  private String title;
  private String body;
  private Integer commentCount;
  private Date updatedAt;
  private Date createdAt;
  private Integer issueNo;
  private Boolean isLocked;
  private String url;
  private UserDto user;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @JsonGetter("commentCount")
  public Integer getCommentCount() {
    return commentCount;
  }

  @JsonSetter("comments")
  public void setCommentCount(Integer commentCount) {
    this.commentCount = commentCount;
  }

  @JsonGetter("updatedAt")
  public Date getUpdatedAt() {
    return updatedAt;
  }

  @JsonSetter("updated_at")
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @JsonGetter("createdAt")
  public Date getCreatedAt() {
    return createdAt;
  }

  @JsonSetter("created_at")
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @JsonGetter("issueNo")
  public Integer getIssueNo() {
    return issueNo;
  }

  @JsonSetter("number")
  public void setIssueNo(Integer issueNo) {
    this.issueNo = issueNo;
  }

  @JsonGetter("isLocked")
  public Boolean getIsLocked() {
    return isLocked;
  }

  @JsonSetter("locked")
  public void setIsLocked(Boolean isLocked) {
    this.isLocked = isLocked;
  }

  @JsonGetter("url")
  public String getUrl() {
    return url;
  }

  @JsonSetter("html_url")
  public void setUrl(String url) {
    this.url = url;
  }

  public UserDto getUser() {
    return user;
  }

  public void setUser(UserDto user) {
    this.user = user;
  }
}