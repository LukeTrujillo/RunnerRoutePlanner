package core.routes.planners;

import java.util.ArrayList;

import core.geograph.GeoGraph;
import core.geograph.GeoNode;
import core.routes.Route;
import core.routes.constraints.RouteConstraint;
import core.routes.criterias.RouteCriteria;
import core.routes.planners.constraints.PlannerConstraint;

public abstract class RoutePlanner {

	protected ArrayList<PlannerConstraint> plannerConstraints;
	protected ArrayList<RouteConstraint> routeConstraints; 
	protected ArrayList<RouteCriteria> routeCriteria;
	
	protected Route route;
	
	public RoutePlanner() {
		this.plannerConstraints = new ArrayList<PlannerConstraint>();
		this.routeConstraints = new ArrayList<RouteConstraint>();
		this.routeCriteria = new ArrayList<RouteCriteria>();
		this.route = new Route();
	}

	public Route run(GeoGraph graph) throws RoutePlannerException {
		if(this.routeConstraints.size() == 0) {
			throw new RoutePlannerException("No route criteria given.");
		}
		return this.plan(graph);
	}

	public void addRouteConstraint(RouteConstraint routeConstraint) {
		this.routeConstraints.add(routeConstraint);
	}
	
	public void addPlannerConstraint(PlannerConstraint plannerConstraint) {
		this.plannerConstraints.add(plannerConstraint);
	}
	
	public void addRouteCriteria(RouteCriteria criteria) {
		this.routeCriteria.add(criteria);
	}
	
	public void setStartNode(GeoNode node) {
		this.route.set(0, node);
	}
	
	protected abstract Route plan(GeoGraph graph) throws RoutePlannerException;
}
