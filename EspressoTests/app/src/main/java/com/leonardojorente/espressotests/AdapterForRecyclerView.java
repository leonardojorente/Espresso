package com.leonardojorente.espressotests;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterForRecyclerView extends RecyclerView.Adapter<AdapterForRecyclerView.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context contextObject;

    public AdapterForRecyclerView(Context ct, String s1[], String s2[], int img[]){
        contextObject =ct;
        data1= s1;
        data2 =s2;
        images=img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(contextObject);
        View view = inflater.inflate(R.layout.my_recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(contextObject, RecyclerViewDetails.class);
                intent.putExtra("data1", data1[position]);
                contextObject.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.recycler_item_name);
            myText2 = itemView.findViewById(R.id.recycler_item_description);
            myImage = itemView.findViewById(R.id.recycler_item_icon);
            mainLayout = itemView.findViewById(R.id.recycler_row_layout);

        }
    }
}
