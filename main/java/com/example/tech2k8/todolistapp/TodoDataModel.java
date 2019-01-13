package com.example.tech2k8.todolistapp;

public class TodoDataModel {

    private String todoTitle;

    private String todoDescp;

    public void setTodoTitle(String todoTitle)
    {
        this.todoTitle=todoTitle;
    }

    public String getTodoTitle()
    {
        return todoTitle;
    }

    public String getTodoDescp() {
        return todoDescp;
    }

    public void setTodoDescp(String todoDescp) {
        this.todoDescp = todoDescp;
    }
}
