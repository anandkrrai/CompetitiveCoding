package com.ehq.ehq.ehq;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.MediaRouteButton;
import android.view.View;
import android.widget.LinearLayout;
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

public class playmusic extends AppCompatActivity {

    LinearLayout linearLayout;
    BottomSheetBehavior bottomSheetBehavior;

    private SimpleExoPlayerView simpleExoPlayerView;
    private SimpleExoPlayer player;
    private Timeline.Window window;
    private DataSource.Factory mediaDataSourceFactory;
    private DefaultTrackSelector trackSelector;
    private boolean shouldAutoPlay;
    private BandwidthMeter bandwidthMeter;

    String moreInformation="",imgsrc;
    public String URL="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    TextView SingerName,ComposerName,SongTitle,EditorName,LyricistName,LocationCredits,RecorderName,duration,more_info;

    boolean isCastTrue=false;
    private Casty casty;
    private MediaRouteButton mediaRouteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playmusic);

        linearLayout=(LinearLayout)findViewById(R.id.linearLayoutBottom);

        View bottomSheet = findViewById(R.id.linearLayoutBottom);


        SingerName= findViewById(R.id.musicSingerName);
        ComposerName=findViewById(R.id.musicComposerName);
        SongTitle=findViewById(R.id.musicSongTitle);
        EditorName=findViewById(R.id.musicEditorName);
        LyricistName=findViewById(R.id.musicLyricistName);
        LocationCredits=findViewById(R.id.musicLocarionCredits);
        RecorderName=findViewById(R.id.musicRecorderName);
        duration=findViewById(R.id.musicDuration);
        more_info=findViewById(R.id.more_info_music);


        bottomSheetBehavior=BottomSheetBehavior.from(linearLayout);

        Bundle bundle = getIntent().getExtras();
        if(!bundle.getString("videosrc").isEmpty()&&!bundle.getString("videosrc").equals(null)){
            URL= bundle.getString("videosrc");
        }


        moreInformation=bundle.getString("more_info");

        moreInformation=moreInformation.replace("\\n","\n");
        moreInformation=moreInformation.replace(",","\n");
        moreInformation=moreInformation.replace(".","\n");



        SingerName.setText(bundle.getString("artistname"));
        ComposerName.setText(bundle.getString("composer"));
        SongTitle.setText(bundle.getString("songname"));
        EditorName.setText(bundle.getString("editor"));
        LyricistName.setText(bundle.getString("lyricist"));
        LocationCredits.setText(bundle.getString("location_credits"));
        RecorderName.setText(bundle.getString("recorder"));
        duration.setText(bundle.getString("duration"));
        more_info.setText(moreInformation);
        imgsrc=bundle.getString("imgsrc");

        shouldAutoPlay = true;
        bandwidthMeter = new DefaultBandwidthMeter();
        mediaDataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "mediaPlayerSample"), (TransferListener<? super DataSource>) bandwidthMeter);
        window = new Timeline.Window();



        casty = Casty.create(this)
                .withMiniController();
        setUpMediaRouteButton();


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
        mediaRouteButton =  findViewById(R.id.media_route_button_music);
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

        simpleExoPlayerView = (SimpleExoPlayerView) findViewById(R.id.player_view_song_play);
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
