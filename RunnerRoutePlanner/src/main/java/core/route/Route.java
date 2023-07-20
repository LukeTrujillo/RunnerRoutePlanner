package core.route;

import java.util.ArrayList;

import runbetter.core.geograph.GeoNode;

public class Route {
	private ArrayList<GeoNode> geoNodes;

	public Route() {
		this.nodes = new ArrayList<GeoNode>();
	}

	public boolean isLoop() {
		return this.nodes.size() > 0 && this.nodes.get(0).equals(this.nodes.get(this.nodes.size() - 1));
	}

	public void addPathwayNode(GeoNode geoNode) {
		this.nodes.add(geoNode);
	}
}
