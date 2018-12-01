package org.rackspace.rest.domain;

import org.rackspace.rest.domain.engine.DieselEngine;

public class Truck extends Vehicle {

	public Truck() {
		vehicleEngine = new DieselEngine();
	}
}
