package runbetter.core.geograph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import core.utility.coordinates.Coordinate;
import core.utility.coordinates.CoordinateLLA;

public class GeoNode {
	private String id; // might not need
	
	private CoordinateLLA coordinate;
	private ArrayList<GeoEdge> edges;
	
	public GeoNode(String id) {
		this.id = id;
		this.coordinate = null;
		this.edges = new ArrayList<GeoEdge>();
	}
	
	public CoordinateLLA getCoordinate() {
		return this.coordinate;
	}
	
	public void setCoordinate(CoordinateLLA coordinate) {
		this.coordinate = coordinate;
	}
	
	public String getId() {
		return this.id;
	}

	public String toString() {
		return "id=" + this.id + ", coordinate=" + this.coordinate.toString();
	}
} 
