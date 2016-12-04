package de.aoc.day4;

public class RoomFactory implements IRoomFactory {

	@Override
	public Room toObject(String input) {
		// aaaaa-bbb-z-y-x-123[abxyz]
		String[] parts = input.split("-");
		StringBuilder encryptedName = new StringBuilder();
		StringBuilder originalName = new StringBuilder();
		int sectorId = 0;
		String checksum = null;

		for (int i = 0; i < parts.length; i++) {
			if (!parts[i].contains("[")) {
				encryptedName.append(parts[i]);
				originalName.append(parts[i]);
				originalName.append(" ");
			} else {
				sectorId = this.getSectorId(parts[i]);
				checksum = this.getChecksum(input);
			}
		}
		return new Room(encryptedName.toString(), originalName.toString().trim(), sectorId, checksum);
	}

	private int getSectorId(String input) {
		return Integer.parseInt(input.substring(0, input.indexOf("[")));
	}

	private String getChecksum(String input) {
		return input.substring(input.indexOf("[") + 1, input.indexOf("]"));
	}


}
