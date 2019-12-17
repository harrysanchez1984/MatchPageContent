package co.com.pagesearch.demo.infraestructure.utils;

import java.util.regex.Pattern;

public class UrlUtils {

	private UrlUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean isValidUrl(String url) {
		String pattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		return Pattern.compile(pattern).matcher(url).matches();
	}

}
