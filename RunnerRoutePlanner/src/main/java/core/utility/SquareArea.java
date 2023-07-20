package core.utility;

import core.utility.coordinates.Coordinate;

public class SquareArea implements Area {
	
	private Coordinate corners[];
	
	public SquareArea(Coordinate corners[]) {
		this.corners = corners; //TODO: organize this is some way
	}
	
	public Coordinate[] getCorners() {
		return corners;
	}
	
	public boolean withinBoundary(Coordinate coordinateLLA) {
		return true;
	}
	
}
