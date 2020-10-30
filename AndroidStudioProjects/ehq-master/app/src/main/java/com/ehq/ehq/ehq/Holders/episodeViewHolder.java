package com.ehq.ehq.ehq.Holders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehq.ehq.ehq.R;
import com.squareup.picasso.Picasso;

public class episodeViewHolder extends RecyclerView.ViewHolder{

    private String title,duration,episodeimagesrc,videosrc;

    public ImageView imageView;
    public String TAG ="episode-holder";
    public CardView cardView;
    public TextView title_box,duration_box;

    public episodeViewHolder(View itemView) {
        super(itemView);
        imageView= itemView.findViewById(R.id.episode_row_imageview);
        cardView= itemView.findViewById(R.id.episode_row_cardView);
        title_box= itemView.findViewById(R.id.episode_title);
        duration_box=itemView.findViewById(R.id.episode_duration);

    }


    public String getEpisodeimagesrc() {
        return episodeimagesrc;
    }

    public void setEpisodeimagesrc(String episodeimagesrc) {
        this.episodeimagesrc = episodeimagesrc;
    }

    public String getVideosrc() {
        return videosrc;
    }

    public void setVideosrc(String videosrc) {
        this.videosrc = videosrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        title_box.setText(title);
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
        duration_box.setText(duration);
    }

    public void setImage(Context context , String image){

        if(image.isEmpty()){
            Picasso.with(context).load("http://www.gstatic.com/tv/thumb/tvbanners/12900907/p12900907_b_v8_aa.jpg").into(imageView);

        }else {
            Picasso.with(context).load(image).into(imageView);

        }
    }
}
