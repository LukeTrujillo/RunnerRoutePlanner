package runbetter.core.geograph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.geograph.GeoGraph;
import core.utility.coordinates.CoordinateECEF;
import core.utility.coordinates.CoordinateLLA;

public class TestGeoGraph {

	@Test
	public void testObtainNode() {
		GeoGraph graph = new GeoGraph();
		
		graph.obtainNode("n1");
		assertNotNull(graph.obtainNode("n1"));
		assertEquals(graph.obtainNode("n1").getId(), "n1");
	
		graph.getNode("n1").setCoordinate(new CoordinateECEF(10, 5, 0.0));
		assertEquals(10, graph.obtainNode("n1").getCoordinate().getX(), 0.001);
	}

}
