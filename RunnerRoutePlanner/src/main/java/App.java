import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import core.routes.constraints.DistanceRouteConstraint;
import core.routes.planners.BFSRoutePlanner;
import core.world.World;
import core.world.datasources.OSMDatasource;
import crosby.binary.osmosis.OsmosisReader;

public class App {
	public static void main(String args[]) throws FileNotFoundException {
//		InputStream inputStream = new FileInputStream("data/osm/massachusetts-latest.osm.pbf");
//		OsmosisReader reader = new OsmosisReader(inputStream);
//		reader.setSink(new OSMReader());
//		reader.run();
		
		double target_distance_km = 5;
		
		World world = new World();
		world.addDatasource(new OSMDatasource());
		
		BFSRoutePlanner planner = new BFSRoutePlanner(world); // TBD -- needs world data, and route parameters, BFS does not need heurisits
		// DistanceParameter routeLength = new DistanceParameter(5);
		planner.addConstraint(new DistanceRouteConstraint(2.5));
	}
}
