package tools;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import core.geograph.GeoEdge;
import core.geograph.GeoEdgeDirection;
import core.geograph.GeoEdgeType;
import core.geograph.GeoGraph;
import core.geograph.GeoNode;
import core.utility.RectangularArea;
import core.utility.builders.OSMFile2GeoGraph;
import core.utility.coordinates.CoordinateECEF;

public class GeoGraphVisualizer {
	public static void main(String args[]) throws FileNotFoundException {
		GeoGraph graph = new GeoGraph();
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
		
		new GeoGraphVisualizer(graph).visualize();
	}
	
	private final GeoGraph graph;
	private final RectangularArea graphBoundary;
	
	public GeoGraphVisualizer(final GeoGraph graph) {
		this.graph = graph;
		this.graphBoundary = graph.getBoundingArea();
		System.out.println(this.graphBoundary);
	}
	
	public void visualize() {
		Frame frame = new Frame();
		frame.add(new GeoGraphPaintComponent(this.graph));
		frame.setSize((int) this.graphBoundary.width(), (int) this.graphBoundary.length());
		frame.setVisible(true);
	}
	
	static class GeoGraphPaintComponent extends Component {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final GeoGraph graph;
		
		public GeoGraphPaintComponent(GeoGraph graph) {
			super();
			this.graph = graph;
		}
		
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			
			ArrayList<String> nodeIds = this.graph.getNodeIds();
			nodeIds.forEach(nodeId -> {
				CoordinateECEF coord = this.graph.getNode(nodeId).getCoordinate();
				g2d.drawOval((int) coord.getX(), (int) coord.getY(), 10, 10);
			});
		}
	}
}
