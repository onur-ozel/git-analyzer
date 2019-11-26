package com.onur.scout24.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.ExecutionException;

import com.onur.scout24.model.AnalyzedRepo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestAnalyzeService {

	private AnalyzeService service;

	@Before
	public void setUp() {
		service = Mockito.spy(new AnalyzeService());
	}

	@Test
	public void getGitRepoDetail() throws InterruptedException, ExecutionException {
		AnalyzedRepo repoDetail = service.getGitRepoDetail("onur-ozel", "o-bank").get();
		assertNotNull(repoDetail);
	}

	@Test
	public void getGitRepoPullCount() throws InterruptedException, ExecutionException {
		int pullCount = service.getGitRepoPullCount("onur-ozel", "o-bank").get();
		assertEquals(3, pullCount);
	}

	@Test
	public void getGitRepoCommitCount() throws InterruptedException, ExecutionException {
		int commitCount = service.getGitRepoCommitCount("onur-ozel", "o-bank").get();
		assertEquals(30, commitCount);
	}

	@Test
	public void getGitRepoContributerCount() throws InterruptedException, ExecutionException {
		int contributerCount = service.getGitRepoContributerCount("onur-ozel", "o-bank").get();
		assertEquals(19, contributerCount);
	}

}
