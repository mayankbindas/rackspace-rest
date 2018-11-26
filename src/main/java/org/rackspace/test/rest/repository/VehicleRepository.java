package org.rackspace.test.rest.repository;

import org.rackspace.test.rest.domain.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepository extends InMemoryRepository<Vehicle> {

	protected void updateIfExists(Vehicle original, Vehicle updated) {
		original.setDescription(updated.getDescription());
		original.setCostInCents(updated.getCostInCents());
	}
}
