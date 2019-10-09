package duke.parser;

import duke.command.ByeCommand;
import duke.command.Command;

import duke.command.ingredientcommands.AddIngredientCommand;
import duke.command.ingredientcommands.DeleteIngredientCommand;
import duke.command.ingredientcommands.ListIngredientsCommand;
import duke.exception.DukeException;

import static duke.common.GeneralMessages.ERROR_MESSAGE_RANDOM;
import static duke.common.GeneralMessages.COMMAND_BYE;
import static duke.common.IngredientMessages.*;


/**
 * Making sense of the user input command.
 */
public class Parser {

    public static Command parse(String userInput) throws DukeException {
        if (userInput.trim().equals(COMMAND_BYE)) {
            return new ByeCommand();
        } else if (userInput.trim().equals(COMMAND_LIST_INGREDIENTS)) {
            return new ListIngredientsCommand(userInput);
        } else if (userInput.contains(COMMAND_ADD_INGREDIENT)) {
            if (userInput.trim().substring(0, 13).equals(COMMAND_ADD_INGREDIENT)) {
                return new AddIngredientCommand(userInput);
            } else {
                throw new DukeException(ERROR_MESSAGE_RANDOM);
            }
        } else if (userInput.contains(COMMAND_DELETE_INGREDIENT)) {
            if (userInput.trim().substring(0, 16).equals(COMMAND_DELETE_INGREDIENT)) {
                return new DeleteIngredientCommand(userInput);
            } else {
                throw new DukeException(ERROR_MESSAGE_RANDOM);
            }
        }
        /*
        Repetitive throw new DukeException(ERROR_MESSAGE_RANDOM) can create a new UnknownCommand?
         */
        else {
            throw new DukeException(ERROR_MESSAGE_RANDOM);
        }
    }

}
