package com.onur.scout24.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.onur.scout24.service.AnalyzeService;

@RunWith(SpringRunner.class)
@WebMvcTest(AnalyzeController.class)
public class AnalyzeControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private AnalyzeService service;

	@Test
	void testCreateGame() throws Exception {
		given(service.getGitRepoPullCount("username", "password")).willReturn(CompletableFuture.completedFuture(3));
		given(service.getGitRepoCommitCount("username", "password")).willReturn(CompletableFuture.completedFuture(30));
		given(service.getGitRepoContributerCount("username", "password")).willReturn(CompletableFuture.completedFuture(19));

		mvc.perform(post("/games").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.commitCount", is(30))).andExpect(jsonPath("$.pullCount", is(3)));
	}
}
