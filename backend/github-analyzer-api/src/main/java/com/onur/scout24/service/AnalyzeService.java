package com.onur.scout24.service;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import com.onur.scout24.dto.RepoDto;
import com.onur.scout24.model.AnalyzedRepo;
import com.onur.scout24.repository.AnalyzeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.modelmapper.ModelMapper;

@Service
public class AnalyzeService {
    @Autowired
    AnalyzeRepository repository;

    @Value("${apiUrl.root}")
    private String gitHubApiUrl;

    @Async
    public CompletableFuture<AnalyzedRepo> getGitRepoDetail(String userName, String repoName) {
        URI detailRepoUri = UriComponentsBuilder.fromUriString("{apiUrl}/repos/{userName}/{repoName}")
                .buildAndExpand(gitHubApiUrl, userName, repoName).toUri();
        RestTemplate restTemplate = new RestTemplate();

        RepoDto response = restTemplate.getForObject(detailRepoUri, RepoDto.class);
        ModelMapper modelMapper = new ModelMapper();

        AnalyzedRepo analyzedRepo = modelMapper.map(response, AnalyzedRepo.class);

        return CompletableFuture.completedFuture(analyzedRepo);
    }

    @Async
    public CompletableFuture<Integer> getGitRepoPullCount(String userName, String repositoryName) {
        URI repoPullsUri = UriComponentsBuilder.fromUriString("{apiUrl}/repos/{userName}/{repositoryName}/pulls")
                .buildAndExpand(gitHubApiUrl, userName, repositoryName).toUri();
        RestTemplate restTemplate = new RestTemplate();

        Object[] pulls = restTemplate.getForObject(repoPullsUri, Object[].class);

        return CompletableFuture.completedFuture(pulls.length);
    }

    @Async
    public CompletableFuture<Integer> getGitRepoCommitCount(String userName, String repositoryName) {
        URI repoCommitsUri = UriComponentsBuilder.fromUriString("{apiUrl}/repos/{userName}/{repositoryName}/commits")
                .buildAndExpand(gitHubApiUrl, userName, repositoryName).toUri();
        RestTemplate restTemplate = new RestTemplate();

        Object[] commits = restTemplate.getForObject(repoCommitsUri, Object[].class);

        return CompletableFuture.completedFuture(commits.length);
    }

    @Async
    public CompletableFuture<Integer> getGitRepoContributerCount(String userName, String repositoryName) {
        URI repoContributorsUri = UriComponentsBuilder
                .fromUriString("{apiUrl}/repos/{userName}/{repositoryName}/contributors")
                .buildAndExpand(gitHubApiUrl, userName, repositoryName).toUri();
        RestTemplate restTemplate = new RestTemplate();

        Object[] contributers = restTemplate.getForObject(repoContributorsUri, Object[].class);

        return CompletableFuture.completedFuture(contributers.length);
    }

    public void add(AnalyzedRepo repo) {
        repository.save(repo);
    }

    public AnalyzedRepo getById(Long id) {
        return repository.findOne(id);
    }

    public Iterable<AnalyzedRepo> getAll() {
        return repository.findAll();
    }
}
