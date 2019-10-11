package duke.recipelist;

import duke.model.recipe.Recipe;
import duke.task.recipetasks.PrepStep;
import duke.task.recipetasks.RecipeIngredient;

import java.text.ParseException;
import java.util.ArrayList;

import static duke.common.Messages.*;

public class RecipeList {

    private static String msg = "";
    private ArrayList<Recipe> recipeList;

    private ArrayList<RecipeIngredient> recipeIngredient;
    private ArrayList<PrepStep> prepStep;
    private static String feedback;
    private static String rating;

    public RecipeList() {
        this.recipeIngredient = new ArrayList<RecipeIngredient>();
        this.prepStep = new ArrayList<PrepStep>();
        this.feedback = feedback;
        this.rating = rating;
    }

    public RecipeList(ArrayList<Recipe> recipeList) {
        this.recipeIngredient = new ArrayList<RecipeIngredient>();
        this.prepStep = new ArrayList<PrepStep>();
        this.feedback = feedback;
        this.rating = rating;
    }

//    public ArrayList<String> listRecipe() {
//        ArrayList<String> arrList = new ArrayList<>();
//        for (int i = 0; i < getSize(); i++) {
//            final int displayedIndex = i + DISPLAYED_INDEX_OFFSET;
//            arrList.add("     " + displayedIndex + ". " + RecipeList.get(i));
//        }
//        return arrList;
//    }

    public void addRecipe(ArrayList<RecipeIngredient> recipeIngredient, ArrayList<PrepStep> prepStep, String feedback, String rating) throws ParseException {
        recipeList.add(new Recipe(recipeIngredient, prepStep, feedback, rating));
        int index = recipeList.size();
        if (index == 1) {
            msg = " recipe in the list.";
        } else {
            msg = MESSAGE_ITEMS2;
        }
        System.out.println(MESSAGE_ADDED + "       " + recipeList.get(index - 1) + "\n" + MESSAGE_ITEMS1 + index + msg);
    }

    // delete recipe by index on list
//    public void deleteIngredient(int i) {
//        if (ingredientList.size() - 1 <= 1) {
//            msg = " task in the list.";
//        } else {
//            msg = MESSAGE_ITEMS2;
//        }
//        System.out.println(MESSAGE_DELETE + "       " + ingredientList.get(i)
//                + "\n" + MESSAGE_ITEMS1 + (ingredientList.size() - 1) + msg);
//        ingredientList.remove(ingredientList.get(i));
//    }

    public int getSize() {
        return recipeList.size();
    }

    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }
}
