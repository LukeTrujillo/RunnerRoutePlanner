package core.geograph;

public class GeoEdge extends GeoEntity {

	private GeoNode a, b; // the id of the two nodes that the edge connects to
	
	public GeoEdge(String id, GeoNode a, GeoNode b) {
		super(id);
		this.a = a;
		this.b = b;
	}

	public GeoEdge(String id) {
		super(id);
		this.a = null;
		this.b = null;
	}

	public void setAB(GeoNode a, GeoNode b) {
		this.setA(a);
		this.setB(b);
	}
	
	public void setA(GeoNode a) {
		this.a = a;
	}
	
	public void setB(GeoNode b) {
		this.b = b;
	}

	public void setDirection(GeoEdgeDirection direction) {
		// TODO Auto-generated method stub
		
	}

	public void setType(GeoEdgeType sidewalk) {
		// TODO Auto-generated method stub
		
	}

	public GeoEdgeType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getLength() {
		return a.getCoordinate().getLinearDistanceTo(b.getCoordinate());
	}
	
	public boolean connects(GeoNode to, GeoNode from) {
		return false;
	}

	public void setAB(String aId, String bId, GeoGraph graph) {
		this.a = graph.getNode(aId);
		this.b = graph.getNode(bId);
	}

}
