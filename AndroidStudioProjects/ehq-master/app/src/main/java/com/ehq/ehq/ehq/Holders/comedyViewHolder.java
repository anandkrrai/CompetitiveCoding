package com.ehq.ehq.ehq.Holders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ehq.ehq.ehq.R;
import com.squareup.picasso.Picasso;

public class comedyViewHolder extends RecyclerView.ViewHolder{

    public ImageView imageView;
    public String TAG ="Comedy-holder";
    public CardView cardView;
    private String imgsrc;
    private String dor;
    private String duration;
    private String director;
    private String title;
    private String videosrc;
    private String summary;
    private String backimg,trailersrc;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTrailersrc() {
        return trailersrc;
    }

    public void setTrailersrc(String trailersrc) {
        this.trailersrc = trailersrc;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getBackimg() {
        return backimg;
    }

    public void setBackimg(String backimg) {
        this.backimg = backimg;
    }

    public comedyViewHolder(View itemView){
        super(itemView);
        imageView= itemView.findViewById(R.id.imageViewcomedy);
        cardView= itemView.findViewById(R.id.cardviewComedy);

    }

    public void setImage(Context context , String image){
        Picasso.with(context).load(image).into(imageView);


    }

}
