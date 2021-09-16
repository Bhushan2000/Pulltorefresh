package com.example.pulltorefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private LinearLayoutManager manager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Integer> list = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new Adapter(getIntegers());
        recyclerView.setAdapter(adapter);

        getSupportActionBar().setTitle(getString(R.string.app_name) + " ( " + list.size() + " ) items");

        refresh();
    }

    private List<Integer> getIntegers() {
        list.add(1);
        return list;

    }

    private void refresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // your code
                if (list.contains(list.size())) {
                    list.add(list.size() + 1);
                    getSupportActionBar().setTitle(getString(R.string.app_name) + " ( " + list.size() + " ) items");

                    adapter.notifyDataSetChanged();
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}