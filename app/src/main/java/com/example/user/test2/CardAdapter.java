package com.example.user.test2;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ProductViewHolder> {

    private List<GreenhouseCard> items;

    public CardAdapter(List<GreenhouseCard> items) { this.items = items; }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.minigreenhouse,parent,false));
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {

        GreenhouseCard product = items.get(position);

        holder.textViewGreenhouse.setText(product.Name);
        holder.textViewZone.setText(product.Zone);

        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener(){
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(holder.getAdapterPosition(), 0, 0, "Name");
                menu.add(holder.getAdapterPosition(), 1, 0, "Zone");
            }
        });
    }

    @Override
    public int getItemCount() { return items.size(); }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewGreenhouse, textViewZone;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewGreenhouse = (TextView) itemView.findViewById(R.id.textViewGreenhouse);
            textViewZone = (TextView) itemView.findViewById(R.id.textViewZone);
        }
    }
}
