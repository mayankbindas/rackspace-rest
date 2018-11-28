package org.rackspace.test.rest.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.rackspace.test.rest.domain.Vehicle;
import org.rackspace.test.rest.repository.VehicleRepository;
import org.rackspace.test.rest.resource.VehicleResource;
import org.rackspace.test.rest.resource.VehicleResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Vehicle.class)
@RequestMapping(value = "/vehicle", produces = "application/json")
public class VehicleController {
	
	@Autowired
	private VehicleRepository repository;
	
	@Autowired
	private VehicleResourceAssembler assembler;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<VehicleResource>> findAllVehicles() {
		List<Vehicle> vehicles = repository.findAll();
		return new ResponseEntity<>(assembler.toResourceCollection(vehicles), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<VehicleResource> createVehicle(@RequestBody Vehicle vehicle) {
		Vehicle createdVehicle = repository.create(vehicle);
		return new ResponseEntity<>(assembler.toResource(createdVehicle), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VehicleResource> findVehicleById(@PathVariable Long id) {
		Optional<Vehicle> vehicle = repository.findById(id);

		if (vehicle.isPresent()) {
			return new ResponseEntity<>(assembler.toResource(vehicle.get()), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
		boolean wasDeleted = repository.delete(id);
		HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(responseStatus);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<VehicleResource> updateVehicle(@PathVariable Long id, @RequestBody Vehicle updatedVehicle) {
		boolean wasUpdated = repository.update(id, updatedVehicle);
		
		if (wasUpdated) {
			return findVehicleById(id);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
