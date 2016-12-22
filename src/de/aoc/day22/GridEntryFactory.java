package de.aoc.day22;

public class GridEntryFactory implements IGridEntryFactory {

	@Override
	public GridEntry toObject(String input) {
		/// dev/grid/node-x0-y0 85T 64T 21T 75%
		String columns[] = input.split("\\s+");
		String position[] = columns[0].split("-");
		String x = position[1].substring(1, position[1].length());
		String y = position[2].substring(1, position[2].length());
		String size = columns[1].substring(0, columns[1].length() - 1);
		String used = columns[2].substring(0, columns[2].length() - 1);
		String avail = columns[3].substring(0, columns[3].length() - 1);
		String usePercentage = columns[4].substring(0, columns[4].length() - 1);
		Node node = new Node(Integer.parseInt(size), Integer.parseInt(used), Integer.parseInt(avail),
				Integer.parseInt(usePercentage));
		GridEntry gridEntry = new GridEntry(node, Integer.parseInt(x), Integer.parseInt(y));
		return gridEntry;
	}
}
