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

public class RecyclerViewFromDetailActivity extends AppCompatActivity {
    //    RecyclerView recyclerView;
//    RecyclerView.Adapter adapter;
    RecyclerFromDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Bundle bundle = getIntent().getExtras();
        String layoutType = bundle.getString("layoutType");

        ArrayList<HashMap<String,Object>> arrayList = new ArrayList<HashMap<String,Object>>();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerFromDetailAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.addItemAction);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailEditActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            HashMap<String,Object> hashMap = new HashMap<String,Object>();
            hashMap.put("title", data.getStringExtra("title"));
            hashMap.put("detail", data.getStringExtra("detail"));
            hashMap.put("image", data.getStringExtra("image"));
            adapter.addItem(hashMap);
        }
    }
}
