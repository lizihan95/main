package duke.command;

import duke.exception.DukeException;
import duke.list.ingredientlist.IngredientList;
import duke.list.recipelist.RecipeIngredientList;
import duke.list.recipelist.RecipeList;
import duke.storage.IngredientStorage;
import duke.storage.RecipeIngredientStorage;
import duke.ui.Ui;

import java.text.ParseException;
import java.util.ArrayList;

public abstract class CommandRecipeIngredient {
    protected String userInput;
    protected CommandType commandType;

    public enum CommandType {
        BOOKING, RECIPE, INGREDIENT
    }

    public abstract ArrayList<String> feedback(RecipeIngredientList recipeIngredientList, Ui ui, RecipeIngredientStorage recipeIngredientStorage) throws DukeException, ParseException;

    public abstract boolean isExit();
}