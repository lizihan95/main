package duketest.bookingcommandstest;

import duke.model.task.bookingtasks.Booking;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@@author lizihan95
public class BookingTest {

    @Test
    public void BookingTest() throws ParseException {

        Booking bookingTest = new Booking("Kelvin", "81234567", "8", "1/1/2000", "beef burger, seafood pasta, chicken rice");

        String expectedToSaveString = "booking | Kelvin | 81234567 | 8 | 1/1/2000 | beef burger, seafood pasta, chicken rice";
        assertEquals(expectedToSaveString, bookingTest.toSaveString());

        String expectedToString = "[Customer name: Kelvin] [Contact No.: 81234567] [No. of pax: 8] [Booking on: 1 January 2000] [Orders: beef burger, seafood pasta, chicken rice]";
        assertEquals(expectedToString, bookingTest.toString());

        String expectedCustomerName = "Kelvin";
        assertEquals(expectedCustomerName, bookingTest.getCustomerName());

        String expectedBookingDate = "1/1/2000";
        assertEquals(expectedBookingDate, bookingTest.getBookingDate());

        String expectedFormattedDate = "1 January 2000";
        assertEquals(expectedFormattedDate, bookingTest.getBookingDateFormatted());

        System.out.println("Test passed.");

    }
}
