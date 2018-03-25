package com.example.amrihanif.amri_1202150075_studycase5;


/**
 * Created by Amri hanif on 24/03/2018.
 */

public class ModelToDo {
   String nameTodo, description, priority;

   public ModelToDo(String nameTodo, String description, String priority){
       this.nameTodo = nameTodo;
       this.description = description;
       this.priority = priority;
   }

    public void setNameTodo(String nameTodo) {
        this.nameTodo = nameTodo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNameTodo() {
        return nameTodo;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }
}
