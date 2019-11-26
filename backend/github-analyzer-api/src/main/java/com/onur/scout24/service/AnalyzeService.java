package com.onur.scout24.service;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.onur.scout24.dto.RepoDto;
import com.onur.scout24.model.AnalyzedRepo;
import com.onur.scout24.repository.AnalyzeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AnalyzeService {
    @Autowired
    AnalyzeRepository repository;

    @Value("${apiUrl.root}")
    private String gitHubApiUrl;

    public AnalyzedRepo analyze(String userName, String repoName, long userId)
            throws InterruptedException, ExecutionException {
        CompletableFuture<AnalyzedRepo> gitRepoDetail = getGitRepoDetail(userName, repoName);
        CompletableFuture<Integer> pullCountFuture = getGitRepoPullCount(userName, repoName);
        CompletableFuture<Integer> commitCountFuture = getGitRepoCommitCount(userName, repoName);
        CompletableFuture<Integer> contributerCountFuture = getGitRepoContributerCount(userName, repoName);

        AnalyzedRepo analyzedRepo = new AnalyzedRepo();

        analyzedRepo = gitRepoDetail.get();
        analyzedRepo.setPullsCount(pullCountFuture.get());
        analyzedRepo.setCommitsCount(commitCountFuture.get());
        analyzedRepo.setContributersCount(contributerCountFuture.get());
        analyzedRepo.setUserId(userId);

        add(analyzedRepo);

        return analyzedRepo;
    }

    @Async
    public CompletableFuture<AnalyzedRepo> getGitRepoDetail(String userName, String repoName) {
        URI detailRepoUri = UriComponentsBuilder.fromUriString("{apiUrl}/repos/{userName}/{repoName}")
                .buildAndExpand(gitHubApiUrl, userName, repoName).toUri();
        RestTemplate restTemplate = new RestTemplate();

        RepoDto response = restTemplate.getForObject(detailRepoUri, RepoDto.class);
        ModelMapper modelMapper = new ModelMapper();
        // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
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

    public Iterable<AnalyzedRepo> getAll(Long userId) {
        return repository.findByUserId(userId, new Sort(Sort.Direction.DESC, "analyzeDateTime"));
    }
}
