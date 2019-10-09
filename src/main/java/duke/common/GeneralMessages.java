package duke.common;

/**
 * A class to store all the initialisation of the static error messages to String value.
 */
public class GeneralMessages {

    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public static final String filePathIngredients = "/Users/jiawei/Desktop/main/src/main/data/ingredients.txt";
    public static final String filePathBookings = "";
    public static final String filePathRecipes = "";

    public static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!";
    public static final String MESSAGE_FOLLOWUP_EMPTY_INDEX = "     Kindly enter the command again with an index.";
    public static final String MESSAGE_FOLLOWUP_NUll = "     Kindly enter the command again with a description.";
    public static final String MESSAGE_FOLLOWUP_CONFIRM = "      "
            + "Kindly enter command with the index of the tasks. Eg: confirm 2";
    public static final String MESSAGE_ITEMS1 = "     Now you have ";
    public static final String MESSAGE_ITEMS2 = " tasks in the list.";
    public static final String MESSAGE_MARKED = "     Nice! I've marked this task as done:\n";

    public static final String ERROR_MESSAGE_EMPTY_INDEX = "     OOPS!!! The index cannot be empty.\n";
    public static final String ERROR_MESSAGE_EMPTY_LIST = "     OOPS!!! The list is empty.\n     Kindly add a task.";
    public static final String ERROR_MESSAGE_GENERAL = "     OOPS!!! The description cannot be empty.\n";
    public static final String ERROR_MESSAGE_INVALID_DATE = "       "
            + "OOPS!!! Please specify the date and time in this format: \n       "
            + "[day/month/year time] Eg: 28/8/2019 2359";
    public static final String ERROR_MESSAGE_INVALID_INDEX = "     Invalid index entered.\n     "
            + "Kindly enter command with index not more than ";
    public static final String ERROR_MESSAGE_UNKNOWN_INDEX = "     Unknown index entered.\n     "
            + "Kindly enter an integer for the index.";
    public static final String ERROR_MESSAGE_LOADING = "     OOPS!!! Error loading file: ";
    public static final String ERROR_MESSAGE_NOTFOUND = "     "
            + "OOPS!!! I'm sorry, but there is no matching tasks in your list.";
    public static final String ERROR_MESSAGE_RANDOM = "     OOPS!!! I'm sorry, but I don't know what that means. :-(";


    public static final String COMMAND_BYE = "bye";

    public static final String DIVIDER = "   ____________________________________________________________\n";
}
