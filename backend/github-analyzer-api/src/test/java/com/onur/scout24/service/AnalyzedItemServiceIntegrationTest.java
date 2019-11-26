
package com.onur.scout24.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.onur.scout24.model.AnalyzedRepo;
import com.onur.scout24.repository.AnalyzeRepository;

@RunWith(SpringRunner.class)
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
	@Mock
	private RestTemplate restTemplate;

	@Before
	public void setUp() {
		AnalyzedRepo analyzedRepo = new AnalyzedRepo();
		analyzedRepo.setId(2L);
		Mockito.when(repository.findOne(2L)).thenReturn(analyzedRepo);

		URI repoPullsUri = UriComponentsBuilder.fromUriString("{apiUrl}/repos/{userName}/{repositoryName}/pulls")
				.buildAndExpand("https://api.github.com", "onur-ozel", "o-bank").toUri();
		Mockito.when(restTemplate.getForObject(repoPullsUri, Object[].class)).thenReturn(new Object[0]);

	}

	@Ignore
	@Test
	public void whenPullsCountCall_thenThreeShouldBeReturned() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> pullCountFuture = service.getGitRepoPullCount("onur-ozel", "o-bank");
		int pullCount = pullCountFuture.get();
		assertEquals(3, pullCount);
	}

	@Test
	public void whenGetById_thenAnalyzedRepoReturn() {
		AnalyzedRepo found = service.getById(2L);
		assertNotNull(found);
		assertEquals(2L, found.getId().longValue());
	}

}