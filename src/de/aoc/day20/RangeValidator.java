package de.aoc.day20;

import java.util.Comparator;
import java.util.List;

public class RangeValidator {
	private List<Range> ranges;

	public RangeValidator(List<Range> ranges) {
		this.ranges = ranges;
		this.sortMinAsc();
	}

	public long getLowestIp() {
		for (long i = 0; i <= 4294967295L; i++) {
			final long ipIndex = i;
			if (this.ranges.stream().allMatch(ip -> !(ipIndex >= ip.getMin() && ipIndex <= ip.getMax()))) {
				return i;
			}
		}
		return 0L;
	}

//	public long countWhitelistIps() {
//		long allowed = 0;
//		if (this.ranges.get(0).getMin() - 1 > 0) {
//			allowed = this.ranges.get(0).getMin() - 1;
//		}
//		for (int i = 0; i < this.ranges.size(); i++) {
//			if (i + 1 < this.ranges.size()) {
//				long diff = this.ranges.get(i + 1).getMin() - this.ranges.get(i).getMax() - 1;
//				if (diff > 0) {
//					allowed += diff;
//				}
//			}
//
//		}
//		this.sortMaxAsc();
//		allowed = allowed + (4294967295L - this.ranges.get(this.ranges.size() - 1).getMax() + 1);
//		return allowed;
//	}

	private void sortMinAsc() {
		this.ranges.sort(new Comparator<Range>() {

			@Override
			public int compare(Range o1, Range o2) {
				if (o1.getMin() < o2.getMin()) {
					return -1;
				} else if (o1.getMin() == o2.getMin()) {
					return 0;
				} else {
					return 1;
				}
			}
		});
	}

//	private void sortMaxAsc() {
//		this.ranges.sort(new Comparator<Range>() {
//
//			@Override
//			public int compare(Range o1, Range o2) {
//				if (o1.getMin() > o2.getMin()) {
//					return -1;
//				} else if (o1.getMin() == o2.getMin()) {
//					return 0;
//				} else {
//					return 1;
//				}
//			}
//		});
//	}
}
