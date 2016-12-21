package de.aoc.day20;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {

	public static void main(String[] args) throws IOException {
		// List<Range> ranges =
		// InputReader.readInput("resource/day20_test.csv");
		List<Range> ranges = InputReader.readInput("resource/day20.csv");
		RangeValidator validator = new RangeValidator(ranges);
		System.out.println("Lowest Ip:" + validator.getLowestIp());
		// System.out.println(validator.countWhitelistIps());

		 Runner runner = new Runner();
		 runner.threadRunner(ranges);

	}

	private void threadRunner(List<Range> ranges) {
		final ExecutorService service;
		final Future<Long> task1, task2, task3, task4;

		service = Executors.newFixedThreadPool(4);
		task1 = service.submit(new BruteforceRangeValidator(ranges, 0L, 1000000000L));
		task2 = service.submit(new BruteforceRangeValidator(ranges, 1000000001L, 2000000000L));
		task3 = service.submit(new BruteforceRangeValidator(ranges, 2000000001L, 3000000000L));
		task4 = service.submit(new BruteforceRangeValidator(ranges, 3000000001L, 4294967295L));

		try {
			final long result1, result2, result3, result4;

			result1 = task1.get();
			System.out.println("Thread 1: " + result1);
			result2 = task2.get();
			System.out.println("Thread 2: " + result2);
			result3 = task3.get();
			System.out.println("Thread 3: " + result3);
			result4 = task4.get();
			System.out.println("Thread 4: " + result4);
			System.out.println("Allowed Ips: " + (result1 + result2 + result3 + result4));

		} catch (final InterruptedException ex) {
			ex.printStackTrace();
		} catch (final ExecutionException ex) {
			ex.printStackTrace();
		}

		service.shutdownNow();
	}
}
