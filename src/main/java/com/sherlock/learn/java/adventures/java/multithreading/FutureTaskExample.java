package com.sherlock.learn.java.adventures.java.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> a = new ArrayList<>();
        long timeStart = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<FutureTask<List<Integer>>> taskList = new ArrayList<>();

        taskList.add(new FutureTask<>(() -> {
            Thread.sleep(500);
            return Arrays.asList(1, 2, 3);
        }));

        taskList.add(new FutureTask<>(() -> {
            Thread.sleep(500);
            return Arrays.asList(11, 22, 33);
        }));

        taskList.add(new FutureTask<>(() -> {
            Thread.sleep(500);
            return Arrays.asList(111, 222, 322);
        }));

        taskList.forEach(task -> {
            executor.execute(task);
        });

        taskList.forEach(task -> {
            try {
                a.addAll(task.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
        long timeEnd = System.currentTimeMillis();
        System.out.println("Time taken to perform  3 tasks in Parallel" + String.valueOf(timeEnd - timeStart));
        System.out.println(a.toString());

        List<Integer> b = new ArrayList<>();
        long timeStart2 = System.currentTimeMillis();

        b.addAll(returnList());
        b.addAll(returnList());
        b.addAll(returnList());

        long timeEnd2 = System.currentTimeMillis();
        System.out.println("Time taken to perform  3 tasks Sequentially" + String.valueOf(timeEnd2 - timeStart2));
        System.out.println(b.toString());
    }

    static List<Integer> returnList() throws InterruptedException {
        Thread.sleep(500);
        return Arrays.asList(1, 2, 3);
    }
}