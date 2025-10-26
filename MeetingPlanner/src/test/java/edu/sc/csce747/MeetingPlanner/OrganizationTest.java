package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class OrganizationTest {

	private Organization org;

	@Before
	public void setUp() {
		org = new Organization();
	}

	@Test
	public void testGetInvalidRoom() {
		try {
			org.getRoom("999X");

		} catch (Exception e) {
			fail("Expected Exception was not thrown for invalid room");
		}
	}

	@Test
	public void testGetInvalidEmployee() {
		try {
			org.getEmployee("Unknown Person");

		} catch (Exception e) {
			fail("Expected Exception was not thrown for invalid employee");
		}
	}

	@Test
	public void testDefaultRoomsAndPeople() {
		try {
			assertEquals(5, org.getRooms().size());
			assertEquals(5, org.getEmployees().size());
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}
}
