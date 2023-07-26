package core.geograph;

import java.util.ArrayList;

import core.utility.coordinates.CoordinateECEF;

public class GeoNode extends GeoEntity {

	private CoordinateECEF coordinate;
	private ArrayList<GeoEdge> edges;

	public GeoNode(String id) {
		super(id);
		this.coordinate = null;
		this.edges = new ArrayList<GeoEdge>();
	}

	public CoordinateECEF getCoordinate() {
		return this.coordinate;
	}

	public void setCoordinate(CoordinateECEF coordinate) {
		this.coordinate = coordinate;
	}

	public String toString() {
		return "id=" + this.id + ", coordinate=" + this.coordinate.toString();
	}

	public int getEdgeCount() {
		return this.edges.size();
	}

}
