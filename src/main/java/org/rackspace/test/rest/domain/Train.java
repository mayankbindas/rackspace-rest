package org.rackspace.test.rest.domain;

import org.rackspace.test.rest.domain.engine.CoalEngine;

public class Train extends Vehicle {

	public Train() {
		vehicleEngine = new CoalEngine();
	}
}
