package core.routes.constraints;

import core.geograph.GeoGraph;
import core.routes.Route;

public abstract class RouteConstraint {

	/**
	 * Returns a score [0..1] 
	 * @param graph
	 * @return
	 * @throws RouteConstraintException 
	 */
	public final double getScore(final Route route, final GeoGraph graph) throws RouteConstraintException {
		double score = calculateScore(route, graph);
		if(score < 0.0 || score > 1.0) {
			throw new RouteConstraintException("score = " + score + " given. route constraint scores must be [0..1]");
		}
		return score;
	}
	
	protected abstract double calculateScore(final Route route, final GeoGraph graph);
}
