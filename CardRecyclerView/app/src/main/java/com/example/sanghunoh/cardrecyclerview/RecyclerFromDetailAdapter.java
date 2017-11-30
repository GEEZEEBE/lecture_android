package com.example.sanghunoh.cardrecyclerview;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sanghunoh on 08/11/2017.
 */

public class RecyclerFromDetailAdapter extends RecyclerView.Adapter<RecyclerFromDetailAdapter.ViewHolder> {

    ArrayList<HashMap<String,Object>> arrayList ;

    public RecyclerFromDetailAdapter(){
        this.arrayList = new ArrayList<HashMap<String,Object>>();
    }

    public RecyclerFromDetailAdapter(ArrayList<HashMap<String,Object>> arrayList){
        this.arrayList = new ArrayList<HashMap<String,Object>>();
        this.arrayList = arrayList;
    }

    public void addItem(HashMap<String,Object> hashMap){
        this.arrayList.add(hashMap);
        notifyDataSetChanged();
    }

    public void addItem(int position, HashMap<String,Object> hashMap){
        this.arrayList.add(position, hashMap);
        notifyItemInserted(position);
    }

    public void removeItem(int position){
        this.arrayList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String,Object> hashMap = arrayList.get(position);
        holder.itemTitle.setText((String)hashMap.get("title"));
        holder.itemDetail.setText((String)hashMap.get("detail"));
        holder.itemImage.setImageURI(Uri.parse((String) hashMap.get("image")));
//        holder.itemImage.setImageResource((Integer) hashMap.get("image"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                int position = getAdapterPosition();
                removeItem(position);
                Log.d("ViewHolder Click", position+", "+getItemId());
                }
            });
        }
    }
}
