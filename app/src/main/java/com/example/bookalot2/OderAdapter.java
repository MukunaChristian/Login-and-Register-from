package com.example.bookalot2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OderAdapter extends RecyclerView.Adapter<OderAdapter.ViewHolder> {

    List<Model> modelList;
    Context context;


    public OderAdapter(Context context, List<Model> modelList ) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem,parent, false);
        return new ViewHolder(view);



    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        //here we will find the position and start setting the ouput on our views
        String nameofBook = modelList.get(position).getBookName();
        String descriptionofDrink = modelList.get(position).getBookDtail();
        int images = modelList.get(position).getBookPhoto();

        holder.BookName.setText(nameofBook);
        holder.BookDescription.setText(descriptionofDrink);
        holder.imageView.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

     //in order to make our views responsive we can implement onclik on our recyclerview
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // here we wll find the views on which we will inflate our data

        TextView BookName, BookDescription;
        ImageView imageView;

        public ViewHolder( View itemView) {
            super(itemView);
            BookName = itemView.findViewById(R.id.bookName);
            BookDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.bookmage);
            itemView.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        int position = getAbsoluteAdapterPosition();
        if(position ==0 ){
            Intent intent = new Intent(context, infoActivity.class);
            context.startActivity(intent);
        }
    }
}
}
