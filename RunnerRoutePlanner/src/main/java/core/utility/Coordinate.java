package core.utility;

public class Coordinate {
	
	
	
	private double latitude; // deg
	private double longitude; // deg
	private double altitude; // m
	
	public Coordinate(double latitude, double longitude, double altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
	
	public double getLinearDistanceTo(Coordinate toCoord) {
		// Source: https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude
		double latDistance = Math.toRadians(toCoord.getLatitude() - this.latitude);
		double lonDistance = Math.toRadians(toCoord.getLongitude() - this.longitude);
		
		double a = Math.sin(latDistance / 2.0) * Math.sin(latDistance / 2.0)
				+ Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(toCoord.getLatitude()))
				* Math.sin(lonDistance / 2.0) * Math.sin(lonDistance / 2.0);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - 1));
		double distance = Utility.EARTH_RADIUS_KM * c * Utility.M_PER_KM;
		double height = this.altitude - toCoord.getAltitude();
		distance = Math.pow(distance, 2) + Math.pow(height, 2);
		return Math.sqrt(distance);
	}

	public double getLatitude() {
		return this.latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getAltitude() {
		return altitude;
	}
	
}
