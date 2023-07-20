package core.utility.builders;

import java.io.FileInputStream;
import java.util.Map;

import org.openstreetmap.osmosis.core.container.v0_6.EntityContainer;
import org.openstreetmap.osmosis.core.container.v0_6.NodeContainer;
import org.openstreetmap.osmosis.core.container.v0_6.WayContainer;
import org.openstreetmap.osmosis.core.domain.v0_6.Node;
import org.openstreetmap.osmosis.core.domain.v0_6.Tag;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;
import org.openstreetmap.osmosis.core.domain.v0_6.WayNode;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;

import core.utility.coordinates.CoordinateLLA;
import crosby.binary.osmosis.OsmosisReader;
import runbetter.core.geograph.GeoGraph;
import runbetter.core.geograph.GeoNode;

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
		if(graph.getNodeCount() > 10) {
			return;
		}
		
		
		if(entityContainer instanceof NodeContainer) {
			Node osmNode = ((NodeContainer) entityContainer).getEntity();
			GeoNode node = new GeoNode(Long.toString(osmNode.getId()));
			
			double lat = osmNode.getLatitude();
			double lon = osmNode.getLongitude();
			double alt = 0;
			node.setCoordinate(new CoordinateLLA(lat, lon, alt));
			
			try {
				this.graph.addNode(node);
			} catch(Exception e) {
				// TODO
			}
		} else if(entityContainer instanceof WayContainer) {
//			Way osmWay = ((WayContainer) entityContainer).getEntity();
//			for(WayNode wayNode : osmWay.getWayNodes()) {
//				wayNode.getNodeId();
//			}
		}

	}

	public GeoGraph getGraph() {
		return this.graph;
	}
}
