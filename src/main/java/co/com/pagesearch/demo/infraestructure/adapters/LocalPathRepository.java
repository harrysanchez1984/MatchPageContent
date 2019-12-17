package co.com.pagesearch.demo.infraestructure.adapters;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import co.com.pagesearch.demo.domain.ports.PathRepository;
import co.com.pagesearch.demo.infraestructure.exception.FIleNotFoundException;
import co.com.pagesearch.demo.infraestructure.utils.FileUtils;

@Component
public class LocalPathRepository implements PathRepository {

	@Override
	public List<String> getUrls(String path) {
		return FileUtils.getStreamFromDirectory(path.replace("_", "\\"))
				.orElseThrow(() -> new FIleNotFoundException("file not found " + path)).collect(Collectors.toList());
	}

	@Override
	public CompletableFuture<String> saveWords(String url, List<String> words) {
		return CompletableFuture.supplyAsync(() -> FileUtils.writeStreamToDirectory(
				FilenameUtils.getPathNoEndSeparator(url.substring(6)).replace("/", "_"), words.stream()));
	}
}
