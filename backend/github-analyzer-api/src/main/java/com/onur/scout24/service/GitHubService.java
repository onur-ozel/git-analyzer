package com.onur.scout24.service;

import java.net.URI;

import com.onur.scout24.dto.RepoDto;
import com.onur.scout24.dto.SearchRepoResponse;
import com.onur.scout24.dto.UserDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GitHubService {
    @Value("${apiUrl.root}")
    private String gitHubApiUrl;

    public UserDto getUserInfo(String userName) {
        URI repoUri = UriComponentsBuilder.fromUriString("{apiUrl}/users/{userName}")
                .buildAndExpand(gitHubApiUrl, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(repoUri, UserDto.class);
    }

    public String getReadme(String userName, String repoName) {
        URI repoUri = UriComponentsBuilder.fromUriString("{apiUrl}/repos/{userName}/{repoName}/readme")
                .buildAndExpand(gitHubApiUrl, userName, repoName).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github.3.html");

        HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(repoUri, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public RepoDto[] getRepos(String userName) {
        URI repoUri = UriComponentsBuilder.fromUriString("{apiUrl}/users/{userName}/repos")
                .buildAndExpand(gitHubApiUrl, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(repoUri, RepoDto[].class);
    }

    public UserDto[] getFollowingUsers(String userName) {
        URI followingUri = UriComponentsBuilder.fromUriString("{apiUrl}/users/{userName}/following")
                .buildAndExpand(gitHubApiUrl, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(followingUri, UserDto[].class);
    }

    public UserDto[] getFollowerUsers(String userName) {
        URI followerUri = UriComponentsBuilder.fromUriString("{apiUrl}/users/{userName}/followers")
                .buildAndExpand(gitHubApiUrl, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(followerUri, UserDto[].class);
    }

    public SearchRepoResponse searchRepositories(String userName, String repoName) {
        URI searchRepoUri = UriComponentsBuilder
                .fromUriString(
                        "{apiUrl}/search/repositories?q={repoName} in:name user:{userName}&sort=stars&order=desc")
                .buildAndExpand(gitHubApiUrl, repoName, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(searchRepoUri, SearchRepoResponse.class);
    }

}
