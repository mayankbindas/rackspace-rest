package org.rackspace.test.rest.domain;

import org.rackspace.test.rest.domain.engine.DieselEngine;

public class Truck extends Vehicle {

	public Truck() {
		vehicleEngine = new DieselEngine();
	}
}
