package com.androiddeveloper.fragments;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ActiveAdapter extends RecyclerView.Adapter<ActiveAdapter.MyViewHolder> {



    ArrayList<ActiveModel> mActvieModelArrayList;
    ActiveModel mActiveModel;
    private LayoutInflater inflater;
    private Context context;



    public ActiveAdapter(Context context, ArrayList<ActiveModel> mActvieModelArrayList) {


        inflater = LayoutInflater.from(context);
        this.context = context;
         this.mActvieModelArrayList = mActvieModelArrayList;

    }

    @Override
    public ActiveAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.active_list_item, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ActiveAdapter.MyViewHolder holder, final int position) {


// setting map
        holder.itemView.setTag(position);
        mActiveModel = mActvieModelArrayList.get(position);
        holder.active_job_name.setText(mActiveModel.getName());
        Picasso.get().load(mActiveModel.getImage()).into(holder.active_job_icon);
        holder.edit_job_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Edit A Job",Toast.LENGTH_SHORT).show();
            }
        });
        holder.stop_job_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Stop A Job",Toast.LENGTH_SHORT).show();

            }
        });


    }



    @Override
    public int getItemCount() {
        return mActvieModelArrayList == null ? 0 : mActvieModelArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView active_job_name;
        Button edit_job_btn,stop_job_btn;
        ImageView  active_job_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            edit_job_btn = itemView.findViewById(R.id.edit_job_btn);
            stop_job_btn =  itemView.findViewById(R.id.stop_job_btn);
            active_job_icon = (ImageView) itemView.findViewById(R.id.active_job_icon);
             active_job_name = (TextView) itemView.findViewById(R.id.active_job_name);


        }


    }
}
