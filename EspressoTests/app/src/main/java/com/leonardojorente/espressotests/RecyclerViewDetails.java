package com.leonardojorente.espressotests;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecyclerViewDetails extends AppCompatActivity {

    TextView title;
    String data1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_details);

        title = findViewById(R.id.recycler_item_detail);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("data1")){
            data1 = getIntent().getStringExtra("data1");
        }
        else {
            Toast.makeText(this, "no data.", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData(){
        title.setText(data1);
    }
}
