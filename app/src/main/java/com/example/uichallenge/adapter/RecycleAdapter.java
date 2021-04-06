package com.example.uichallenge.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.L;
import com.example.uichallenge.R;
import com.example.uichallenge.databinding.RecyclerItemBinding;
import com.example.uichallenge.fragments.HomeFragment;
import com.example.uichallenge.model.ItemModel;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    List<ItemModel> list;
    Context context;



    public RecycleAdapter(List<ItemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item, parent, false);
        return new ViewHolder(binding);

    }


    //looping recyclerview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position ) {
        int positionInList = position % list.size();
        holder.binding.setRecycleItem(list.get(positionInList));
        holder.imageView.setImageResource(list.get(positionInList).getImg_url());
        Log.d("position :"+String.valueOf(position), "position list:"+String.valueOf(positionInList));

    }

    
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }






    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerItemBinding binding;
        ImageView imageView;

        public ViewHolder(@NonNull RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            imageView = binding.itemImg;
        }
    }






}





