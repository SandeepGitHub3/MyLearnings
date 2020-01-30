package com.sherlock.learn.java.adventures.java.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FileMaxLengthLineJavaStream {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("src/main/resources/CaseFiles.txt"));

		Supplier<Stream<String>> lineStreamSupplier = () -> lines.stream();

		System.out.println(String.format("Max Length :%d", lineStreamSupplier.get()
				.mapToInt(String::length)
				.max()
				.getAsInt()));

		System.out.println(String.format("Max Length String :%s", lineStreamSupplier.get().
				max(Comparator.comparingInt(String::length))
				.get()));
	}
}
