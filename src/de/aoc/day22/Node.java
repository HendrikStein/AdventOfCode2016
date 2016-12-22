package de.aoc.day22;

public class Node {
	int size;
	int used;
	int avail;
	int usePercentage;
	public Node(int size, int used, int avail, int usePercentage) {
		this.size = size;
		this.used = used;
		this.avail = avail;
		this.usePercentage = usePercentage;
	}
	public int getUsed() {
		return used;
	}
	public int getSize() {
		return size;
	}
	public int getAvail() {
		return avail;
	}
	public int getUsePercentage() {
		return usePercentage;
	}
	
	public void addData(int size){
		//TODO
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avail;
		result = prime * result + size;
		result = prime * result + usePercentage;
		result = prime * result + used;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (avail != other.avail)
			return false;
		if (size != other.size)
			return false;
		if (usePercentage != other.usePercentage)
			return false;
		if (used != other.used)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Node [size=" + size + ", used=" + used + ", avail=" + avail + ", usePercentage=" + usePercentage + "]";
	}
	
}
