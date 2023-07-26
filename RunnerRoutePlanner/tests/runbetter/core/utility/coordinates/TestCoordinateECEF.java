package runbetter.core.utility.coordinates;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.utility.coordinates.CoordinateECEF;
import core.utility.coordinates.CoordinateLLA;

public class TestCoordinateECEF {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToLLA() {
		CoordinateECEF c1 = new CoordinateECEF(10, 5, 15);
		CoordinateLLA c2 = c1.toLLA();

	}

}
