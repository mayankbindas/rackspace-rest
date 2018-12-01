package org.rackspace.rest.resource;

import org.rackspace.rest.domain.Vehicle;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleResource extends ResourceSupport {

	private final long id;
	private final String description;
	private final long costInCents;
	
	public VehicleResource(Vehicle order) {
		id = order.getId();
		description = order.getDescription();
		costInCents = order.getCostInCents();
	}

	@JsonProperty("id")
	public Long getResourceId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public long getCostInCents() {
		return costInCents;
	}

}
