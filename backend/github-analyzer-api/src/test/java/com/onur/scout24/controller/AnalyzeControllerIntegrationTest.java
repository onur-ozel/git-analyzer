package com.onur.scout24.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.onur.scout24.model.AnalyzedRepo;
import com.onur.scout24.service.AnalyzeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(AnalyzeController.class)
public class AnalyzeControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private AnalyzeService service;

	@Test
	void testAnalyze() throws Exception {
		given(service.analyze("onur-ozel", "o-bank", 5L)).willReturn(new AnalyzedRepo());

		mvc.perform(post("/api/v1/analyze/onur-ozel/o-bank").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.commitCount", is(30)))
				.andExpect(jsonPath("$.pullCount", is(3)));
	}
}
