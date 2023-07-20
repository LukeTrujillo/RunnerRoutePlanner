import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import core.routes.constraints.DistanceRouteConstraint;
import core.routes.planners.BFSRoutePlanner;
import core.utility.builders.OSMFile2GeoGraph;
import crosby.binary.osmosis.OsmosisReader;
import runbetter.core.geograph.GeoGraph;

public class App {
	public static void main(String args[]) throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream("data/osm/massachusetts-latest.osm.pbf");
		GeoGraph graph = new OSMFile2GeoGraph(inputStream).getGraph();
		System.out.println(graph);
	}
}
