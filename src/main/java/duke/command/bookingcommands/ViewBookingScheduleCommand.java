package duke.command.bookingcommands;

import duke.command.CommandBooking;
import duke.exception.DukeException;
import duke.list.bookinglist.BookingList;
import duke.storage.BookingStorage;
import duke.task.bookingtasks.Booking;
import duke.ui.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static duke.common.Messages.ERROR_MESSAGE_GENERAL;
import static duke.common.Messages.ERROR_MESSAGE_VIEWSCHEDULE;

public class ViewBookingScheduleCommand extends CommandBooking {

    public ViewBookingScheduleCommand(String userInputCommand) {
        this.userInputCommand = userInputCommand;
    }

    @Override
    public ArrayList<String> execute(BookingList bookingList, Ui ui, BookingStorage bookingStorage) throws DukeException, ParseException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (userInputCommand.trim().equals("viewbookingschedule")) {
            arrayList.add(ERROR_MESSAGE_GENERAL + ERROR_MESSAGE_VIEWSCHEDULE);
        }
        String inputDate = userInputCommand.substring(20).trim();
        Date currDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(currDate);

        int currDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currMonth = calendar.get(Calendar.MONTH);
        int currYear = calendar.get(Calendar.YEAR);

        ArrayList<Booking> scheduleList = new ArrayList<>();
        for (Booking booking : bookingList.getBookingList()) {
            //        if (task.getTaskType() == Task.TaskType.DEADLINE) {
            calendar.setTime(booking.getDateTime());
            int taskDay = calendar.get(Calendar.DAY_OF_MONTH);
            int taskMonth = calendar.get(Calendar.MONTH);
            int taskYear = calendar.get(Calendar.YEAR);
            if (taskYear == currYear && taskMonth == currMonth && taskDay == currDay) {
                scheduleList.add(booking);
            }
            //         }
        }

        String outputDate = new SimpleDateFormat("dd MMMM yyyy").format(currDate);
        if (scheduleList.isEmpty()) {
            arrayList.add("      No booking on " + outputDate);
        } else {
            arrayList.add("      Here are your bookings for " + outputDate);
            for (int i = 0; i < scheduleList.size(); i++) {
                arrayList.add("      " + (i + 1) + ". " + scheduleList.get(i));
            }
        }
        return arrayList;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}