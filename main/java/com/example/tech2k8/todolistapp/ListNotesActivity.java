package com.example.tech2k8.todolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNotesActivity extends AppCompatActivity {

    private ListView listOfAllNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        listOfAllNotes=findViewById(R.id.notes_list);

        DataManager manager =new DataManager(ListNotesActivity.this);
        ArrayList<TodoDataModel> data=manager.getAllNotes();

//        ArrayAdapter adapter =new ArrayAdapter(
//                ListNotesActivity.this,
//                android.R.layout.simple_list_item_1,data
//                );

        TodoListAdapter adapter =new TodoListAdapter(data,ListNotesActivity.this);
        listOfAllNotes.setAdapter(adapter);

        listOfAllNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListNotesActivity.this, "pos : "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}
