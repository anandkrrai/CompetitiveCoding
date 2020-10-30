package com.ehq.ehq.ehq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.MediaRouteButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ehq.ehq.ehq.Holders.musicCategorygenericViewholder;
import com.ehq.ehq.ehq.Modals.musicCategoryModal;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pl.droidsonroids.casty.Casty;
import pl.droidsonroids.casty.MediaData;

public class musicCategory extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    RecyclerView recyclerView;

    boolean isCastTrue=false;
    private Casty casty;
    String string="covers";
    String parent = "music";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_category);

        final Bundle bundle = getIntent().getExtras();
        string=bundle.getString("category");
if(bundle.getString("parent")!=null&&!bundle.getString("parent").equals("")){
    parent=bundle.getString("parent");
}

        recyclerView=findViewById(R.id.musicCategoryRecyclerView);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child(parent).child(string);
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

        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,databaseReference) {
            @Override
            protected void populateViewHolder(musicCategorygenericViewholder viewHolder, musicCategoryModal model, int position) {
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
                viewHolder.setSongsrc(model.getSongsrc());
                viewHolder.setArtistname(model.getArtistname());
                viewHolder.setComposer(model.getComposer());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setEditor(model.getEditor());
                viewHolder.setLocation_credits(model.getLocation_credits());
                viewHolder.setLyricist(model.getLyricist());
                viewHolder.setMore_info(model.getMore_info());
                viewHolder.setSongname(model.getSongname());
                viewHolder.setSound_recorder(model.getSound_recorder());

            }

            @Override
            public void onBindViewHolder(final musicCategorygenericViewholder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (isCastTrue) {
                            casty.getPlayer().loadMediaAndPlay(createSampleMediaData(viewHolder.getSongsrc(),viewHolder.getSongname(),viewHolder.getImgsrc()));

                        } else {
                            Intent intent = new Intent();
                            intent.setClass(getApplicationContext(),playmusic.class);
                            intent.putExtra("videosrc", viewHolder.getSongsrc());
                            intent.putExtra("artistname", viewHolder.getArtistname());
                            intent.putExtra("composer", viewHolder.getComposer());
                            intent.putExtra("duration", viewHolder.getDuration());
                            intent.putExtra("editor", viewHolder.getEditor());
                            intent.putExtra("location_credits", viewHolder.getLocation_credits());
                            intent.putExtra("lyricist", viewHolder.getLyricist());
                            intent.putExtra("more_info", viewHolder.getMore_info());
                            intent.putExtra("songname", viewHolder.getSongname());
                            intent.putExtra("recorder", viewHolder.getSound_recorder());
                            startActivity(intent);
                        }
                    }
                });

            }
        };


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }



    private void setUpMediaRouteButton() {
        MediaRouteButton mediaRouteButton = (MediaRouteButton) findViewById(R.id.media_route_button);
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
