package com.example.uichallenge.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.example.uichallenge.R;
import com.example.uichallenge.adapter.RecycleAdapter;
import com.example.uichallenge.model.ItemModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static androidx.recyclerview.widget.RecyclerView.*;

public class HomeFragment extends Fragment {

    public static String TAG = HomeFragment.class.getSimpleName();
    List<ItemModel> list = new ArrayList<>();
    RecycleAdapter adapter;
    RecyclerView recyclerView;
    int currentItem, TotalItem, ScrollOutItem;
    boolean isScrolling = false;
    BottomNavigationView bottomNavigationView;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = view.findViewById(R.id.mainRecyclerView);
        addlist();
        adapter = new RecycleAdapter(list, getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //true loop
        recyclerView.scrollToPosition(Integer.MAX_VALUE / 2);


        LinearSnapHelper snapHelper = new LinearSnapHelper() {
            @Override
            public int findTargetSnapPosition(LayoutManager layoutManager, int velocityX, int velocityY) {
                View centerView = findSnapView(layoutManager);
                if (centerView == null)
                    return RecyclerView.NO_POSITION;

                int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                if (layoutManager.canScrollVertically()) {
                    if (velocityY < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                return targetPosition;
            }
        };

        snapHelper.attachToRecyclerView(recyclerView);


        return view;
    }


    public void addlist() {
        list.add(new ItemModel(R.drawable.bgimg, "دریافت اعتبار خرید از دیجیکالا تا سقف ", "200,000,000 ریال"));
        list.add(new ItemModel(R.drawable.ic_launcher_foreground, "دریافت اعتبار خرید از دیجیکالا تا سقف ", "200,000,000 ریال"));
        list.add(new ItemModel(R.drawable.ic_launcher_background, "دریافت اعتبار خرید از دیجیکالا تا سقف ", "200,000,000 ریال"));
    }

}