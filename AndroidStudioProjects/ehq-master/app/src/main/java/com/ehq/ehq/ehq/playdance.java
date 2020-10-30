package com.ehq.ehq.ehq;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.MediaRouteButton;
import android.view.View;
import android.widget.TextView;

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

import pl.droidsonroids.casty.Casty;
import pl.droidsonroids.casty.MediaData;

public class playdance extends AppCompatActivity {


    private SimpleExoPlayerView simpleExoPlayerView;
    private SimpleExoPlayer player;
    private Timeline.Window window;
    private DataSource.Factory mediaDataSourceFactory;
    private DefaultTrackSelector trackSelector;
    private boolean shouldAutoPlay;
    private BandwidthMeter bandwidthMeter;
    private MediaRouteButton mediaRouteButton;
    public String URL="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    boolean isCastTrue=false;
    private Casty casty;
    private TextView artist,title,duration,chreographer,location,dor;
    String imgsrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playdance);

        artist=findViewById(R.id.danceArtist);
        title=findViewById(R.id.danceTitle);
        duration=findViewById(R.id.danceDuration);
        chreographer=findViewById(R.id.danceChoreorapherName);
        location=findViewById(R.id.musicLocarionCredits);
        dor=findViewById(R.id.dancedor);

        Bundle bundle = getIntent().getExtras();
        if(!bundle.getString("videosrc").equals(null)){
            URL= bundle.getString("videosrc");
        }

        artist.setText(bundle.getString("artist"));
        title.setText(bundle.getString("title"));
        duration.setText(bundle.getString("duration"));
        chreographer.setText(bundle.getString("chreo_name"));
        location.setText(bundle.getString("location"));
        dor.setText(bundle.getString("dor"));
        imgsrc=bundle.getString("imgsrc");

        shouldAutoPlay = true;
        bandwidthMeter = new DefaultBandwidthMeter();
        mediaDataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "mediaPlayerSample"), (TransferListener<? super DataSource>) bandwidthMeter);
        window = new Timeline.Window();




        casty = Casty.create(this)
                .withMiniController();
        setUpMediaRouteButton();

        if(mediaRouteButton!=null){
            mediaRouteButton.setVisibility(View.INVISIBLE);
        }



        casty.setOnConnectChangeListener(new Casty.OnConnectChangeListener() {
            @Override
            public void onConnected() {
                isCastTrue=true;
                player.setPlayWhenReady(false);
                casty.getPlayer().loadMediaAndPlay(createSampleMediaData(URL, getTitle().toString(),imgsrc));
                if(mediaRouteButton!=null){
                    mediaRouteButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onDisconnected() {
                isCastTrue=false;
                player.setPlayWhenReady(true);
                if(mediaRouteButton!=null){
                    mediaRouteButton.setVisibility(View.INVISIBLE);
                }

            }
        });

    }

    private void setUpMediaRouteButton() {
         mediaRouteButton =  findViewById(R.id.media_route_button7);
        casty.setUpMediaRouteButton(mediaRouteButton);
    }


    private static MediaData createSampleMediaData(String url, String title,String imgsrc) {
        return new MediaData.Builder(url)
                .setStreamType(MediaData.STREAM_TYPE_BUFFERED)
                .setContentType("videos/mp4")
                .setMediaType(MediaData.MEDIA_TYPE_MOVIE)
                .setTitle(title)
                .setSubtitle("Sample subtitle")
                .addPhotoUrl(imgsrc)
                .build();
    }


    private void initializePlayer() {

        simpleExoPlayerView = (SimpleExoPlayerView) findViewById(R.id.player_view_dance_play);
        simpleExoPlayerView.requestFocus();

        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);

        trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        simpleExoPlayerView.setPlayer(player);

        player.setPlayWhenReady(shouldAutoPlay);

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
}