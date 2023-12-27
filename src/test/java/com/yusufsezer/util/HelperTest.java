package com.yusufsezer.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelperTest {

	@Test
	void testGetUrlDatabase() {
		final String DATABASE_URL = Helper.getUrlDatabase();	
		assertNotNull(DATABASE_URL);
	}
		
	@Test
	void testMd5() {		
		final String EXAMPLE_LINE = "exampleLine";
		assertNotEquals(EXAMPLE_LINE, Helper.md5(EXAMPLE_LINE));		
	}
}
