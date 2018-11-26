package org.rackspace.test.rest.domain;

import org.rackspace.test.rest.domain.engine.VehicleEngine;

public abstract class Vehicle implements Identifiable {
	
	protected VehicleEngine vehicleEngine;
	
	private Long id;
	private String description;
	private long costInCents;
	
	public boolean start() {
		return vehicleEngine.start();
	}
	
	public boolean stop() {
		return vehicleEngine.stop();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCostInCents() {
		return costInCents;
	}

	public void setCostInCents(long costInCents) {
		this.costInCents = costInCents;
	}
	
//	protected void setVehicleBehavior(VehicleBehavior vehicleBehavior) {
//		this.vehicleBehavior = vehicleBehavior;
//	}
}
