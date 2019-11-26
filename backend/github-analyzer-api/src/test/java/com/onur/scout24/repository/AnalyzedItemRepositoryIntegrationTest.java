package com.onur.scout24.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;

import com.onur.scout24.model.AnalyzedRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AnalyzedItemRepositoryIntegrationTest {

	@Autowired
	private AnalyzeRepository repository;

	@TestConfiguration
	@EnableWebSecurity
	static class AnalyzedItemRepositoryIntegrationTestConfiguration {

	}

	@Test
	public void whenFindById_thenReturnAnalyzedRepo() {

		AnalyzedRepo given = new AnalyzedRepo();
		given.setFullName("o-bank");
		repository.save(given);

		assertNotEquals(0L, given.getId().longValue());

		AnalyzedRepo found = repository.findOne(given.getId());

		assertEquals("o-bank", found.getFullName());

	}

}
