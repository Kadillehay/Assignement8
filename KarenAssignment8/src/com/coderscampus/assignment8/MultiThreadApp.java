package com.coderscampus.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

public class MultiThreadApp {
	public static void main (String[] args) {
		
		
		Assignement8 numbersClass = new Assignement8();
		Map <Integer, Integer> counts = new ConcurrentHashMap<>();
		ExecutorService pool = Executors.newCachedThreadPool();
	
		List<CompletableFuture<Void>> tasks = new ArrayList<>();
		for (int i =0; i <1000; i ++) {
			CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
				List <Integer> batch = numbersClass.getNumbers();
				for (Integer number : batch) {
					AtomicInteger count = new AtomicInteger(counts.getOrDefault(number, 0));
					counts.put(number, count.incrementAndGet());
				}
			},pool);
			tasks.add(task);
		}
	CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();
	
	for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
		System.out.println(entry.getKey() + ": " + entry.getValue());
	}
	pool.shutdown();
	}

}
