package com.codefinity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class WordCountTask implements Callable<String> {
    private final File file;

    public WordCountTask(File file) {
        this.file = file;
    }

    @Override
    public String call() {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int wordCount = line.split("\\s+").length;
                String result = String.format("File: %s | Line: %s | Word Count %d", file.getName(), line, wordCount);
                stringBuffer.append(result).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
