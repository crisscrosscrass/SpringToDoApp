package crisscrosscrass.SpringToDoApp.models;

public class Task {

    private String title;
    private String description;
    private int taskId;
    private static int nextId = 1;

    public Task(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }

    public Task() {
        taskId = nextId;
        nextId++;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
