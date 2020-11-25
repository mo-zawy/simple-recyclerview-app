package com.example.task3;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdaptor;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.reciclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        for(int i = 0; i< 10 ; i++){
            ListItem item = new ListItem(
                    "Item"+(i+1),
                    "Description of item number "+(i+1),
                    R.mipmap.on_foreground
            );
            listItems.add(item);
        }
        adapter = new MyAdaptor(this , listItems);
        recyclerView.setAdapter(adapter);
    }


}