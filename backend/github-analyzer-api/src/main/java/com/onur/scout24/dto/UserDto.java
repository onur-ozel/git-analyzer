package com.onur.scout24.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto {
  private Long id;
  private String login;
  private String name;
  private String location;
  private String email;
  private String company;
  private String blog;
  private String bio;
  private Integer followerCount;
  private Integer followingCount;
  private String url;
  private String avatarUrl;
  private Date createdAt;
  private Date updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getBlog() {
    return blog;
  }

  public void setBlog(String blog) {
    this.blog = blog;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  @JsonGetter("followerCount")
  public Integer getFollowerCount() {
    return followerCount;
  }

  @JsonSetter("followers")
  public void setFollowerCount(Integer followerCount) {
    this.followerCount = followerCount;
  }

  @JsonGetter("followingCount")
  public Integer getFollowingCount() {
    return followingCount;
  }

  @JsonSetter("following")
  public void setFollowingCount(Integer followingCount) {
    this.followingCount = followingCount;
  }

  @JsonGetter("url")
  public String getUrl() {
    return url;
  }

  @JsonSetter("html_url")
  public void setUrl(String url) {
    this.url = url;
  }

  @JsonGetter("avatarUrl")
  public String getAvatarUrl() {
    return avatarUrl;
  }

  @JsonSetter("avatar_url")
  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  @JsonGetter("createdAt")
  public Date getCreatedAt() {
    return createdAt;
  }

  @JsonSetter("created_at")
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @JsonGetter("updatedAt")
  public Date getUpdatedAt() {
    return updatedAt;
  }

  @JsonSetter("updated_at")
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}