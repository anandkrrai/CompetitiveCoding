package com.ehq.ehq.ehq.Holders;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ehq.ehq.ehq.R;
import com.squareup.picasso.Picasso;

public class storyViewHolder extends RecyclerView.ViewHolder {
    private String imgsrc,videosrc;
    public ImageView imageView;
    private CardView cardView;



    public storyViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageViewstory);
        cardView=itemView.findViewById(R.id.cardviewStory);
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getVideosrc() {
        return videosrc;
    }

    public void setVideosrc(String videosrc) {
        this.videosrc = videosrc;
    }

    public void setImage(Context context , String image){
        Picasso.with(context).load(image).into(imageView);

    }
}
