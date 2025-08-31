package com.parmida.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadFromResources {
	private final String path;

	public ReadFromResources(String path) {
		this.path = path;
	}

	public List<String> readAllLines() throws URISyntaxException {
		List<String> lines;
		try {
			File file = getFileFromResource();
			lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public InputStream getFileFromResourceAsStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(path);
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + path);
		} else {
			return inputStream;
		}

	}

	public File getFileFromResource() throws URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(path);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + path);
		} else {
			return new File(resource.toURI());
		}

	}

}
