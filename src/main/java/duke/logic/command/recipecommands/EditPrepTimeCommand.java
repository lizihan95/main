package duke.logic.command.recipecommands;

import duke.logic.command.Command;
import duke.model.list.recipelist.RecipeList;
import duke.storage.RecipeStorage;
import duke.ui.Ui;

import java.text.ParseException;
import java.util.ArrayList;

import static duke.common.Messages.MESSAGE_FOLLOWUP_NUll;
import static duke.common.Messages.ERROR_MESSAGE_GENERAL;
import static duke.common.Messages.ERROR_MESSAGE_RANDOM;

import static duke.common.RecipeMessages.COMMAND_EDIT_PREPTIME;
import static duke.common.RecipeMessages.ERROR_MESSAGE_RECIPE_DOES_NOT_EXIST;
import static duke.common.RecipeMessages.ERROR_MESSAGE_EDIT_PREPTIME_INCOMPLETE;
import static duke.common.RecipeMessages.ERROR_MESSAGE_INVALID_PREPTIME;
import static duke.common.RecipeMessages.ERROR_MESSAGE_RATING_INCORRECT_FORMAT;

/**
 * Handles the edit preparation time command.
 */
public class EditPrepTimeCommand extends Command<RecipeList, Ui, RecipeStorage> {

    /**
     * Constructor for class EditPrepTimeCommand.
     *
     * @param userInput input command from user
     */
    public EditPrepTimeCommand(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Processes the edit preparation time command to edit the preparation time needed to prepare a specific dish.
     *
     * @param recipeList    contains the recipe list
     * @param ui             deals with interactions with the user
     * @param recipeStorage deals with loading tasks from the file and saving recipes in the file
     * @return an array list consist of the results or prompts to be displayed to user
     */
    @Override
    public ArrayList<String> execute(RecipeList recipeList, Ui ui, RecipeStorage recipeStorage) throws ParseException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (userInput.trim().equals(COMMAND_EDIT_PREPTIME)) {
            arrayList.add(ERROR_MESSAGE_GENERAL + MESSAGE_FOLLOWUP_NUll);
        } else if (userInput.trim().charAt(12) == ' ') {
            String description = userInput.split("\\s", 2)[1].trim();
            if (description.contains("t/")) {
                String recipeTitle, prepTime;
                String[] split = description.split("t/", 2);
                recipeTitle = split[0].trim();
                prepTime = split[1].trim();
                if (recipeTitle.isEmpty()) {
                    arrayList.add(ERROR_MESSAGE_EDIT_PREPTIME_INCOMPLETE);
                } else if (!recipeList.containsRecipe(recipeTitle)) {
                    arrayList.add(ERROR_MESSAGE_RECIPE_DOES_NOT_EXIST);
                } else {
                    if (Integer.parseInt(prepTime) > 0) {
                        recipeList.editPrepTime(recipeTitle, prepTime);
                        recipeStorage.saveFile(recipeList);
                        arrayList.add("The preparation time of " + "'" + recipeTitle + "'" + " has been edited to: " + prepTime);
                    } else {
                        arrayList.add(ERROR_MESSAGE_INVALID_PREPTIME);
                    }
                }
            } else {
                arrayList.add(ERROR_MESSAGE_RATING_INCORRECT_FORMAT);
            }

        } else {
            arrayList.add(ERROR_MESSAGE_RANDOM);
        }
        return arrayList;
    }
}
