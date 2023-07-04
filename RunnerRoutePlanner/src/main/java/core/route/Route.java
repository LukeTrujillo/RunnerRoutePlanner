package core.route;

import java.util.ArrayList;

import core.world.pathway.PathwayNode;

public class Route {
	private ArrayList<PathwayNode> nodes;

	public Route() {
		this.nodes = new ArrayList<PathwayNode>();
	}

	public boolean isLoop() {
		return this.nodes.size() > 0 && this.nodes.get(0).equals(this.nodes.get(this.nodes.size() - 1));
	}

	public void addPathwayNode(PathwayNode node) {
		this.nodes.add(node);
	}
}
