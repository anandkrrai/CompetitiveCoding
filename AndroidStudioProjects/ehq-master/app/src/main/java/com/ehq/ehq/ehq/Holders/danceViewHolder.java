package com.ehq.ehq.ehq.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ehq.ehq.ehq.R;
import com.squareup.picasso.Picasso;


public class danceViewHolder  extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public String TAG ="Comedy-holder",choreographer,dor,duration,imgsrc,title,videosrc,location,artist;


    public danceViewHolder(View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imageViewMusicCategorygeneric);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getLocation() {
        return location;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public String getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(String choreographer) {
        this.choreographer = choreographer;
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

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideosrc() {
        return videosrc;
    }

    public void setVideosrc(String videosrc) {
        this.videosrc = videosrc;
    }

    public void setImage(Context context , String image){

        if(image==null||image.isEmpty()){
            Picasso.with(context).load("https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg").into(imageView);

        }else {
            Picasso.with(context).load(image).into(imageView);

        }
    }
}
