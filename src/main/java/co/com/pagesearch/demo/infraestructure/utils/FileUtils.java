package co.com.pagesearch.demo.infraestructure.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.stream.Stream;

import co.com.pagesearch.demo.infraestructure.exception.DocumentFileException;

public final class FileUtils {

	private static final String EXTENDS = ".txt";

	private FileUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static Optional<Stream<String>> getStreamFromDirectory(String directionFile) {
		try {
			Path pathFile = Paths.get(directionFile);
			return Optional.of(Files.lines(pathFile));
		} catch (IOException e) {
			throw new DocumentFileException(e.getMessage());
		}
	}

	public static String writeStreamToDirectory(final String fileName, Stream<String> contentFileStream) {
		Path path = Paths.get(System.getenv("SystemDrive").concat("//temp//") + fileName.concat(EXTENDS));
		try (BufferedWriter br = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.CREATE)) {
			contentFileStream.forEach((file) -> {
				try {
					br.write(file);
					br.newLine();
				} catch (IOException e) {
					throw new DocumentFileException(e.getMessage());
				}
			});
			return path.toString();
		} catch (Exception e) {
			throw new DocumentFileException(e.getMessage());
		}
	}
}