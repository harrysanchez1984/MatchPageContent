package co.com.pagesearch.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page {
	
	private String url;
	private String content;

	public Page(String url, String content) {
		this.url = url;
		this.content = content;
	}

	public String getUrl() {
		return this.url;
	}

	public String getContent() {
		return this.content;
	}

	public List<String> getMatcher(String pattern) {
		Matcher matcher = Pattern.compile(pattern).matcher(this.getContent());
		List<String> words = new ArrayList<>();
		while (matcher.find())
			words.add(matcher.group(0));
		return words;
	}
}
