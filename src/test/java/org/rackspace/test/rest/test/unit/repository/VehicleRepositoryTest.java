package org.rackspace.test.rest.test.unit.repository;

import static org.rackspace.test.rest.test.util.VehicleTestUtils.assertAllButIdsMatchBetweenVehicles;
import static org.rackspace.test.rest.test.util.VehicleTestUtils.generateTestTruck;
import static org.rackspace.test.rest.test.util.VehicleTestUtils.generateUpdatedTruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rackspace.test.rest.domain.Truck;
import org.rackspace.test.rest.domain.Vehicle;
import org.rackspace.test.rest.repository.VehicleRepository;
import org.rackspace.test.rest.test.unit.AppConfigUnitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfigUnitTest.class})
public class VehicleRepositoryTest {
	
	private static final long NONEXISTENT_ID = 1000;

	@Autowired
	private VehicleRepository repository;
	
	@Before
	public void setUp() {
		repository.clear();
	}
	
	@Test
	public void testFindNonexistentOrderEnsureOptionalIsNotPresent() throws Exception {
		assertNoExistingOrders();
		Optional<Vehicle> vehicle = repository.findById(NONEXISTENT_ID);
		Assert.assertFalse(vehicle.isPresent());
	}
	
	@Test
	public void testFindExistingOrderEnsureOptionalIsPresent() throws Exception {
		Vehicle injectedOrder = injectOrder();
		Optional<Vehicle> foundOrder = repository.findById(injectedOrder.getId());
		Assert.assertTrue(foundOrder.isPresent());
	}

	@Test
	public void testFindAllWithOneExistingOrdersEnsureOneOrdersFound() throws Exception {
		assertFindAllIsCorrectWithOrderCount(1);
	}
	
	@Test
	public void testFindAllWithTwoExistingOrdersEnsureTwoOrdersFound() throws Exception {
		assertFindAllIsCorrectWithOrderCount(2);
	}
	
	@Test
	public void testFindAllWithTwoExistingOrderEnsureFirstOrderIsCorrect() throws Exception {
		List<Vehicle> injectedOrders = injectGivenNumberOfOrders(2);
		List<Vehicle> ordersFound = repository.findAll();
		assertOrdersMatch(injectedOrders.get(0), ordersFound.get(0));
	}

	@Test
	public void testFindAllWithTwoExistingOrderEnsureSecondOrderIsCorrect() throws Exception {
		List<Vehicle> injectedOrders = injectGivenNumberOfOrders(2);
		List<Vehicle> ordersFound = repository.findAll();
		assertOrdersMatch(injectedOrders.get(1), ordersFound.get(1));
	}
	
	@Test
	public void testDeleteNonexistentOrderEnsureNoOrderDeleted() throws Exception {
		assertNoExistingOrders();
		boolean wasDeleted = repository.delete(NONEXISTENT_ID);
		Assert.assertFalse(wasDeleted);
	}

	@Test
	public void testDeleteExistingOrderEnsureOrderDeleted() throws Exception {
		Vehicle injectedOrder = injectOrder();
		assertExistingOrderCountIs(1);
		boolean wasDeleted = repository.delete(injectedOrder.getId());
		Assert.assertTrue(wasDeleted);
		assertNoExistingOrders();
	}
	
	@Test
	public void testUpdateNonexistentOrderEnsureNoUpdateMade() throws Exception {
		assertNoExistingOrders();
		boolean wasUpdated = repository.update(NONEXISTENT_ID, new Truck());
		Assert.assertFalse(wasUpdated);
	}
	
	@Test
	public void testUpdateExistingOrderEnsureUpdateMade() throws Exception {
		Vehicle injectedOrder = injectOrder();
		boolean wasUpdated = repository.update(injectedOrder.getId(), new Truck());
		Assert.assertTrue(wasUpdated);
	}
	
	@Test
	public void testUpdateExistingOrderEnsureOriginalOrderIsUpdated() throws Exception {
		Vehicle originalOrder = injectOrder();
		Vehicle updatedOrder = generateUpdatedTruck(originalOrder);
		repository.update(originalOrder.getId(), updatedOrder);
		assertAllButIdsMatchBetweenVehicles(updatedOrder, originalOrder);
	}
	
	@Test
	public void testUpdateExistingOrderWithNullUpdatedOrderEnsureNoUpdateMade() throws Exception {
		Vehicle injectedOrder = injectOrder();
		boolean wasUpdated = repository.update(injectedOrder.getId(), null);
		Assert.assertFalse(wasUpdated);
	}
	
	@Test
	public void testFindExistingOrderEnsureCorrectOrderValues() throws Exception {
		Vehicle injectedOrder = injectOrder();
		Optional<Vehicle> foundOrder = repository.findById(injectedOrder.getId());
		assertOrdersMatch(injectedOrder, foundOrder.get());
	}

	@Test
	public void testFindAllWithNoExistingOrdersEnsureNoOrdersFound() throws Exception {
		assertFindAllIsCorrectWithOrderCount(0);
	}
	
	private void assertNoExistingOrders() {
		assertExistingOrderCountIs(0);
	}
	
	private void assertExistingOrderCountIs(int count) {
		Assert.assertEquals(count, repository.getCount());
	}

	private Vehicle injectOrder() {
		Vehicle createdOrder = repository.create(generateTestTruck());
		return createdOrder;
	}
	
	private static void assertOrdersMatch(Vehicle expected, Vehicle actual) {
		Assert.assertEquals(expected.getId(), actual.getId());
		assertAllButIdsMatchBetweenVehicles(expected, actual);
	}
	
	private void assertFindAllIsCorrectWithOrderCount(int count) {
		injectGivenNumberOfOrders(count);
		assertExistingOrderCountIs(count);
		List<Vehicle> ordersFound = repository.findAll();
		Assert.assertEquals(count, ordersFound.size());
	}
	
	private List<Vehicle> injectGivenNumberOfOrders(int count) {
		
		List<Vehicle> injectedOrders = new ArrayList<>();
		
		for (int i = 0; i < count; i++) {
			injectedOrders.add(injectOrder());
		}
		
		return injectedOrders;
	}
}
