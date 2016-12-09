package de.aoc.day7;


public class IpAddressFactory implements IIpAddressFactory {

	@Override
	public IpV7Address toObject(String ipV7Input) {
		IpV7Address ipAddress = new IpV7Address();
		ipV7Input = ipV7Input.replace('[', '-');
		ipV7Input = ipV7Input.replace(']', '-');
		String[] parts = ipV7Input.split("-");

		for (int i = 0; i < parts.length; i++) {
			// Outside square brackets
			if (i % 2 == 0) {
				ipAddress.addSupernetSequence(parts[i]);
			} else {
				//Inside brackets
				ipAddress.addHypernetSequence(parts[i]);
			}
		}
		return ipAddress;
	}
}
