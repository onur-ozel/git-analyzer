package com.onur.scout24.service;

import java.net.URI;

import com.onur.scout24.dto.RepositoryDto;
import com.onur.scout24.dto.SearchRepositoryResponse;
import com.onur.scout24.dto.UserDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GitHubService {
    @Value("${apiUrl.root}")
    private String gitHubApiUrl;

    public RepositoryDto[] getRepositories(String userName) {
        URI repositoryUri = UriComponentsBuilder.fromUriString("{apiUrl}/users/{userName}/repos")
                .buildAndExpand(gitHubApiUrl, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();
        RepositoryDto[] response = restTemplate.getForObject(repositoryUri, RepositoryDto[].class);

        return response;
    }

    public UserDto[] getFollowingUsers(String userName) {
        URI followingUri = UriComponentsBuilder.fromUriString("{apiUrl}/users/{userName}/following")
                .buildAndExpand(gitHubApiUrl, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();
        UserDto[] response = restTemplate.getForObject(followingUri, UserDto[].class);

        return response;
    }

    public UserDto[] getFollowerUsers(String userName) {

        URI followerUri = UriComponentsBuilder.fromUriString("{apiUrl}/users/{userName}/followers")
                .buildAndExpand(gitHubApiUrl, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();
        UserDto[] response = restTemplate.getForObject(followerUri, UserDto[].class);

        return response;
    }

    public SearchRepositoryResponse searchRepositories(String userName, String repositoryName) {
        URI searchRepoUri = UriComponentsBuilder.fromUriString(
                "{apiUrl}/search/repositories?q={repositoryName}  in:name user:{userName}&sort=stars&order=desc")
                .buildAndExpand(gitHubApiUrl, repositoryName, userName).toUri();

        RestTemplate restTemplate = new RestTemplate();
        SearchRepositoryResponse response = restTemplate.getForObject(searchRepoUri, SearchRepositoryResponse.class);

        return response;
    }

}
