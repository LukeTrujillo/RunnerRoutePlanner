package core.utility.coordinates;

public interface Coordinate<T> {
	double getLinearDistanceTo(T destination);
	double getLinearGroundDistanceTo(T destination);
}
