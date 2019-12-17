package co.com.pagesearch.demo.infraestructure.adapters;

import java.io.IOException;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import co.com.pagesearch.demo.domain.ports.ContentPage;

@Component
public class JsoupContentPage implements ContentPage {

    @Override
    public Optional<String> getContentPage(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return Optional.ofNullable(document.body().text());
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
