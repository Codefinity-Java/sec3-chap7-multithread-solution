package com.codefinity;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        File[] files = {
                new File("file1.txt"),
                new File("file2.txt"),
                new File("file3.txt")
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (File file : files) {
            Future<String> submit = executorService.submit(new WordCountTask(file));
            System.out.println(submit.get());
        }

        executorService.shutdown();
    }
}
