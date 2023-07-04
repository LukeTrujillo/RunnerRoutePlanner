package core.world;

import core.utility.Coordinate;
import core.utility.SquareBoundary;

public class Chunk {
	private SquareBoundary boundary;
	
	public boolean withinChunk(Coordinate coordinate) {
		return boundary.withinBoundary(coordinate);
	}

	public SquareBoundary getBoundary() {
		return this.boundary;
	}

	public static Chunk merge(Chunk intoChunk, Chunk mergeChunk) {
		if(intoChunk == null) {
			return intoChunk;
		}
		return mergeChunk;
	}
}
