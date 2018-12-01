package org.rackspace.rest.domain;

import org.rackspace.rest.domain.engine.VehicleEngine;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = Train.class, name = "train"), 
		  @Type(value = Truck.class, name = "truck") 
		})
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
