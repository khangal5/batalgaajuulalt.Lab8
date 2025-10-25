package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class MeetingTest {

	@Test
	public void testInvalidTimes() {
		try {
			Meeting m = new Meeting();
			m.setStartTime(15);
			m.setEndTime(10);
			assertTrue("Энд буруу цагийн утга байна", m.getStartTime() > m.getEndTime());
		} catch (Exception e) {
			fail("Exception гарч болзошгүй: " + e.getMessage());
		}
	}

	@Test
	public void testFullConstructor() {
		try {
			ArrayList<Person> people = new ArrayList<>();
			people.add(new Person("Test User"));
			Room room = new Room("1A01");

			Meeting m = new Meeting(5, 20, 9, 10, people, room, "Team Meeting");
			assertEquals("Team Meeting", m.getDescription());
			assertEquals("1A01", m.getRoom().getID());
			assertEquals("Test User", m.getAttendees().get(0).getName());
		} catch (Exception e) {
			fail("Exception гарч болзошгүй: " + e.getMessage());
		}
	}

	@Test
	public void testToStringIncludesDescription() {
		try {
			ArrayList<Person> people = new ArrayList<>();
			Meeting m = new Meeting(10, 25, 13, 14, people, new Room("3B01"), "Planning");
			String s = m.toString();
			assertTrue(s.contains("Planning"));
			assertTrue(s.contains("3B01"));
		} catch (Exception e) {
			fail("Exception гарч болзошгүй: " + e.getMessage());
		}
	}
}
