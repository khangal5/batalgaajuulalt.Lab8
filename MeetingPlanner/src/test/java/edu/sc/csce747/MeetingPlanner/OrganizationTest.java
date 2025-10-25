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
			fail("Expected Exception was not thrown for invalid room");
		} catch (Exception e) {
			// Exception гарсан тул тест pass
		}
	}

	@Test
	public void testGetInvalidEmployee() {
		try {
			org.getEmployee("Unknown Person");
			fail("Expected Exception was not thrown for invalid employee");
		} catch (Exception e) {
			// Exception гарсан тул тест pass
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
