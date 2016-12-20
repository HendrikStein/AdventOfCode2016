package de.aoc.day16;

public class Disc {
	private int length;
	private String data;

	public Disc(String initialState, int length) {
		this.data = initialState;
		this.length = length;
		this.fillData();
	}

	private void fillData() {
		while (this.data.length() < this.length) {
			this.data = this.data + "0" + this.reverse(this.data);
		}
	}

	private String reverse(String data) {
		StringBuilder builder = new StringBuilder();
		for (int i = data.length() - 1; i >= 0; i--) {
			if (String.valueOf(data.charAt(i)).equals("0")) {
				builder.append("1");
			} else {
				builder.append("0");
			}
		}
		return builder.toString();
	}

	public String getData() {
		return this.data;
	}

	public String getChecksum() {
		String checksum = this.checksum(this.data, this.length);
		while (checksum.length() % 2 == 0) {
			checksum = this.checksum(checksum, checksum.length());
		}
		return checksum;
	}

	private String checksum(String data, int length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i += 2) {
			String pair = data.substring(i, i + 2);
			if (String.valueOf(pair.charAt(0)).equals(
					String.valueOf(pair.charAt(1)))) {
				builder.append("1");
			} else {
				builder.append("0");
			}
		}
		return builder.toString();
	}
}
