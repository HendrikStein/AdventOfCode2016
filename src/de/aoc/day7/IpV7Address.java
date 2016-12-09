package de.aoc.day7;

import java.util.ArrayList;
import java.util.List;

public class IpV7Address {
	// Within square brackets
	private List<String> hypernetSequences = new ArrayList<>();
	// Outside square brackets
	private List<String> supernetSequences = new ArrayList<>();

	// Within square brackets
	public void addHypernetSequence(String seq) {
		this.hypernetSequences.add(seq);
	}

	// Outside square brackets
	public void addSupernetSequence(String seq) {
		this.supernetSequences.add(seq);
	}

	public boolean isSslValid() {
		return this.cointainsBabInHypernetSequence(this
				.findAbaInSupernetSequence());
	}

	private List<String> findAbaInSupernetSequence() {
		List<String> abaSeq = new ArrayList<>();
		for (String part : this.supernetSequences) {
			for (int i = 0; i < part.length(); i++) {
				if ((i + 3) <= part.length()) {
					if (is3CharStringAba(part.substring(i, i + 3))) {
						abaSeq.add(part.substring(i, i + 3));
					}
				}
			}
		}
		return abaSeq;
	}

	private boolean cointainsBabInHypernetSequence(List<String> abaSequences) {
		for (String hypernetPart : this.hypernetSequences) {
			for (String abaSeq : abaSequences) {
				String babSeqString = String.valueOf(abaSeq.charAt(1))
						+ String.valueOf(abaSeq.charAt(0))
						+ String.valueOf(abaSeq.charAt(1));
				if (hypernetPart.contains(babSeqString)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean is3CharStringAba(String part) {
		if (part.substring(0, 1).equals(part.substring(2, 3))
				&& !part.substring(0, 1).equals(part.substring(1, 2))) {
			return true;
		}
		return false;
	}

	public boolean isTlsValid() {
		return this.hasValidTlsAbba(this.supernetSequences)
				&& this.hasValidTlsHypernetSequences();
	}

	private boolean hasValidTlsAbba(List<String> parts) {
		for (String part : parts) {
			if (containsAbba(part)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasValidTlsHypernetSequences() {
		if (this.hasValidTlsAbba(this.hypernetSequences)) {
			return false;
		}
		return true;
	}

	private boolean containsAbba(String part) {
		for (int i = 0; i < part.length(); i++) {
			if ((i + 4) <= part.length()) {
				if (is4CharStringAbba(part.substring(i, i + 4))) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean is4CharStringAbba(String part) {
		if (part.substring(0, 1).equals(part.substring(3, 4))
				&& part.substring(1, 2).equals(part.substring(2, 3))
				&& !part.substring(0, 1).equals(part.substring(1, 2))) {
			return true;
		}
		return false;
	}

}
