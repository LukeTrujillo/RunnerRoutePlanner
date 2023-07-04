package core.routes.planners;

import java.util.ArrayList;

import core.routes.constraints.RouteConstraint;
import core.world.World;

public abstract class RoutePlanner {
	private ArrayList<RouteConstraint> constraints;
	private World world;
	
	public RoutePlanner(World world) {
		this.world = world;
		this.constraints = new ArrayList<RouteConstraint>();
	}
	
	public void addConstraint(RouteConstraint constraint) {
		this.constraints.add(constraint);
	}
}
