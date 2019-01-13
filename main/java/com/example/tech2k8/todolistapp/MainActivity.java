package com.example.tech2k8.todolistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText title,desc;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        desc=findViewById(R.id.desc);
        save=findViewById(R.id.save);
        final DataManager manager =new DataManager(MainActivity.this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_title=title.getText().toString();
                String temp_desc=desc.getText().toString();
                manager.addNewTodoData(temp_title,temp_desc);
                Toast.makeText(MainActivity.this, "Todo added", Toast.LENGTH_SHORT).show();
                title.setText("");
                desc.setText("");
                Intent moveToListAct =new Intent(MainActivity.this,ListNotesActivity.class);
                startActivity(moveToListAct);
            }
        });
    }
}
