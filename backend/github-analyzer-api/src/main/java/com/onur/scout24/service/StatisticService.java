package com.onur.scout24.service;

import com.onur.scout24.dto.SearchIssueResponse;
import com.onur.scout24.dto.SearchRepositoryResponse;
import com.onur.scout24.dto.SearchUserResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatisticService {
    @Value("${apiUrl.top-starred-repos}")
    private String topStarredReposUri;
    @Value("${apiUrl.top-reacted-issues}")
    private String topReactedIssuesUri;
    @Value("${apiUrl.top-followed-users}")
    private String topFollowedUsersUri;

    public SearchRepositoryResponse topStarredRepos() {
        final RestTemplate restTemplate = new RestTemplate();
        final SearchRepositoryResponse response = restTemplate.getForObject(topStarredReposUri,
                SearchRepositoryResponse.class);

        return response;
    }

    public SearchIssueResponse topReactedIssues() {
        RestTemplate restTemplate = new RestTemplate();
        SearchIssueResponse response = restTemplate.getForObject(topReactedIssuesUri, SearchIssueResponse.class);

        return response;
    }

    public SearchUserResponse topFollowedUsers() {
        RestTemplate restTemplate = new RestTemplate();
        SearchUserResponse response = restTemplate.getForObject(topFollowedUsersUri, SearchUserResponse.class);

        return response;
    }
}
