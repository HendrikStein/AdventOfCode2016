package de.aoc.day20;

import java.util.List;
import java.util.concurrent.Callable;

public class BruteforceRangeValidator implements Callable<Long> {
	long from, to;
	List<Range> ranges;

	public BruteforceRangeValidator(List<Range> ranges, long from, long to) {
		this.ranges = ranges;
		this.from = from;
		this.to = to;
	}

	@Override
	public Long call() throws Exception {
		long allowed = 0;
		for (long i = this.from; i <= this.to; i++) {
			final long ipIndex = i;
			if (this.ranges.stream().allMatch(ip -> !(ipIndex >= ip.getMin() && ipIndex <= ip.getMax()))) {
				allowed++;
			}
		}
		return allowed;
	}

}
