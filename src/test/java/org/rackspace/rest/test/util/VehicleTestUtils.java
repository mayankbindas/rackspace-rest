package org.rackspace.rest.test.util;

import org.junit.Assert;
import org.rackspace.rest.domain.Truck;
import org.rackspace.rest.domain.Vehicle;

public class VehicleTestUtils {

	public static void assertAllButIdsMatchBetweenVehicles(Vehicle expected, Vehicle actual) {
		Assert.assertEquals(expected.getDescription(), actual.getDescription());
		Assert.assertEquals(expected.getCostInCents(), actual.getCostInCents());
	}

	public static Vehicle generateTestTruck() {
		Vehicle truck = new Truck();
		truck.setDescription("test description");
		truck.setCostInCents(150L);
		return truck;
	}

	public static Vehicle generateUpdatedTruck(Vehicle original) {
		Vehicle updated = new Truck();
		updated.setDescription(original.getDescription() + " updated");
		updated.setCostInCents(original.getCostInCents() + 100);
		return updated;
	}
}
