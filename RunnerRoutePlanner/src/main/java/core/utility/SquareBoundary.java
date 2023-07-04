package core.utility;

public class SquareBoundary implements Boundary {
	
	private Coordinate corners[];
	
	public SquareBoundary(Coordinate corners[]) {
		this.corners = corners; //TODO: organize this is some way
	}
	
	public Coordinate[] getCorners() {
		return corners;
	}
	
	public boolean withinBoundary(Coordinate coordinate) {
		return true;
	}
	
}
