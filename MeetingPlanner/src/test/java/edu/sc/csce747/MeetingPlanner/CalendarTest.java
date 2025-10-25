package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CalendarTest {

    private Calendar calendar;

    @Before
    public void setUp() {
        calendar = new Calendar();
    }

    @Test
    public void testAddMeeting_holiday() {
        try {
            Meeting midsommar = new Meeting(6, 26, "Midsommar");
            calendar.addMeeting(midsommar);
            Boolean added = calendar.isBusy(6, 26, 0, 23);
            assertTrue("Midsommar should be marked as busy on the calendar", added);
        } catch (TimeConflictException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidDay_Feb35() {
        try {
            Meeting invalid = new Meeting(2, 35, 10, 11);
            calendar.addMeeting(invalid);
            fail("Expected TimeConflictException was not thrown");
        } catch (TimeConflictException e) {
            // Exception гарсан тул тест pass
        }
    }

    @Test
    public void testInvalidMonth_13() {
        try {
            Meeting invalid = new Meeting(13, 5, 9, 10);
            calendar.addMeeting(invalid);
            fail("Expected TimeConflictException was not thrown");
        } catch (TimeConflictException e) {
            // Exception гарсан тул тест pass
        }
    }

    @Test
    public void testInvalidStartTime() {
        try {
            Meeting invalid = new Meeting(3, 10, -2, 10);
            calendar.addMeeting(invalid);
            fail("Expected TimeConflictException was not thrown");
        } catch (TimeConflictException e) {
            // Exception гарсан тул тест pass
        }
    }

    @Test
    public void testInvalidEndTime() {
        try {
            Meeting invalid = new Meeting(4, 10, 10, 25);
            calendar.addMeeting(invalid);
            fail("Expected TimeConflictException was not thrown");
        } catch (TimeConflictException e) {
            // Exception гарсан тул тест pass
        }
    }

    @Test
    public void testStartEqualsEnd() {
        try {
            Meeting invalid = new Meeting(5, 10, 9, 9);
            calendar.addMeeting(invalid);
            fail("Expected TimeConflictException was not thrown");
        } catch (TimeConflictException e) {
            // Exception гарсан тул тест pass
        }
    }

    @Test
    public void testMeetingOverlap() {
        try {
        	Meeting m1 = new Meeting(6, 6, 9, 11, null, new Room("2A01"), "Meeting 1");
            calendar.addMeeting(m1);

            Meeting m2 = new Meeting(6, 6, 10, 12, null, new Room("2A01"), "Meeting 2");
            calendar.addMeeting(m2);
            fail("Expected TimeConflictException was not thrown for overlapping meeting");
        } catch (TimeConflictException e) {
            // Exception гарсан тул тест pass
        }
    }

    @Test
    public void testInvalidGetMeetingIndex() {
        try {
            calendar.getMeeting(5, 5, 0);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception гарсан тул тест pass
        }
    }

    @Test
    public void testInvalidRemoveMeetingIndex() {
        try {
            Meeting m = new Meeting(7, 7, 9, 10);
            calendar.addMeeting(m);
            calendar.removeMeeting(7, 7, 1);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (TimeConflictException e) {
            fail("Unexpected TimeConflictException: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            // Exception гарсан тул тест pass
        }
    }
}
