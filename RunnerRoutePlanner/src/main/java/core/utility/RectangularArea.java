package core.utility;

import core.utility.coordinates.CoordinateECEF;

public class RectangularArea {

	private CoordinateECEF corners[];

	public RectangularArea(CoordinateECEF[] corners) {
		this.corners = corners;
	}

	public boolean isValid() {
		return true;
		// checks if really a rectangular area
	}

	public double length() {
		 return this.upperX() - this.lowerX();
	}
	
	public double width() {
		return this.upperY() - this.lowerY();
	}
	
	public double height() {
		return this.upperZ() - this.lowerZ();
	}

	public double lowerX() {
		double lowerX = Double.MAX_VALUE;

		for (CoordinateECEF coord : this.corners) {
			if (lowerX > coord.getX()) {
				lowerX = coord.getX();
			}
		}
		return lowerX;
	}
	
	public double upperX() {
		double upperX = Double.MIN_VALUE;

		for (CoordinateECEF coord : this.corners) {
			if (upperX < coord.getX()) {
				upperX = coord.getX();
			}
		}
		return upperX;
	}
	
	public double lowerY() {
		double lowerY = Double.MAX_VALUE;

		for (CoordinateECEF coord : this.corners) {
			if (lowerY > coord.getY()) {
				lowerY = coord.getY();
			}
		}
		return lowerY;
	}
	
	public double upperY() {
		double upperY = Double.MIN_VALUE;

		for (CoordinateECEF coord : this.corners) {
			if (upperY < coord.getY()) {
				upperY = coord.getY();
			}
		}
		return upperY;
	}
	
	public double lowerZ() {
		double lowerZ = Double.MAX_VALUE;

		for (CoordinateECEF coord : this.corners) {
			if (lowerZ > coord.getZ()) {
				lowerZ = coord.getZ();
			}
		}
		return lowerZ;
	}
	
	public double upperZ() {
		double upperZ = Double.MIN_VALUE;

		for (CoordinateECEF coord : this.corners) {
			if (upperZ < coord.getZ()) {
				upperZ = coord.getZ();
			}
		}
		return upperZ;
	}

	public String toString() {
		String str = "";
		str += "length=" + this.length() + " width=" + this.width();
		
		return str;
	}


}
