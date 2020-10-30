package com.ehq.ehq.ehq;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.MediaRouteButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ehq.ehq.ehq.Holders.episodeViewHolder;
import com.ehq.ehq.ehq.Modals.episodesModal;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import pl.droidsonroids.casty.Casty;
import pl.droidsonroids.casty.MediaData;

public class seasonMiddleActivity extends AppCompatActivity {


    private SimpleExoPlayerView simpleExoPlayerView;
    private SimpleExoPlayer player;
    private Timeline.Window window;
    private DataSource.Factory mediaDataSourceFactory;
    private DefaultTrackSelector trackSelector;
    private boolean shouldAutoPlay;
    private BandwidthMeter bandwidthMeter;
    public String URL="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    public String TAG ="season middle activity";
    TextView director,title,summary,dor,language;
    String child,series;
//  season;
    Spinner spinner;
    RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    List<String> list;
    boolean addedFirstElement = false;
    boolean isCastTrue=false;
    private Casty casty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_middle);

        title=findViewById(R.id.seasonActivityTitle);
        director=findViewById(R.id.seasonActivityDirector);
        summary=findViewById(R.id.seasonActivitySummary);
        dor=findViewById(R.id.seasonActivitydateofRelease);
        language=findViewById(R.id.seasonActivityLanguage);
        spinner=findViewById(R.id.seasonSpinner);


        Bundle bundle = getIntent().getExtras();
        if(!bundle.getString("videosrc").equals(null)){
            URL= bundle.getString("videosrc");
        }
        title.setText(bundle.getString("title"));
        summary.setText(bundle.getString("summary"));
        director.setText((CharSequence) bundle.get("director"));
        dor.setText(bundle.getString("dor"));
        language.setText(bundle.getString("language"));
        child=bundle.getString("child");
        series=bundle.getString("series");
        list = new ArrayList<String>();
        list.add("season1");
        shouldAutoPlay = true;
        bandwidthMeter = new DefaultBandwidthMeter();
        mediaDataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "mediaPlayerSample"), (TransferListener<? super DataSource>) bandwidthMeter);
        window = new Timeline.Window();

        //------------------------------------------------------------------------------------

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        databaseReference.keepSynced(true);
        recyclerView = findViewById(R.id.season_midActivityRecyclerView);

        initRecyclerView("season1");
        databaseReference = database.getReference().child(child).child(series).child("episodes");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "number of child=" + dataSnapshot.getChildrenCount());
                Toast.makeText(seasonMiddleActivity.this, dataSnapshot.getChildrenCount() + " ", Toast.LENGTH_SHORT).show();

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if (!addedFirstElement) {
                        list.remove(0);
                        addedFirstElement=true;
                    }
                        list.add(child.getKey());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_layout, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),list.get(position) + " ", Toast.LENGTH_LONG).show();
                initRecyclerView(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       initRecyclerView("season1");

//--------------------------------cast---------------------------------------------------

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

    public void initRecyclerView(String season){
        databaseReference = database.getReference().child(child).child(series).child("episodes").child(season);
        FirebaseRecyclerAdapter<episodesModal,episodeViewHolder>firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<episodesModal, episodeViewHolder>
                (episodesModal.class,R.layout.episode_row,episodeViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(episodeViewHolder viewHolder, episodesModal model, int position) {
                viewHolder.setEpisodeimagesrc(model.getEpisodeimagesrc());
                viewHolder.setDuration(model.getDurartion());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setTitle(model.getTitle());
                //                viewHolder.setImage(getApplicationContext(),"https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg");
                viewHolder.setImage(getApplicationContext(),model.getEpisodeimagesrc());
            }

            @Override
            public void onBindViewHolder(final episodeViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isCastTrue) {
                            casty.getPlayer().loadMediaAndPlay(createSampleMediaData(viewHolder.getVideosrc(), viewHolder.getTitle(), viewHolder.getEpisodeimagesrc()));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("videosrc", viewHolder.getVideosrc());
                            intent.setClass(getApplicationContext(), VideoPlayerActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    private void initializePlayer() {
        simpleExoPlayerView = findViewById(R.id.player_view_season);
        simpleExoPlayerView.requestFocus();

        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        simpleExoPlayerView.setPlayer(player);
        player.setPlayWhenReady(shouldAutoPlay);

/*        MediaSource mediaSource = new HlsMediaSource(Uri.parse("https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8"),
                mediaDataSourceFactory, mainHandler, null);*/

        DefaultExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource mediaSource = new ExtractorMediaSource(Uri.parse(URL),
                mediaDataSourceFactory, extractorsFactory, null, null);
        player.prepare(mediaSource);
    }

    private void releasePlayer() {
        if (player != null) {
            shouldAutoPlay = player.getPlayWhenReady();
            player.release();
            player = null;
            trackSelector = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }

    private void setUpMediaRouteButton() {
        MediaRouteButton mediaRouteButton =  findViewById(R.id.media_route_button2);
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
