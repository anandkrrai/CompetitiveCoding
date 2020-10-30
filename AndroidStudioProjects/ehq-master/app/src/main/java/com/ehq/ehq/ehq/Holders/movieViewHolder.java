package com.ehq.ehq.ehq.Holders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ehq.ehq.ehq.R;
import com.squareup.picasso.Picasso;

public class movieViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageView;
    public String TAG ="movieholder";
    private Intent intent;


    public movieViewHolder(View itemView){
        super(itemView);
        imageView= itemView.findViewById(R.id.imageView);
    }

    public void setImage(Context context , String image){

        if(image.isEmpty()){
            Picasso.with(context).load("https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg").into(imageView);

        }else {
            Picasso.with(context).load(image).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: movie holder -> ");

                }
            });
        }
    }




    public void setImage(Context context , final String image , final String director, final String duration, final String summary, final String title, final String videosrc){

        if(image.isEmpty()){
            Picasso.with(context).load("https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg").into(imageView);

        }else {
            Picasso.with(context).load(image).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    intent = new Intent();

                    intent.putExtra("image", image);
                    intent.putExtra("director", director);
                    intent.putExtra("duration",duration);
                    intent.putExtra("summary",summary);
                    intent.putExtra("title",title);
                    intent.putExtra("videosrc",videosrc);
                    intent.putExtra("imgsrc",image);

                    Log.d(TAG, "onClick: movie holder -> "+ image);


                }


            });
        }
    }



}
