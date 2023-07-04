package core.world.datasources;

import java.io.InputStream;

import core.utility.SquareBoundary;
import core.world.Chunk;
import crosby.binary.osmosis.OsmosisReader;

public class OSMDatasource implements Datasource {

	private InputStream inputStream;
	private OsmosisReader reader;
	
	public OSMDatasource() {
	}
	
	public Chunk loadChunk(SquareBoundary boundary) {
		// TODO Auto-generated method stub
		return null;
	}

}
