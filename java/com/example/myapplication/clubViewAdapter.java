package com.example.myapplication;

import android.widget.BaseAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class clubViewAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<clubv> foodsList;

    public clubViewAdapter(Context context, int layout, ArrayList<clubv> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder
    {
        ImageView imageView;
        TextView txtName,txtPrice;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View row=view;
        ViewHolder holder=new ViewHolder();

        if(row==null)
        {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(layout,null);
            holder.txtName=(TextView) row.findViewById(R.id.txtname);
            holder.txtPrice=(TextView) row.findViewById(R.id.txtprice);
            holder.imageView=(ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder);
        }
        else {
            holder=(ViewHolder) row.getTag();
        }
        clubv cbv=foodsList.get(position);
        Log.d("Adapter", "Name: " + cbv.getName() + ", Price: " + cbv.getPrice());
       /* holder.txtName.setText(cbv.getName());
        holder.txtPrice.setText(cbv.getPrice());*/
        holder.txtName.setText(cbv.getName() != null ? cbv.getName() : "Default Name");
        holder.txtPrice.setText(cbv.getPrice() != null ? cbv.getPrice() : "Default Price");

        byte[] foodim=cbv.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(foodim,0,foodim.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }

}
