package de.fisch3r.couchdbdemo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations="classpath:/spring/test-context.xml")
public class MappingRepositoryAdapterIT extends AbstractTestNGSpringContextTests {
	
	private static final String DEFINED_MAP_KEY = "Öl";
	
	@Autowired
	private MappingRepositoryAdapter adapter;
	
	@Test
	public void fetchMapShouldReturnNonEmptyMap() {
		Map<String,String> map = adapter.fetchMap();
		assertThat(map.entrySet(), not(empty()));
	}
	
	@Test
	public void fetchMapReturnsMapWithDefinedKey() {
		Map<String,String> map = adapter.fetchMap();
		assertThat(map, hasKey(DEFINED_MAP_KEY));		
	}

}
