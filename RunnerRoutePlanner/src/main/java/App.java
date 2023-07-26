import java.io.FileInputStream;
import java.io.FileNotFoundException;

import core.geograph.GeoGraph;
import core.routes.planners.GARoutePlanner;
import core.routes.planners.RoutePlanner;
import core.utility.builders.OSMFile2GeoGraph;

public class App {
	public static void main(String args[]) throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream("data/osm/massachusetts-latest.osm.pbf");
		GeoGraph graph = new OSMFile2GeoGraph(inputStream).getGraph();
		System.out.println("pre clean nodeCount " + graph.getNodeCount());
		graph.clean();
		System.out.println("post clean nodeCount " + graph.getNodeCount());
		
		
		// distance is completion criteria
		// distance between start location and end location is a optimation constraint
		// 
		
//		RoutePlanner planner = new GARoutePlanner();
//		planner.addCompletionConstraint(new DistanceCompletionConstraint(4.5, 5.5));
//		planner.addPlanningConstraint(new AvoidBacktrackingPlanningConstraint());
//		planner.setStartNode(null);
	}
}
