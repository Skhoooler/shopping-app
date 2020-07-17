package com.doria.byui.shopface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    Context context;
    ArrayList<Product> products;
    private OnNoteListener onNoteListener;

    public RecyclerViewAdapter(Context incomingContext, ArrayList<Product> incomingProducts, OnNoteListener onNoteListener){
        context = incomingContext;
        products = incomingProducts;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product, parent,false);

        return new RecyclerViewHolder(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.product_name.setText(products.get(position).getName());
        holder.product_price.setText(Float.toString(products.get(position).getPrice()));
        holder.product_desc.setText(products.get(position).getDesc());
        holder.product_image.setImageDrawable(products.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView product_name, product_price, product_desc;
        ImageView product_image;
        OnNoteListener onNoteListener;

        public RecyclerViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            product_name  = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            product_desc  = itemView.findViewById(R.id.product_desc);
            product_image = itemView.findViewById(R.id.product_image);

            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }

        public int getAdapterPos(){
            return getAdapterPosition();
        }
    }
    public interface OnNoteListener{
        void onNoteClick(int posiition);
    }
}
