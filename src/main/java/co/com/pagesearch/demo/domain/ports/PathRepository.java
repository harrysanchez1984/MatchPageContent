package co.com.pagesearch.demo.domain.ports;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PathRepository {

    List<String> getUrls(String path );

    CompletableFuture<String> saveWords(String url, List<String> words);
}
