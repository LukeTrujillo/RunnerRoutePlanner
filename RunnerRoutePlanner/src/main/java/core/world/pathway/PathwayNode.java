package core.world.pathway;

import core.Node;
import core.utility.Coordinate;

public class PathwayNode extends Node implements Mergeable<Node> {
	private Coordinate coordinate;
	
	public PathwayNode(Coordinate coordinate) {
		super();
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Node merge(Node node) {
		// TODO Auto-generated method stub
		return null;
	}
}
