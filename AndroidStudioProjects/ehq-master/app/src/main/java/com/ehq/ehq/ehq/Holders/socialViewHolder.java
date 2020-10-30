package com.ehq.ehq.ehq.Holders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.ehq.ehq.ehq.R;
import com.squareup.picasso.Picasso;

public class socialViewHolder extends RecyclerView.ViewHolder{

    public ImageView imageView;

    private CardView cardView;
    private String imgsrc;
    private String dor;
    private String duration;
    private String director;
    private String title;
    private String videosrc;
    private String summary;
    private String backimg,trailer;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public socialViewHolder(View itemView){
        super(itemView);
        imageView= itemView.findViewById(R.id.imageViewcomedy);
        cardView=itemView.findViewById(R.id.cardviewComedy);
    }

    public void setImage(Context context , String image){
        Picasso.with(context).load(image).into(imageView);


        if(image.isEmpty()){
            Picasso.with(context).load("https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg").into(imageView);

        }else {
            Picasso.with(context).load(image).into(imageView);

        }
    }

    public String getBackimg() {
        return backimg;
    }

    public void setBackimg(String backimg) {
        this.backimg = backimg;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
