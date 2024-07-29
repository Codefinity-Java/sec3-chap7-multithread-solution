package com.codefinity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCountTask implements Runnable {
    private final File file;

    public WordCountTask(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int wordCount = line.split("\\s+").length;
                System.out.println("File: " + file.getName() + ", Line: " + line + ", Word Count: " + wordCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
