package com.coderscampus.assignment;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Assignment8Service {
    Assignment8 assignment = new Assignment8();
    ExecutorService cashedService = Executors.newCachedThreadPool();
    ExecutorService singleService = Executors.newSingleThreadScheduledExecutor();
    List<Integer> numbersList = new ArrayList<>();

    public void getData() {
        for (int i = 0; i < 1000; i++) {
            CompletableFuture.supplyAsync(assignment::getNumbers, cashedService)
                    .thenAcceptAsync(list -> numbersList.addAll(list), singleService);
        }
    }

    public void unique() {
        Map<Integer, Long> map = new LinkedHashMap<>();
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            map.put(i, numbersList.stream()
                    .filter(n -> n == finalI)
                    .count());
        }
        System.out.println("");
        System.out.println("Values:");
        System.out.println(map);
        cashedService.shutdown();
        singleService.shutdown();
    }
}

