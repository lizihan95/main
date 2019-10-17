package duke.common;

public class RecipeMessages {
    public static final String COMMAND_ADD_RECIPE_TITLE = "addrecipetitle";
    public static final String COMMAND_ADD_RECIPE_INGREDIENT = "addrecipeingredient";
    public static final String COMMAND_LIST_RECIPES = "listallrecipes";
    public static final String COMMAND_LIST_RECIPE_INGREDIENT = "listingredient";
    public static final String COMMAND_DELETE_RECIPE_INGREDIENT = "delri";
    public static final String COMMAND_DELETE_RECIPE_TITLE = "delrt";
    public static final String COMMAND_DELETE_PREPSTEP = "delp";

    public static final String COMMAND_ADD_FEEDBACK = "addfeedback";
    public static final String COMMAND_ADD_RATING = "addrating";
    public static final String COMMAND_ADD_PREPSTEP = "addprepstep";

    public static final String MESSAGE_DELETE_RECIPE = "     Noted. I've removed this ingredient:\n";
    public static final String MESSAGE_DELETE_PREPSTEP = "     Noted. I've removed this step:\n";

    public static final String ERROR_MESSAGE_INVALID_RECIPE_QUANTITY = "Please input a valid value for the quantity";
    public static final String ERROR_MESSAGE_INVALID_RECIPE_INDEX = "Please input a valid value for the index";
    public static final String ERROR_MESSAGE_RECIPE_INCOMPLETE = "     Please provide all information needed.";
    public static final String ERROR_MESSAGE_INVALID_RECIPE_FORMAT = "     Please input in this format:\n     Eg: addrecipeingredient garlic 100 grams.";
}
