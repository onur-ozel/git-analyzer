package com.onur.scout24.service;

import com.onur.scout24.dto.RepositoryDto;
import com.onur.scout24.dto.SearchRepositoryResponse;
import com.onur.scout24.dto.UserDto;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
    public RepositoryDto[] getRepositories() {
        final String uri = "https://api.github.com/users/facebook/repos";

        final RestTemplate restTemplate = new RestTemplate();
        final RepositoryDto[] response = restTemplate.getForObject(uri, RepositoryDto[].class);

        return response;
    }

    public SearchRepositoryResponse searchRepositories(String userName, String repositoryName) {
        final String uri = "https://api.github.com/search/repositories?q=" + repositoryName + " in:name user:"
                + userName + "&sort=stars&order=desc";

        final RestTemplate restTemplate = new RestTemplate();
        final SearchRepositoryResponse response = restTemplate.getForObject(uri, SearchRepositoryResponse.class);

        return response;
    }

    public UserDto[] getFollowingUsers() {
        final String uri = "https://api.github.com/users/facebook/following";

        final RestTemplate restTemplate = new RestTemplate();
        final UserDto[] response = restTemplate.getForObject(uri, UserDto[].class);

        return response;
    }

    public UserDto[] getFollowerUsers() {
        final String uri = "https://api.github.com/users/facebook/followers";

        RestTemplate restTemplate = new RestTemplate();
        final UserDto[] response = restTemplate.getForObject(uri, UserDto[].class);

        return response;
    }

}
