package de.aoc.day7;

@FunctionalInterface
public interface IIpAddressFactory {
	IpV7Address toObject(String inst);
}
