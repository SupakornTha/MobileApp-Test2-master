package com.example.user.test2;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ZoneAdapter extends RecyclerView.Adapter<ZoneAdapter.ProductViewHolder> {

    private List<CardZone> productList;

    public ZoneAdapter(List<CardZone> productList) { this.productList = productList; }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_mini_zone,parent,false));
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {

        CardZone product = productList.get(position);

        holder.textViewZone.setText(product.Name);
        holder.textViewLack.setText(product.Lack);

        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener(){
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(holder.getAdapterPosition(), 0, 0, "Name");
                menu.add(holder.getAdapterPosition(), 1, 0, "lack");
            }
        });
    }

    @Override
    public int getItemCount() { return productList.size(); }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView textViewLack,textViewZone;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewLack = (TextView) itemView.findViewById(R.id.textViewLack);
            textViewZone = (TextView) itemView.findViewById(R.id.textViewZone);
        }
    }
}
