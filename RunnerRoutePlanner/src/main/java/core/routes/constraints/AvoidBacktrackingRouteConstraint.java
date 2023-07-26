package core.routes.constraints;

import java.util.ArrayList;

import core.geograph.GeoEdge;
import core.geograph.GeoGraph;
import core.geograph.GeoNode;
import core.routes.Route;

public class AvoidBacktrackingRouteConstraint extends RouteConstraint {

	@Override
	protected double calculateScore(Route route, GeoGraph graph) {
		/**
		 * Returns the total percent route this is duplicate edges
		 */
		if(route.size() <= 1) { // if there is only one node, there can be no backtracking
			return 1.0; 
		}
		
		ArrayList<String> edgeIds = new ArrayList<String>();
		int backtrackCount = 0;
		
		GeoNode fromNode = route.get(0);
		GeoNode toNode = null;
		for(int i = 1; i < route.size(); i += 1) {
			toNode = route.get(i);
			GeoEdge edge = graph.getConnectingEdge(fromNode, toNode);
			
			if(edgeIds.contains(edge.getId())) {
				backtrackCount += 1;
			}
			fromNode = toNode;
		}
		
		return backtrackCount / ((double) route.size() - 1);
	}

}
