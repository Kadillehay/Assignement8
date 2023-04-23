package com.coderscampus.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadApp {
	public static void main (String[] args) {
		
		
		Assignment8 numbersClass = new Assignment8();
		   Map<Integer, AtomicInteger> counts = new ConcurrentHashMap<>();
	        ExecutorService pool = Executors.newCachedThreadPool();

	        List<CompletableFuture<Integer>> tasks = new ArrayList<>();
	        for (int i = 0; i < 1000; i++) {
	            CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
	                List<Integer> batch = numbersClass.getNumbers();
	                for (Integer number : batch) {
	                    counts.computeIfAbsent(number, k -> new AtomicInteger(0)).incrementAndGet();
	                }
	                return batch.size();
	            }, pool);
	            tasks.add(task);
	        }

	        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();

	        int totalCount = tasks.stream().mapToInt(CompletableFuture::join).sum();
	        System.out.println("Processed " + totalCount + " numbers.");

	        for (Map.Entry<Integer, AtomicInteger> entry : counts.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue().get());
	        }

	        pool.shutdown();
	    }
	}
