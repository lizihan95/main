package duke;

import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;
import java.text.ParseException;

import static duke.common.Messages.filePath;

/**
 * Duke processes different commands.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

//    private MainWindow mainWindow;

//    /**
//     * Constructor for Duke class to instantiation Ui, Storage, TaskList classes.
//     * @param filePath String containing the directory in which the tasks are to be stored
//     */
    public Duke(Ui ui) {
        this.ui = ui;
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

//    /**
//     * Method to start the program.
//     */
//    public void run() {
//        ui.showWelcome();
//        boolean isExit = false;
//        while (!isExit) {
//            try {
//                String fullCommand = ui.readCommand();
//                ui.showLine();
//                Command c = Parser.parse(fullCommand);
//                c.execute(tasks, ui, storage);
//                isExit = c.isExit();
//            } catch (DukeException e) {
//                ui.showError(e.getMessage());
//            } finally {
//                ui.showLine();
//            }
//        }
//    }
//
//    /**
//     * Starting the program.
//     * @param args the command line parameter
//     */
//    public static void main(String[] args) {
//        new Duke(filePath).run();
//    }

    public void runProgram(String fullCommand) throws DukeException, ParseException {
        Command c = Parser.parse(fullCommand);
        c.execute(tasks, ui, storage);
    }

    /**
     * Gets response from Duke.
     * @param input String input from user
     * @return String output
     * @throws DukeException if not able to find any matching items
     */
    public String getResponse(String input) throws DukeException {
        String output = "";
        if (input.contains("list")) {
            output =  "Duke heard: " + tasks.listTask();
        } else if (input.contains("find")) {
            output = "Duke heard: " + tasks.findTask(input.trim().split("\\s", 2)[1]);
        } else {
            output = "unknown";
        }
        return output;
    }

    public ArrayList<String> getList(){
        TaskList taskList = new TaskList();
//        for (int i = 0; i < tasks.listTask().size(); i++) {
        ArrayList<String> arrayList = new ArrayList<>(tasks.listTask());
//        }
        return arrayList;
    }
}