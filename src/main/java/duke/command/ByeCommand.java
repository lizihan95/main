package duke.command;

import duke.ingredientlist.IngredientList;
import duke.storage.IngredientStorage;
import duke.ui.Ui;

/**
 * Handles the bye command and inherits all the fields and methods of Command parent class.
 */
public class ByeCommand extends Command {

    /**
     * Display the exit message and the program.
     * @param ingredientList contains the task list
     * @param ui deals with interactions with the user
     * @param ingredientStorage deals with loading tasks from the file and saving tasks in the file
     */
    @Override
    public void execute(IngredientList ingredientList, Ui ui, IngredientStorage ingredientStorage) {
        ui.showGoodbye();
        isExit();
    }

    /**
     * A flag to raise a request to exit the program.
     * @return true if user wants to exit the program
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
