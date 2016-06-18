package com.example.gerardo.posttest.MyRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerardo.posttest.Data.PostData;
import com.example.gerardo.posttest.R;

import java.util.ArrayList;

/**
 * Created by gerardo on 18/06/16.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    Context c;
    ArrayList<PostData> posts;

    public PostAdapter(Context c, ArrayList<PostData> posts) {
        this.c = c;
        this.posts = posts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_data, parent, false);
        MyViewHolder holder = new MyViewHolder(view, c, posts);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.titulo.setText(posts.get(position).getTitulo());
        holder.contenido.setText(posts.get(position).getContenido());
        holder.fecha.setText(posts.get(position).getFecha());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ArrayList<PostData> postDatas = new ArrayList<>();
        Context c;
        TextView titulo;
        TextView contenido;
        TextView fecha;
        ImageView foto;

        public MyViewHolder(View itemView, Context c, ArrayList<PostData> postDatas) {
            super(itemView);
            this.c = c;
            this.postDatas = postDatas;
            titulo = (TextView) itemView.findViewById(R.id.textTitulo);
            contenido = (TextView) itemView.findViewById(R.id.textContenido);
            fecha = (TextView) itemView.findViewById(R.id.textFecha);
            foto = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
