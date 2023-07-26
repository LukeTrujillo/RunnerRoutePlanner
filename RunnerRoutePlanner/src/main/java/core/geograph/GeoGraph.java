package core.geograph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import core.utility.RectangularArea;
import core.utility.coordinates.CoordinateECEF;

public class GeoGraph {
	private HashMap<String, GeoNode> nodeMap;
	private HashMap<String, GeoEdge> edgeMap;

	public GeoGraph() {
		this.nodeMap = new HashMap<String, GeoNode>();
		this.edgeMap = new HashMap<String, GeoEdge>();
	}

	/**
	 * Creates an empty node
	 */
	public GeoNode createNode(final String id) {
		this.nodeMap.put(id, new GeoNode(id));
		return this.nodeMap.get(id);
	}

	/**
	 * Returns existing or creates a empty node with the given Id
	 * 
	 * @param id
	 * @return
	 */
	public GeoNode obtainNode(final String id) {
		if (this.hasNode(id)) {
			return this.getNode(id);
		}
		return this.createNode(id);
	}

	public ArrayList<GeoNode> getNodes() {
		return new ArrayList<GeoNode>(this.nodeMap.values());
	}

	public ArrayList<String> getNodeIds() {
		return new ArrayList<String>(this.nodeMap.keySet());
	}

	public GeoNode getNode(final String id) {
		return this.nodeMap.get(id);
	}

	public final boolean hasNode(final String id) {
		return this.nodeMap.containsKey(id);
	}

	/**
	 * This function will delete unconnected nodes and other things
	 */
	public void clean() {
		Iterator<Entry<String, GeoNode>> it = this.nodeMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, GeoNode> entry = it.next();
			if (entry.getValue().getEdgeCount() == 0) {
				it.remove();
			}
		}
	}

	public int getNodeCount() {
		return this.nodeMap.size();
	}

	public GeoEdge createEdge(String id) {
		this.edgeMap.put(id, new GeoEdge(id));
		return this.getEdge(id);
	}

	private GeoEdge getEdge(String id) {
		return this.edgeMap.get(id);
	}

	public GeoEdge getConnectingEdge(GeoNode a, GeoNode b) {
		// TODO
		return null;
	}

	public RectangularArea getBoundingArea() {
		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double maxX = Double.MIN_VALUE;
		double maxY = Double.MIN_VALUE;

		Iterator<Entry<String, GeoNode>> it = this.nodeMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, GeoNode> entry = it.next();
			GeoNode node = entry.getValue();
			CoordinateECEF coord = node.getCoordinate();

			if (coord.getX() < minX) {
				minX = coord.getX();
			}

			if (coord.getX() > maxX) {
				maxX = coord.getX();
			}

			if (coord.getY() < minY) {
				minY = coord.getY();
			}

			if (coord.getY() > maxY) {
				maxY = coord.getY();
			}
		}

		CoordinateECEF corners[] = { new CoordinateECEF(minX, minY), new CoordinateECEF(minX, maxY),
				new CoordinateECEF(maxX, maxY), new CoordinateECEF(maxX, minY), };

		return new RectangularArea(corners);
	}

}
