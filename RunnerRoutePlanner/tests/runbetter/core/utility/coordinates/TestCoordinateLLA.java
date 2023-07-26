package runbetter.core.utility.coordinates;

import static org.junit.Assert.*;

import org.junit.Test;

import core.utility.coordinates.CoordinateECEF;
import core.utility.coordinates.CoordinateLLA;

public class TestCoordinateLLA {

	@Test
	public void testToECEF() {
		CoordinateLLA c1 = new CoordinateLLA(70.0, -95.0, 10.0);
		CoordinateECEF c2 = c1.toECEF();
		assertEquals(-190690.76, c2.getX(), 0.001);
		assertEquals(-2179605.33, c2.getY(), 0.001);
		assertEquals(5971049.40, c2.getZ(), 0.001);
	}

}
