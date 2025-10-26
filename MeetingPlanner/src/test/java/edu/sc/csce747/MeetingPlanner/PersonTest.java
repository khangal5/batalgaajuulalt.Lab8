package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	private Person person;

	@Before
	public void setUp() {
		person = new Person("Tester");
	}

	@Test
	public void testAddMeetingAndConflict() {
		try {
			Meeting m1 = new Meeting(3, 10, 9, 11, new ArrayList<>(), null, "Meeting 1");
			person.addMeeting(m1);

			Meeting m2 = new Meeting(3, 10, 10, 12, new ArrayList<>(), null, "Meeting 2");
			person.addMeeting(m2);

		} catch (TimeConflictException e) {
			fail("Expected TimeConflictException was not thrown for overlapping meeting");
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testIsBusyAfterAddingMeeting() {
		try {
			Meeting m = new Meeting(3, 15, 13, 14);
			person.addMeeting(m);
			assertTrue(person.isBusy(3, 15, 13, 14));
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveMeetingInvalidIndex() {
		try {
			Meeting m = new Meeting(4, 4, 9, 10);
			person.addMeeting(m);
			person.removeMeeting(4, 4, 1);

		} catch (IndexOutOfBoundsException e) {
			fail("Expected IndexOutOfBoundsException was not thrown");
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}
}
