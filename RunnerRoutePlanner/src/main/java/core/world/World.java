package core.world;

import java.util.ArrayList;

import core.utility.Coordinate;
import core.utility.SquareBoundary;
import core.world.datasources.Datasource;

public class World {
	
	public static final int MAX_CHUNK_CACHE_SIZE = 10;
	
	private ArrayList<Chunk> cachedChunks; // last used, first out ordering on the cache
	private ArrayList<Datasource> datasources;
	
	public World() {
		this.cachedChunks = new ArrayList<Chunk>();
		this.datasources = new ArrayList<Datasource>();
	}

	public void addDatasource(Datasource datasource) {
		this.datasources.add(datasource);
	}
	
	public Chunk getChunk(SquareBoundary boundary) {
		Chunk chunk = this.getCachedChunk(boundary);
		if(chunk == null) {
			chunk = this.loadChunk(boundary);
		}
		this.cacheChunk(chunk);
		return chunk;
	}
	
	private void cacheChunk(Chunk chunk) {
		while(this.cachedChunks.size() >= World.MAX_CHUNK_CACHE_SIZE) {
			this.cachedChunks.remove(0);
		}
		for(Chunk cachedChunk : this.cachedChunks) {
			if(cachedChunk.equals(chunk)) {
				this.cachedChunks.remove(cachedChunk); // remove duplicated
			}
		}
		this.cachedChunks.add(chunk);
	}
	
	private Chunk loadChunk(SquareBoundary boundary) {
		ArrayList<Chunk> loadedChunks = new ArrayList<Chunk>();
		for(Datasource datasource : this.datasources) {
			loadedChunks.add(datasource.loadChunk(boundary));
		}
		
		Chunk mergedChunk = null;
		for(Chunk chunk : loadedChunks) {
			Chunk.merge(mergedChunk, chunk);
		}
		
		return mergedChunk;
	}
	
	private Chunk getCachedChunk(SquareBoundary chunkBoundary) {
		for(Chunk chunk : this.cachedChunks) {
			if(chunk.getBoundary().equals(chunkBoundary)) {
				return chunk;
			}
		}
		return null;
	}
}
