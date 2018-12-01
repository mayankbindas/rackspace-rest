package org.rackspace.rest.domain.engine;

public class CoalEngine implements VehicleEngine {
	
	@Override
	public boolean start() {
		return true;
	}

	@Override
	public boolean stop() {
		return true;
	}

}
