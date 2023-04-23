//package com.coderscampus.assignment8;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//import org.junit.jupiter.api.Test;
//
//public class Notes {
//	private AtomicInteger j = new AtomicInteger(0);
//	@Test
//	public void getOutputNumbers() {
//	    Assignment8 numbersClass = new Assignment8();
//	    CompletableFuture<Map<Integer, Integer>> future = numbersClass.countNumbersAsync();
//	    future.thenAccept(countMap -> {
//	        countMap.forEach((number, count) -> System.out.println(number + " = " + count + " times"));
//	    });
//	    // wait for the future to complete
//	    future.join();
//
//	    List<CompletableFuture<Integer>> tasks = new ArrayList<>();
//	    ExecutorService pool = Executors.newCachedThreadPool();
//	    for (int i = 0; i < 1000000; i++) {
//	        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> incrementJ(), pool);
//	        tasks.add(task);
//	    }
//	    while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000000) {
//	        System.out.println(
//	                "number of completed threads: " + tasks.stream().filter(CompletableFuture::isDone).count());
//	    }
//
//	    outputJ();
//	}
//
//
//	private Integer incrementJ() {
//		try {
//			Thread.sleep(5);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		synchronized (j) {
//
//			j.set(j.get() + 1);
//			return j.get();
//		}
//
//	}
//	
//	private void outputJ() {
//		System.out.println(j);
//	}
//}
