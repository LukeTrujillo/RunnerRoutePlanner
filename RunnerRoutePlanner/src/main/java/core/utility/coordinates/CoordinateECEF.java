ackage core.utility.coordinates;

public final class CoordinateECEF implements Coordinate<CoordinateECEF>, ConvertibleCoordinate<CoordinateLLA> {
	private double x, y, z;
	
	// WGS-84
	private static final double A = 6378137.0; // meters
	private static final double F = 1 / 298.257223563;
	
	
	public CoordinateECEF(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public CoordinateLLA convertTo() {
		double a = A;
		double f = F;
		double b = a * (1 - f);
		double e = Math.sqrt(1 - Math.pow(b, 2) / Math.pow(a, 2));
		double e_prime = Math.sqrt(Math.pow(a, 2) / Math.pow(b, 2) - 1);
		return null;
	}

	public double getLinearDistanceTo(CoordinateECEF destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getLinearGroundDistanceTo(CoordinateECEF destination) {
		// TODO Auto-generated method stub
		return 0;
	}


}
