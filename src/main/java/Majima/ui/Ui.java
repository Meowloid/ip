package Majima.ui;

import Majima.task.Task;
import Majima.task.TaskList;

import java.util.List;
import java.util.Scanner;

public class Ui {

    private StringBuilder output;

    public Ui() {
        this.output = new StringBuilder();
    }

    public void clearOutput() {
        output.setLength(0); // Clears the output
    }

    public String getOutput() {
        return output.toString(); // Returns the collected output
    }

    private void appendLine() {
        output.append("____________________________________________________________\n");
    }

    /**
     * Runs at the start to greet the user.
     */
    public void userGreet() {
        appendLine();
        output.append("KIIIIIRYU-CHAN! It's ya old pal, Majima!\n");
        output.append("What can I do fer ya?\n");
        appendLine();
    }

    public void showError(String message) {
        appendLine();
        output.append("Error: ").append(message).append("\n");
        appendLine();
    }

    public void showTaskList(TaskList tasks) {
        appendLine();
        if (tasks.isEmpty()) {
            output.append("おめでとう, Kiryu-chan! There ain't nothing to do left!\n");
        } else {
            output.append("Here's whatcha gotta do, Kiryu-chan!\n");
            for (int i = 0; i < tasks.size(); i++) {
                output.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
        }
        appendLine();
    }

    public void showTaskAdded(Task task) {
        appendLine();
        output.append("Understood, Kiryu-chan! This is goin' into the list: ").append(task).append("\n");
        appendLine();
    }

    public void showTaskDeleted(Task task) {
        appendLine();
        output.append("Gotcha, Kiryu. Axin' this task off the list: ").append(task).append("\n");
        appendLine();
    }

    public void showGoodbye() {
        appendLine();
        output.append("Bye bye! Don't keep me waiting fer too long now, ya hear?\n");
        appendLine();
    }

    public void showTaskMarked(Task task) {
        appendLine();
        output.append("Okay, I've gone ahead and marked that one fer ya.\n").append("  ").append(task).append("\n");
        appendLine();
    }

    public void showTaskUnmarked(Task task) {
        appendLine();
        output.append("Okay, I've gone ahead and unmarked that one fer ya.\n").append("  ").append(task).append("\n");
        appendLine();
    }

    public void showFoundTasks(List<Task> tasks, String keyword) {
        appendLine();
        if (tasks.isEmpty()) {
            output.append("Kiryu! There ain't no tasks matching that description!\n");
        } else {
            output.append("I found these tasks matching yer description:\n");
            for (int i = 0; i < tasks.size(); i++) {
                output.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
        }
        appendLine();
    }

    public String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
