package core;

import java.util.ArrayList;

public abstract class Node {

	private ArrayList<Edge> edges;
	
	public Node() {
		this.edges = new ArrayList<Edge>();
	}
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
		//NOTE: might want to look for duplicated edges
	}
	
}
