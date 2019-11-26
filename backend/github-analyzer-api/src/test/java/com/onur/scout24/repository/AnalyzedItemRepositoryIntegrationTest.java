package com.onur.scout24.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onur.scout24.model.AnalyzedRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AnalyzedItemRepositoryIntegrationTest {

	@Autowired
	private AnalyzeRepository repository;

	@Test
	public void whenFindById_thenReturnAnalyze() {
		// given
		AnalyzedRepo givenRepo = new AnalyzedRepo();
		givenRepo.setFullName("java-cosmos");
		repository.save(givenRepo);

		// when
		AnalyzedRepo found = repository.findOne(givenRepo.getId());

		// then
		assertEquals("java-cosmos", found.getFullName());
	}
}
