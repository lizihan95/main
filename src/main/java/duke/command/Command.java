package duke.command;

import duke.exception.DukeException;
import duke.ingredientlist.IngredientList;
import duke.storage.IngredientStorage;
import duke.ui.Ui;

import java.text.ParseException;

/**
 * Abstract class to represent command.
 */
public abstract class Command {

    protected String userInput;
    public CommandType commandType;

    public enum CommandType {
        BOOKING, RECIPE, INGREDIENT
    }

    public abstract void execute(IngredientList ingredientList, Ui ui, IngredientStorage ingredientStorage) throws DukeException, ParseException;

    public abstract boolean isExit();
}
