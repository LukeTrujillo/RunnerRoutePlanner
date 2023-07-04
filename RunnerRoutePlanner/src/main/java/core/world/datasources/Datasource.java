package core.world.datasources;

import core.utility.SquareBoundary;
import core.world.Chunk;

public interface Datasource {
	public Chunk loadChunk(SquareBoundary boundary);
}
