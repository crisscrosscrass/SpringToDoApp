package crisscrosscrass.SpringToDoApp.models;

import java.util.ArrayList;

public class TaskData {

    static ArrayList<Task> myTodoList = new ArrayList<>();

    //getAll
    public static ArrayList<Task> getAll(){
        return myTodoList;
    }

    //add
    public static void add(Task newTask){
        myTodoList.add(newTask);
    }

    //remove
    public static void remove(int id){
        Task taskToRemove = getById(id);
        myTodoList.remove(taskToRemove);
    }

    //getById
    public static Task getById(int id){
        Task theTask = null;

        for (Task lookingInToDo : myTodoList){
            if ( lookingInToDo.getTaskId() == id ){
                theTask = lookingInToDo;
            }
        }

        return theTask;
    }
}
