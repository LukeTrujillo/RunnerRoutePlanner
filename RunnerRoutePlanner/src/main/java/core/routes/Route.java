package core.routes;

import java.util.ArrayList;

import core.geograph.GeoEdge;
import core.geograph.GeoNode;
import core.routes.constraints.RouteConstraint;
import core.routes.criterias.RouteCriteria;

public class Route {
	private ArrayList<GeoNode> nodes;

	public Route() {
		this.nodes = new ArrayList<GeoNode>();
	}

	public GeoNode get(int i) {
		return this.nodes.get(i);
	}

	public void add(GeoNode node) {
		this.nodes.add(node);
	}

	public void set(int i, GeoNode node) {
		this.nodes.set(i, node);
	}

	public GeoNode end() {
		return this.get(this.nodes.size() - 1);
	}

	public GeoNode pop() {
		return this.pop(this.nodes.size() - 1);
	}

	public GeoNode pop(int i) {
		return this.nodes.remove(i);
	}

	public GeoNode start() {
		return this.get(0);
	}
	
	public int size() {
		return this.nodes.size();
	}
	
	public double distance() {
		double distance = 0;

		if (this.nodes.size() > 1) {
			GeoNode lastNode = this.nodes.get(0);
			GeoNode currentNode = null;
			for (int i = 1; i < this.nodes.size(); i++) {
				currentNode = this.nodes.get(i);
				distance += lastNode.getCoordinate().getLinearDistanceTo(currentNode.getCoordinate());
				lastNode = currentNode;
				currentNode = null;
			}
		}
		return distance;
	}
}
