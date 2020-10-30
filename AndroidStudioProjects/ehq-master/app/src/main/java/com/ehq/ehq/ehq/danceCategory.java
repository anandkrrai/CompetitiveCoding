package com.ehq.ehq.ehq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.MediaRouteButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ehq.ehq.ehq.Holders.danceViewHolder;
import com.ehq.ehq.ehq.Modals.danceModal;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pl.droidsonroids.casty.Casty;
import pl.droidsonroids.casty.MediaData;

public class danceCategory extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    RecyclerView recyclerView;

    boolean isCastTrue=false;
    private Casty casty;
    String string="cover";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance_category);

        recyclerView=findViewById(R.id.danceCategoryRecyclerView);

        final Bundle bundle = getIntent().getExtras();
        string=bundle.getString("category");

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("dance").child(string);
        populateTheRecyclerView(databaseReference,recyclerView);


        casty = Casty.create(this)
                .withMiniController();
        setUpMediaRouteButton();

        casty.setOnConnectChangeListener(new Casty.OnConnectChangeListener() {
            @Override
            public void onConnected() {
                isCastTrue=true;
            }

            @Override
            public void onDisconnected() {
                isCastTrue=false;
            }
        });


    }
    private void populateTheRecyclerView(DatabaseReference databaseReference, RecyclerView recyclerView) {

        FirebaseRecyclerAdapter<danceModal,danceViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<danceModal, danceViewHolder>
                (danceModal.class,R.layout.music_category_generic,danceViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(danceViewHolder viewHolder, danceModal model, int position) {

                viewHolder.setChoreographer(model.getChoreographer());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.duration);
                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setVideosrc(model.getVideosrc());
            }

            @Override
            public void onBindViewHolder(final danceViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (isCastTrue) {
                            casty.getPlayer().loadMediaAndPlay(createSampleMediaData(viewHolder.getVideosrc(), viewHolder.getTitle(), viewHolder.getImgsrc()));

                        } else {
                            Intent intent = new Intent();
                            intent.setClass(getApplicationContext(), playdance.class);
                            intent.putExtra("videosrc", viewHolder.getVideosrc());
                            startActivity(intent);
                        }
                    }
                });


            }
        };


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }



    private void setUpMediaRouteButton() {
        MediaRouteButton mediaRouteButton = (MediaRouteButton) findViewById(R.id.media_route_button6);
        casty.setUpMediaRouteButton(mediaRouteButton);
    }


    private static MediaData createSampleMediaData(String url, String title, String photourl) {
        return new MediaData.Builder(url)
                .setStreamType(MediaData.STREAM_TYPE_BUFFERED)
                .setContentType("videos/mp4")
                .setMediaType(MediaData.MEDIA_TYPE_MOVIE)
                .setTitle(title)
                .setSubtitle("Sample subtitle")
                .addPhotoUrl(photourl)
                .build();
    }

}

