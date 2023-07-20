package runbetter.core.geograph;

import java.util.ArrayList;
import java.util.HashMap;

import core.utility.coordinates.Coordinate;
import runbetter.core.geograph.exceptions.GeoGraphConstraintException;

public class GeoGraph {
	private HashMap<String, GeoNode> nodeMap;
	private ArrayList<GeoEdge> edges;
	
	public GeoGraph() {
		this.nodeMap = new HashMap<String, GeoNode>();
		this.edges = new ArrayList<GeoEdge>();
	}
	
//	public GeoNode getClosestNode(Coordinate coordinate) {
//		double shortestDistance = Double.MAX_VALUE;
//		int nodeIdx = -1;
//		
//		for(int i = 0; i < this.nodes.size(); i++) {
//			/*double distance = this.nodes.get(i).getCoordinate().getDistanceTo(coordinate);
//			
//			if(distance < shortestDistance) {
//				nodeIdx = i;
//				shortestDistance = distance;
//			}*/
//		}
//		
//		return this.nodes.get(nodeIdx);
//	}
	
	public ArrayList<GeoNode> getNodes() {
		return new ArrayList<GeoNode>(this.nodeMap.values());
	}
	
	public ArrayList<GeoEdge> getEdges() {
		return this.edges;
	}
	
	public void addNode(GeoNode node) throws GeoGraphConstraintException {
		if(this.nodeMap.containsKey(node.getId())) {
			throw new GeoGraphConstraintException();
		}
		this.nodeMap.put(node.getId(), node);
	}

	public int getNodeCount() {
		return this.nodeMap.size();
	}
	
	public String toString() {
		String graphStr = "nodes:\n";
		for(GeoNode node : this.getNodes()) {
			graphStr += "\t" + node + "\n";
		}
		
		return graphStr;
	}
	
	
}
