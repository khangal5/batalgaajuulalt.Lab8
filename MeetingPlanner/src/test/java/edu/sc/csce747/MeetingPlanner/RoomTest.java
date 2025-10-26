package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {

	private Room room;

	@Before
	public void setUp() {
		room = new Room("1A01");
	}

	@Test
	public void testAddMeetingConflict() {
		try {
			Meeting m1 = new Meeting(2, 20, 9, 11, new ArrayList<>(), room, "Meeting 1");
			room.addMeeting(m1);

			Meeting m2 = new Meeting(2, 20, 10, 12, new ArrayList<>(), room, "Meeting 2");
			room.addMeeting(m2);

		} catch (TimeConflictException e) {
			fail("Expected TimeConflictException was not thrown for overlapping meeting");
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testIsBusyReturnsTrue() {
		try {
			Meeting m = new Meeting(5, 5, 14, 15);
			room.addMeeting(m);
			assertTrue(room.isBusy(5, 5, 14, 15));
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testPrintAgendaDoesNotThrow() {
		try {
			room.printAgenda(5);
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}
}
