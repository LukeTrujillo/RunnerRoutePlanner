package core.routes.constraints;

import core.geograph.GeoEdge;
import core.geograph.GeoEdgeType;
import core.geograph.GeoGraph;
import core.routes.Route;

public class AvoidCrosswalksRouteConstraint extends RouteConstraint {
	
	@Override
	protected double calculateScore(Route route, GeoGraph graph) {
		/**
		 * Returns the total percent of the distance of the route that is not crosswalks
		 */
		double totalDistance = route.distance();
		double crosswalkDistance = 0;
		
		for(GeoNode edge : route.getEdges()) {
			if(edge.getType() == GeoEdgeType.CROSSWALK) {
				crosswalkDistance += edge.getLength();
			}
		}
		
		return 1 - crosswalkDistance / totalDistance;
	}
}
