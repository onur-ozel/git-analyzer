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

        return restTemplate.getForObject(topStarredReposUri, SearchRepoResponse.class);
    }

    public SearchIssueResponse getTopReactedIssues() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(topReactedIssuesUri, SearchIssueResponse.class);
    }

    public SearchUserResponse getTopFollowedUsers() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(topFollowedUsersUri, SearchUserResponse.class);
    }
}
