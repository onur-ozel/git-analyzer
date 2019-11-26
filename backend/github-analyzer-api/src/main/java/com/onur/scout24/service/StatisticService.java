package com.onur.scout24.service;

import com.onur.scout24.dto.SearchIssueResponse;
import com.onur.scout24.dto.SearchRepoResponse;
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

    public SearchRepoResponse getTopStarredRepos() {
        RestTemplate restTemplate = new RestTemplate();
        SearchRepoResponse response = restTemplate.getForObject(topStarredReposUri, SearchRepoResponse.class);

        return response;
    }

    public SearchIssueResponse getTopReactedIssues() {
        RestTemplate restTemplate = new RestTemplate();
        SearchIssueResponse response = restTemplate.getForObject(topReactedIssuesUri, SearchIssueResponse.class);

        return response;
    }

    public SearchUserResponse getTopFollowedUsers() {
        RestTemplate restTemplate = new RestTemplate();
        SearchUserResponse response = restTemplate.getForObject(topFollowedUsersUri, SearchUserResponse.class);

        return response;
    }
}
