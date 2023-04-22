//package com.coderscampus.assignment8;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//import org.junit.jupiter.api.Test;
//
//public class Notes {
//	private AtomicInteger j = new AtomicInteger(0);
//	@Test
//	
//	
//	 public void getOutputNumbers() {
//		@SuppressWarnings("unused")
//		Assignement8 numbersClass = new Assignement8();
//		numbersClass.getNumbers();
//		System.out.println(numbersClass.getNumbers());
//
//		List<CompletableFuture<Integer>> tasks = new ArrayList<>();
//		ExecutorService pool = Executors.newCachedThreadPool();
//		for (int i = 0; i < 1000000; i++)
//		{
//			CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> incrementJ(), pool);
//			tasks.add(task);
//		}
//		while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000000) {
//			System.out.println(
//					"number of completed threads: " + tasks.stream().filter(CompletableFuture::isDone).count());
//		}
//
//		outputJ();
//	}
//
//	private void outputJ() {
//		System.out.println(j);
//	}
//
//	private Integer incrementJ() {
//		try {
//			Thread.sleep(500);
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
//}
