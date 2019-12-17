package co.com.pagesearch.demo.domain.ports;

import java.util.Optional;

public interface ContentPage {

    Optional<String> getContentPage(String url);
}
