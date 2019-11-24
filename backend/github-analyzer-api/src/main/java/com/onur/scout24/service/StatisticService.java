package com.onur.scout24.service;

import com.onur.scout24.dto.SearchIssueResponse;
import com.onur.scout24.dto.SearchRepositoryResponse;
import com.onur.scout24.dto.SearchUserResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatisticService {
    public SearchRepositoryResponse topStarredRepos() {
        final String uri = "https://api.github.com/search/repositories?q=is:public&sort=stars&order=desc&page=1&per_page=5";

        final RestTemplate restTemplate = new RestTemplate();
        final SearchRepositoryResponse response = restTemplate.getForObject(uri, SearchRepositoryResponse.class);

        return response;
    }

    public SearchIssueResponse topReactedIssues() {
        final String uri = "https://api.github.com/search/issues?q=is:open is:issue&sort=reactions&order=desc&page=1&per_page=5";

        RestTemplate restTemplate = new RestTemplate();
        final SearchIssueResponse response = restTemplate.getForObject(uri, SearchIssueResponse.class);

        return response;
    }

    public SearchUserResponse topFollowedUsers() {
        final String uri = "https://api.github.com/search/users?q=followers:>=0&sort=followers&order=desc&page=1&per_page=5";

        final RestTemplate restTemplate = new RestTemplate();
        final SearchUserResponse response = restTemplate.getForObject(uri, SearchUserResponse.class);

        return response;
    }
}
