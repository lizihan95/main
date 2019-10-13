package duke.command.recipecommands;

import duke.command.CommandRecipeTitle;
import duke.list.recipelist.RecipeTitleList;
import duke.storage.RecipeTitleStorage;
import duke.ui.Ui;

import java.text.ParseException;
import java.util.ArrayList;

import static duke.common.Messages.*;
import static duke.common.RecipeMessages.COMMAND_ADD_RECIPE_TITLE;

public class AddRecipeTitleCommand extends CommandRecipeTitle {

    public AddRecipeTitleCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public ArrayList<String> execute(RecipeTitleList recipeTitleList, Ui ui, RecipeTitleStorage recipeTitleStorage) throws ParseException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (userInput.trim().equals(COMMAND_ADD_RECIPE_TITLE)) {
            arrayList.add(ERROR_MESSAGE_GENERAL + MESSAGE_FOLLOWUP_NUll);
            System.out.println("stuck here 7");
        } else if (userInput.trim().charAt(14) == ' ') {
            if (userInput.trim().contains("n/")) {
                String recipeTitle = userInput.split("n/", 2)[1].trim();
                recipeTitleList.addRecipeTitle(recipeTitle);
                System.out.println("added tasks");
                recipeTitleStorage.saveFile(recipeTitleList);
                arrayList.add(MESSAGE_ADDED + "       " + recipeTitleList.getRecipeTitleList().get(recipeTitleList.getSize() - 1) + "\n" + "Now you have " + recipeTitleList.getSize() + " tasks in the list.");
            } else {
                arrayList.add(ERROR_MESSAGE_RANDOM);
            }
        } else {
            arrayList.add(ERROR_MESSAGE_RANDOM);
        }
        return arrayList;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}