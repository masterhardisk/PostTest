package com.example.gerardo.posttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.gerardo.posttest.MyJson.JsonData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
    String URL_JSON = "http://www.eparticipa.cat/wp-json/wp/v2/posts";
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerPost);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


        JsonData data = new JsonData(findViewById(R.id.main), this, URL_JSON, recyclerView);
        data.getData();


    }
}