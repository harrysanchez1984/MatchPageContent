package co.com.pagesearch.demo.application.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import co.com.pagesearch.demo.domain.Page;
import co.com.pagesearch.demo.domain.ports.ContentPage;
import co.com.pagesearch.demo.domain.ports.PathRepository;
import co.com.pagesearch.demo.infraestructure.utils.UrlUtils;

@Service
public class ReadUrlFileCommandHandler {

	private final ContentPage contentPage;
	private final PathRepository localPathRepository;

	private static final String PATTERN_SEARCH = "[#@]\\w+";

	public ReadUrlFileCommandHandler(final ContentPage contentPage, final PathRepository localPathRepository) {
		this.contentPage = contentPage;
		this.localPathRepository = localPathRepository;
	}

	public List<String> handler(String path) {
		List<String> paths = new ArrayList<>();
		this.localPathRepository.getUrls(path).forEach(url -> {
			if (UrlUtils.isValidUrl(url)) {
				Optional<String> content = this.contentPage.getContentPage(url);
				if (content.isPresent()) {
					Page page = new Page(url, content.get());
					try {
						paths.add(this.localPathRepository.saveWords(page.getUrl(), page.getMatcher(PATTERN_SEARCH)).get());
					} catch (InterruptedException | ExecutionException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		});
		return paths;
	}
}
