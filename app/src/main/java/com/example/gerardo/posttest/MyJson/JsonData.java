package com.example.gerardo.posttest.MyJson;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gerardo.posttest.Data.PostData;
import com.example.gerardo.posttest.MyRecycler.PostAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by gerardo on 18/06/16.
 */
public class JsonData {
    Context c;
    String URL_JSON;
    RecyclerView recyclerView;
    ArrayList<PostData> postDatas = new ArrayList<>();
    PostAdapter postAdapter;
    View view;

    public JsonData(View view, Context c, String URL_JSON, RecyclerView recyclerView) {
        this.c = c;
        this.URL_JSON = URL_JSON;
        this.recyclerView = recyclerView;
        this.view = view;
    }



    public void getData (){
        Ion.with(c)
                .load(URL_JSON)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        try {
                            if (e != null)
                                throw e;
                            JsonArray posts = result.getAsJsonArray();
                            for (int i = 1; i < posts.size(); i++) {
                                PostData post =  new PostData();
                                post.setFecha(posts.get(i).getAsJsonObject().get("date").getAsString());
                                post.setTitulo(posts.get(i).getAsJsonObject().get("title").getAsJsonObject().get("rendered").getAsString());
                                post.setContenido(posts.get(i).getAsJsonObject().get("excerpt").getAsJsonObject().get("rendered").getAsString());
                                postDatas.add(post);
                            }
                            if (postDatas.size()>0){
                                postAdapter = new PostAdapter(c, postDatas);
                                recyclerView.setAdapter(postAdapter);

                            }else {
                                Snackbar.make(view, "no hay posts", Snackbar.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex) {
                            Snackbar.make(view, "ha ocurrido un error", Snackbar.LENGTH_SHORT).show();

                        }
                    }


                });
    }
}
