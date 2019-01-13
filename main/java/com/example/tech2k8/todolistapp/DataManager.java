package com.example.tech2k8.todolistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataManager extends SQLiteOpenHelper {

    public DataManager(Context context) {
        super(context, "tododb",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable ="create table todos_data (title varchar(50),todo_desc varchar(250))";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addNewTodoData(String ti,String desc)
    {
        ContentValues values =new ContentValues();
        values.put("title",ti);
        values.put("todo_desc",desc);
        SQLiteDatabase database =this.getWritableDatabase();
        database.insert("todos_data",null,values);
    }

    public ArrayList<TodoDataModel> getAllNotes()
    {
        SQLiteDatabase database =this.getReadableDatabase();
        Cursor resultFromQuery=database.query("todos_data",
                new String[]{"title","todo_desc"},
                null,null,null,
                null,null);
        ArrayList<TodoDataModel> listData =new ArrayList();
        if (resultFromQuery !=null)
        {
            if (resultFromQuery.moveToFirst())
            {

                do
                {

                    String title=resultFromQuery.getString(0);
                    String desc=resultFromQuery.getString(1);
                    TodoDataModel model =new TodoDataModel();
                    model.setTodoTitle(title);
                    model.setTodoDescp(desc);
                    listData.add(model);
                    //listData.add(title);


                }while (resultFromQuery.moveToNext());
            }
        }
        return listData;
    }
}
