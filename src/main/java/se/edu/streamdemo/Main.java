package se.edu.streamdemo;

import se.edu.streamdemo.data.DataManager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task (stream) manager");
        DataManager dataManager = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dataManager.loadData();

        System.out.println("Printing all data ...");
        printAllDataUsingStreams(tasksData);

        System.out.println("Printing deadlines ...");
        printAllDeadlineUsingStreams(tasksData);

        System.out.println("Total number of deadlines: " + coundDeadlineUsingStreams(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static void printAllData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    /** The following method implements the previous one using streams instead of a for each loop
     *
     * @param tasks
     */
    public static void printAllDataUsingStreams(ArrayList<Task> tasks) {
        tasks.stream().forEach(System.out::println);
    }
    public static void printAllDeadlineUsingStreams(ArrayList<Task> tasks) {
        tasks.stream().filter((t) -> t instanceof Deadline).forEach(System.out::println);
    }
    private static int coundDeadlineUsingStreams(ArrayList<Task> tasks) {
        int count = 0;
        count = (int) tasks.stream()
                .filter((t) -> t instanceof Deadline).count();
        return count;
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

}