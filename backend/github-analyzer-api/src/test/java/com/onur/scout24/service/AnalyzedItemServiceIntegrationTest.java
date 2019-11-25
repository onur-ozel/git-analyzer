package com.onur.scout24.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.onur.scout24.model.AnalyzedRepo;
import com.onur.scout24.repository.AnalyzeRepository;

@RunWith(SpringRunner.class)
@PropertySource(value = "classpath:application.properties")
public class AnalyzedItemServiceIntegrationTest {

	@TestConfiguration
	static class AnalyzedItemServiceTestContextConfiguration {

		@Bean
		public AnalyzeService service() {
			return new AnalyzeService();
		}
	}

	@Autowired
	private AnalyzeService service;

	@MockBean
	private AnalyzeRepository repository;

	@MockBean
	private RestTemplate restTemplate;

	@Before
	public void setUp() {
		AnalyzedRepo repositoryDetail = new AnalyzedRepo();
		repositoryDetail.setId(2L);
		Mockito.when(repository.findOne(2L)).thenReturn(repositoryDetail);

		String url = "https://api.github.com/repos/facebook/between-meals/pulls";
		Mockito.when(restTemplate.getForObject(url, Object[].class)).thenReturn(new Object[3]);

	}

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		AnalyzedRepo found = service.getById(2L);
		assertNotNull(found);
		assertEquals(2L, found.getId().longValue());
	}

	@Test
	public void whenGetPull_thenPullCountShouldBeThree() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> pullCountFuture = service.getGitRepoPullCount("userName", "repoName");
		int pullCount = pullCountFuture.get();
		assertEquals(3, pullCount);
	}

}
