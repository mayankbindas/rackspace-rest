package org.rackspace.rest.domain;

import org.rackspace.rest.domain.engine.CoalEngine;

public class Train extends Vehicle {

	public Train() {
		vehicleEngine = new CoalEngine();
	}
}
