package com.example.tech2k8.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoListAdapter extends BaseAdapter {
    private ArrayList<TodoDataModel> data;
    private Context context;

    public TodoListAdapter(ArrayList<TodoDataModel> data,Context viewContext) {
        this.data = data;
        context=viewContext;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView=LayoutInflater.from(context).inflate(R.layout.todo_row,parent,false);
        TextView title =rowView.findViewById(R.id.row_title);
        TextView desc =rowView.findViewById(R.id.row_desc);
        TodoDataModel model=data.get(position);
        title.setText(model.getTodoTitle());
        desc.setText(model.getTodoDescp());
        return rowView;
    }
}
