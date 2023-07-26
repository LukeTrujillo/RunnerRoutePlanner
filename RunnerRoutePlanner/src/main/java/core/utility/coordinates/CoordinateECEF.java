package core.utility.coordinates;

public class CoordinateECEF {
	private double x, y, z;
	
	public CoordinateECEF(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public CoordinateECEF(double x, double y) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getLinearDistanceTo(CoordinateECEF destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getLinearGroundDistanceTo(CoordinateECEF destination) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public final double getX() {
		return this.x;
	}
	
	public final double getY() {
		return this.y;
	}
	
	public final double getZ() {
		return this.z;
	}
	
	public CoordinateLLA toLLA() {
		//TODO 
		return null;
	}


}
