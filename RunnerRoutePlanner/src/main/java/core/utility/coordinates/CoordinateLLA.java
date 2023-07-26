package core.utility.coordinates;

public final class CoordinateLLA {
	private double latitude, longitude, altitude;
		
	public CoordinateLLA(double latitude, double longitude, double altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
	
	public CoordinateLLA(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = 0.0;
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
	
	public CoordinateECEF toECEF() {
		// https://en.wikipedia.org/wiki/Geographic_coordinate_conversion#From_geodetic_to_ECEF_coordinates
		double N_of_phi, X, Y, Z, b, a, e_2;
		
		a = 6378137.0;
		b = 6356753.314245;
		
		e_2 = 1 - (Math.pow(b, 2) / Math.pow(a, 2));
		N_of_phi = a / (Math.sqrt(1 - e_2 * Math.pow(Math.sin(latitude), 2)));

		X = (N_of_phi + altitude) * Math.cos(latitude) * Math.cos(longitude);
		Y = (N_of_phi + altitude) * Math.cos(latitude) * Math.sin(longitude);
		Z = ((Math.pow(b, 2) / Math.pow(a, 2) * N_of_phi) + altitude) * Math.sin(latitude);
		
		return new CoordinateECEF(X, Y, Z);
	}

}
