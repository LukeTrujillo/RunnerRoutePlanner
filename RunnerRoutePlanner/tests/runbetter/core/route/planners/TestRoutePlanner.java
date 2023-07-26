package runbetter.core.route.planners;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.geograph.GeoEdge;
import core.geograph.GeoEdgeDirection;
import core.geograph.GeoEdgeType;
import core.geograph.GeoGraph;
import core.geograph.GeoNode;
import core.utility.coordinates.CoordinateECEF;
import tools.GeoGraphVisualizer;

public class TestRoutePlanner {
	private GeoGraph graph;
	
	@Before
	public void setUp() throws Exception {
		graph = new GeoGraph();
		GeoNode n = graph.createNode("1");
		CoordinateECEF coord = new CoordinateECEF(0, 0, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("2");
		coord = new CoordinateECEF(100, 0, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("3");
		coord = new CoordinateECEF(200, 0, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("4");
		coord = new CoordinateECEF(300, 0, 0);
		n.setCoordinate(coord);
		
		////
		n = graph.createNode("5");
		coord = new CoordinateECEF(0, 100, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("6");
		coord = new CoordinateECEF(100, 100, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("7");
		coord = new CoordinateECEF(200, 100, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("8");
		coord = new CoordinateECEF(300, 100, 0);
		n.setCoordinate(coord);
		
		///
		n = graph.createNode("9");
		coord = new CoordinateECEF(0, 200, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("10");
		coord = new CoordinateECEF(100, 200, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("11");
		coord = new CoordinateECEF(200, 200, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("12");
		coord = new CoordinateECEF(300, 200, 0);
		n.setCoordinate(coord);
		
		// 
		n = graph.createNode("13");
		coord = new CoordinateECEF(0, 300, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("14");
		coord = new CoordinateECEF(100, 300, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("15");
		coord = new CoordinateECEF(200, 300, 0);
		n.setCoordinate(coord);
		
		n = graph.createNode("16");
		coord = new CoordinateECEF(300, 300, 0);
		n.setCoordinate(coord);
		
		GeoEdge e = graph.createEdge("17");
		e.setAB("1", "2", graph); // edge contains "a" and "b"
		e.setDirection(GeoEdgeDirection.BIDIRECTIONAL);
		e.setType(GeoEdgeType.SIDEWALK);
	}

	@Test
	public void testLTRoutePlanner() {
		new GeoGraphVisualizer(graph).visualize();
	}

}
