package com.example.user.test2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(View itemView){
        super(itemView);

        mView = itemView;
    }
    public void setDetails(Context ctx,String Name,String Zone){
        TextView nameView = mView.findViewById(R.id.textViewGreenhouse);
        TextView zoneView = mView.findViewById(R.id.textViewZone);

        nameView.setText(Name);
        zoneView.setText(Zone);

    }
}
