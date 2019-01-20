package com.sherlock.learn.java.adventures.java.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> a = new ArrayList<>();
        long timeStart = System.currentTimeMillis();

        CompletableFuture<List<Integer>> task1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.asList(1, 2, 3);
        });

        CompletableFuture<List<Integer>> task2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.asList(11, 22, 33);
        });

        CompletableFuture<List<Integer>> task3 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.asList(111, 222, 333);
        });

        a.addAll(task1.get());
        a.addAll(task2.get());
        a.addAll(task3.get());
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);
        System.out.println(a.toString());
    }
}
