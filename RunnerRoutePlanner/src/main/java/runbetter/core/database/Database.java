package runbetter.core.database;

import runbetter.core.geograph.GeoEdge;
import runbetter.core.geograph.GeoNode;

public interface Database {

	public GeoEdge getWay(int id) throws Exception;
	public GeoNode getNode(int id) throws Exception;

	
}
