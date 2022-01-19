package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.modal.DataModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<DataModel> dataModels;


    public MyAdapter(Context context, List<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.ViewHolder holder, int position) {
        holder.User_firstName.setText(dataModels.get(position).getFirstName());
        holder.User_lastName.setText(dataModels.get(position).getLastName());
        holder.User_email.setText(dataModels.get(position).getEmail());
        holder.User_mobile.setText(dataModels.get(position).getMobileNumber());
        holder.User_age.setText(dataModels.get(position).getAge());
        Glide.with(context).load(dataModels.get(position).getImage_url()).into(holder.user_image);


    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView User_firstName;
        TextView User_lastName;
        TextView User_email;
        TextView User_mobile;
        TextView User_age;
        ImageView user_image;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            User_firstName=itemView.findViewById(R.id.first_name);
            User_lastName=itemView.findViewById(R.id.last_name);
            User_email=itemView.findViewById(R.id.email);
            User_mobile=itemView.findViewById(R.id.mobile);
            User_age=itemView.findViewById(R.id.age);
            user_image=itemView.findViewById(R.id.image_view);
        }
    }
}
