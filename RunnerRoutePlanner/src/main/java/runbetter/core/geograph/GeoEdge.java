package runbetter.core.geograph;

public class GeoEdge {
	private GeoNode aNode, bNode;
	
	public GeoEdge() {
		this.aNode = null;
		this.bNode = null;
	}
	
	public void setA(GeoNode aNode) {
		this.aNode = aNode;
	}
	
	public void setB(GeoNode bNode) {
		this.bNode = bNode;
	}
	
	public void setAB(GeoNode aNode, GeoNode bNode) {
		this.aNode = aNode;
		this.bNode = bNode;
	}
}
