package co.com.pagesearch.demo.infraestructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.pagesearch.demo.application.command.ReadUrlFileCommandHandler;

@RestController
@RequestMapping("/search")
public class PageSearchController {

	private ReadUrlFileCommandHandler readUrlFileCommandHandler;

	public PageSearchController(ReadUrlFileCommandHandler readUrlFileCommandHandler) {
		this.readUrlFileCommandHandler = readUrlFileCommandHandler;
	}

	@PostMapping(value = "/pages")
	public ResponseEntity<List<String>> listar(@RequestBody final String path) {
		return new ResponseEntity<>(this.readUrlFileCommandHandler.handler(path), HttpStatus.OK);
	}

}
