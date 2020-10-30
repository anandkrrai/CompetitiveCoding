package com.ehq.ehq.ehq.Holders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ehq.ehq.ehq.R;
import com.squareup.picasso.Picasso;

public class musicViewholder extends RecyclerView.ViewHolder  {

    String imgsrc,title;
    public ImageView imageView;
    public String TAG ="music-holder";
    public CardView cardView;


    public musicViewholder(View itemView) {
        super(itemView);
//        cardView=itemView.findViewById(R.id.music_item_cardview);
        imageView=itemView.findViewById(R.id.imageView);

    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setImage(Context context , String image){

        if(image.isEmpty()){
            Picasso.with(context).load("https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg").into(imageView);

        }else {
            Picasso.with(context).load(image).into(imageView);

        }
    }
}
