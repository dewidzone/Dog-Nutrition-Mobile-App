package com.example.dog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    private List<Model> modelList;
    private Context context;

    // Constructor
    public ModelAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    // Non-static method to update the adapter with the filtered list
    public void setFilteredList(List<Model> filteredList) {
        this.modelList = filteredList;
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Bind data to the views
        Model model = modelList.get(position);

        holder.mItemName.setText(model.getmItemName());
        holder.mItemDescription.setText(model.getmItemDetail());
        holder.imageView.setImageResource(model.getmItemPhoto());
    }

    @Override
    public int getItemCount() {
        // Return the total number of items
        return modelList.size();
    }

    // ViewHolder class
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mItemName, mItemDescription;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.ItemName);
            mItemDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.ItemImage);

            // Set onClickListener for item view
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Handle item click
            // You can use an intent or any other logic here
        }
    }
}
