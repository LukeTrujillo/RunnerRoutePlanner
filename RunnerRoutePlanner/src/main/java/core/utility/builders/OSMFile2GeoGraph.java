package core.utility.builders;

import java.io.FileInputStream;
import java.util.Map;

import org.openstreetmap.osmosis.core.container.v0_6.EntityContainer;
import org.openstreetmap.osmosis.core.container.v0_6.NodeContainer;
import org.openstreetmap.osmosis.core.container.v0_6.WayContainer;
import org.openstreetmap.osmosis.core.domain.v0_6.Node;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;
import org.openstreetmap.osmosis.core.domain.v0_6.WayNode;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;

import core.geograph.GeoGraph;
import core.geograph.GeoNode;
import core.geograph.GeoWay;
import core.utility.coordinates.CoordinateLLA;
import crosby.binary.osmosis.OsmosisReader;

public class OSMFile2GeoGraph implements Sink {
	private GeoGraph graph;

	public OSMFile2GeoGraph(FileInputStream inputStream) {
		this.graph = new GeoGraph();

		OsmosisReader reader = new OsmosisReader(inputStream);
		reader.setSink(this);
		reader.run();
	}

	public void initialize(Map<String, Object> metaData) {
	}

	public void complete() {
	}

	public void close() {
	}

	public void process(EntityContainer entityContainer) {

		if (entityContainer instanceof NodeContainer) {
			Node osmNode = ((NodeContainer) entityContainer).getEntity();

			String nodeId = Long.toString(osmNode.getId());
			GeoNode node = graph.obtainNode(nodeId);

			float lat = (float) osmNode.getLatitude();
			float lon = (float) osmNode.getLongitude();
			float alt = 0;

			node.setCoordinate(new CoordinateLLA(lat, lon, alt).toECEF());
			// TODO: add whatever else

		} else if (entityContainer instanceof WayContainer) {
			Way osmWay = ((WayContainer) entityContainer).getEntity();
			String wayId = Long.toString(osmWay.getId());
			GeoWay way = graph.obtainWay(wayId);
			
			for (WayNode wayNode : osmWay.getWayNodes()) {
				String nodeId = Long.toString(wayNode.getNodeId());
				GeoNode node = graph.obtainNode(nodeId);
				way.addNode(node);
				node.addWay(way);
			}
		}
	}

	public GeoGraph getGraph() {
		return this.graph;
	}
}
