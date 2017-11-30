package com.example.sanghunoh.cardrecyclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
//    RecyclerView recyclerView;
//    RecyclerView.Adapter adapter;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Bundle bundle = getIntent().getExtras();
        String layoutType = bundle.getString("layoutType");
//        Bundle bundle = get

//        String[] titles = {"Chapter One",
//                "Chapter Two",
//                "Chapter Three",
//                "Chapter Four",
//                "Chapter Five",
//                "Chapter Six",
//                "Chapter Seven",
//                "Chapter Eight"};
//        String[] details = {"Item one details",
//                "Item two details", "Item three details",
//                "Item four details", "Item file details",
//                "Item six details", "Item seven details",
//                "Item eight details"};
//        int[] images = { R.drawable.android_image_1,
//                R.drawable.android_image_2,
//                R.drawable.android_image_3,
//                R.drawable.android_image_4,
//                R.drawable.android_image_5,
//                R.drawable.android_image_6,
//                R.drawable.android_image_7,
//                R.drawable.android_image_8 };

        ArrayList<HashMap<String,Object>> arrayList = new ArrayList<HashMap<String,Object>>();

        HashMap<String,Object> hashMap = null;
        hashMap = new HashMap<String,Object>();
        hashMap.put("title", "Chapter Two");
        hashMap.put("detail", "Item two details");
        hashMap.put("image", R.drawable.android_image_2);
        arrayList.add(hashMap);
        hashMap = new HashMap<String,Object>();
        hashMap.put("title", "Chapter Four");
        hashMap.put("detail", "Item four details");
        hashMap.put("image", R.drawable.android_image_4);
        arrayList.add(hashMap);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = null;
        if(layoutType.equals("grid")) { // GridLayoutManager
            layoutManager = new GridLayoutManager(this,2);
        } else if(layoutType.equals("staggeredgrid")) {
            layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        } else {
            layoutManager = new LinearLayoutManager(this);
        }
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(arrayList);

        recyclerView.setAdapter(adapter);

        hashMap = new HashMap<String,Object>();
        hashMap.put("title", "Chapter Seven");
        hashMap.put("detail", "Item seven details");
        hashMap.put("image", R.drawable.android_image_7);
        adapter.addItem(hashMap);

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.addItemAction);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object> hashMap = new HashMap<String,Object>();
                hashMap.put("title", "Chapter Oone");
                hashMap.put("detail", "Item one details");
                hashMap.put("image", R.drawable.android_image_1);
                adapter.addItem(1,hashMap);
                Intent intent = new Intent(v.getContext(), DetailEditActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }

}
