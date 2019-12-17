package co.com.pagesearch.demo.infraestructure.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.pagesearch.demo.infraestructure.utils.UrlUtils;

@RunWith(MockitoJUnitRunner.class)
public class UrlUtilsTest {
	
	@Test
	public void isValidUrlOkTest() {
		String url = "http://www.google.com";
		
		boolean response = UrlUtils.isValidUrl(url);
		
		assertTrue(response);
	}
	
	@Test
	public void isValidUrlFailTest() {
		String url = "pruebas Urk";
		
		boolean response = UrlUtils.isValidUrl(url);
		
		assertFalse(response);
	}

}
