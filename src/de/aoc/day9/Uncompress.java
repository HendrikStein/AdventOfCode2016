package de.aoc.day9;

public class Uncompress {
	private StringBuilder decompressedData = new StringBuilder();

	public void run(String compressedInput) {
		int indexFirstMarker = compressedInput.indexOf("(");
		// Copy uncompressed part
		if (indexFirstMarker != -1) {
			this.decompressedData.append(compressedInput.substring(0,
					indexFirstMarker));
		} else {
			this.decompressedData.append(compressedInput.substring(0,
					compressedInput.length()));
			return;
		}
		Marker marker = this
				.extractMarker(compressedInput.substring(
						compressedInput.indexOf("("),
						compressedInput.indexOf(")") + 1));

		int endOfChar = compressedInput.indexOf(")") + 1
				+ marker.getNextChars();
		if (endOfChar != -1) {
			String partToRepeat = compressedInput.substring(
					compressedInput.indexOf(")") + 1, endOfChar);

			this.decompress(marker, partToRepeat);
			this.run(compressedInput.substring(endOfChar,
					compressedInput.length()));
		}
	}

	private void decompress(Marker marker, String part) {
		for (int i = 0; i < marker.getRepeat(); i++) {
			this.decompressedData.append(part);
		}
	}

	// extract Marker from '(12x12)...'
	private Marker extractMarker(String input) {
		String nextChars = input.substring(1, input.indexOf("x"));
		String repeat = input.substring(input.indexOf("x") + 1,
				input.indexOf(")"));
		return new Marker(Integer.parseInt(nextChars), Integer.parseInt(repeat));
	}

	public String getDecompressedInput() {
		return this.decompressedData.toString().replace(" ", "");
	}
}
