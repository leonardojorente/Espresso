package com.leonardojorente.espressotests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerviewObject;

    String recycler_view_name[], recycler_view_description[];
    //array with images from drawable folder
    int recycler_view_images[] = {R.drawable.recycler_view_item_1,R.drawable.recycler_view_item_2,R.drawable.recycler_view_item_3,R.drawable.recycler_view_item_4,R.drawable.recycler_view_item_5,R.drawable.recycler_view_item_6,R.drawable.recycler_view_item_7,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerviewObject = findViewById(R.id.recycler_view);
        recycler_view_name = getResources().getStringArray(R.array.recycler_view_items); // get data from string arry in string.xml
        recycler_view_description = getResources().getStringArray(R.array.recycler_view_item_descriptions);

        AdapterForRecyclerView myAdapterObject = new AdapterForRecyclerView(this, recycler_view_name, recycler_view_description, recycler_view_images);
        recyclerviewObject.setAdapter(myAdapterObject);
        recyclerviewObject.setLayoutManager(new LinearLayoutManager(this));
    }
}
