package core.utility.coordinates;

public final class CoordinateLLA implements Coordinate<CoordinateLLA>, ConvertibleCoordinate<CoordinateECEF> {
	private double latitude, longitude, altitude;
		
	public CoordinateLLA(double latitude, double longitude, double altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	public double getLinearDistanceTo(CoordinateLLA destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getLinearGroundDistanceTo(CoordinateLLA destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CoordinateECEF convertTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public double getLatitude() {
		return latitude;
	}
	
	public String toString() {
		return "(" + this.latitude + "," + this.longitude + "," + this.altitude + ")";
	}

}
