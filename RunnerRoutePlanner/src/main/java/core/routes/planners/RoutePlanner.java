package core.routes.planners;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import core.route.Route;
import core.routes.constraints.RouteConstraint;
import runbetter.core.geograph.GeoGraph;

public abstract class RoutePlanner {
	private List<Pair<Double, RouteConstraint>> weightedConstraints; 
	
	public RoutePlanner() {
		this.weightedConstraints = new ArrayList<Pair<Double, RouteConstraint>>();
	}
	
	public void addConstraint(double weight, RouteConstraint constraint) {
		
	}
	
	public abstract Route plan(GeoGraph geoGraph);
}
