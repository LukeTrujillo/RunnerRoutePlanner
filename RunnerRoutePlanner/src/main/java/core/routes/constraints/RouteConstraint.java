package core.routes.constraints;

import core.route.Route;

public interface RouteConstraint {
	public double getRouteScore(Route route);
}
