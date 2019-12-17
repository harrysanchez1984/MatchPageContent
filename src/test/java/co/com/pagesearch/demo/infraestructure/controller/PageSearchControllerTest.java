package co.com.pagesearch.demo.infraestructure.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.pagesearch.demo.application.command.ReadUrlFileCommandHandler;

@RunWith(MockitoJUnitRunner.class)
public class PageSearchControllerTest {

	@Mock
	private ReadUrlFileCommandHandler readUrlFileCommandHandler;

	@InjectMocks
	private PageSearchController pageSearchController = new PageSearchController(this.readUrlFileCommandHandler);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void listarOk() {
		String path = "C:/list";
		List<String> pageMatchs = new ArrayList<>();
		pageMatchs.add("C:/list/uno.txt");
		pageMatchs.add("C:/list/uno.txt");
		pageMatchs.add("C:/list/uno.txt");
		when(this.readUrlFileCommandHandler.handler(anyString())).thenReturn(pageMatchs);

		ResponseEntity<List<String>> response = this.pageSearchController.listar(path);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(pageMatchs.get(0), response.getBody().get(0));
	}

}
