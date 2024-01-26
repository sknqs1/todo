package com.example.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static List<Task> tasks = createSampleTasks();

    private static List<Task> createSampleTasks() {
        List<Task> sampleTasks = new ArrayList<>();
        sampleTasks.add(new Task("ZADANIE 1", "https://www.youtube.com/")); // Dodane zadanie z linkiem do YouTube
        sampleTasks.add(new Task("ZADANIE 2"));
        sampleTasks.add(new Task("ZADANIE 3"));
        return sampleTasks;
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void markTaskAsCompleted(Task task) {
        if (!task.isCompleted()) {
            task.setCompleted(true);
            tasks.remove(task);
        }
    }

    public static void clearTasks() {
        tasks.clear();
    }
}