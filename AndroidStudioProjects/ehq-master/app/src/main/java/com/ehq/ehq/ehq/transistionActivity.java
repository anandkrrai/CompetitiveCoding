package com.ehq.ehq.ehq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.MediaRouteButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

import pl.droidsonroids.casty.Casty;
import pl.droidsonroids.casty.MediaData;

public class  transistionActivity extends AppCompatActivity {

    TextView directortv,titletv,summarytv,dortv,durationtv;
    ImageView imageView,backIMAGE;
    Button watchNow,watchTrailer;
    Casty casty;
    boolean isCastTrue=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transistion);

        titletv=findViewById(R.id.transistionTitle);
        directortv=findViewById(R.id.transistionDirector);
        summarytv=findViewById(R.id.transistionSummary);
        dortv=findViewById(R.id.transistionReleaseDate);
        durationtv=findViewById(R.id.transitionDuration);
        imageView=findViewById(R.id.transistionImageMovie);
        watchNow=findViewById(R.id.transistionWatchNow);
        backIMAGE=findViewById(R.id.transistionImageBack);
        watchTrailer=findViewById(R.id.transistionWatchTrailr);

        final Bundle bundle = getIntent().getExtras();

        assert bundle != null;
        titletv.setText(bundle.getString("title"));
        summarytv.setText(bundle.getString("summary"));
        directortv.setText((CharSequence) bundle.get("director"));
        durationtv.setText(bundle.getString("duration"));
        dortv.setText(bundle.getString("dor"));

        Picasso.with(getApplicationContext()).load(bundle.getString("imgsrc")).into(imageView);
        if(bundle.getString("backimg")!=null && Objects.requireNonNull(bundle.getString("backimg")).length()>0 ) {
            Picasso.with(getApplicationContext()).load(bundle.getString("backimg")).into(backIMAGE);
        }



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


        watchNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isCastTrue) {

                    casty.getPlayer().loadMediaAndPlay(createSampleMediaData());

                } else {

                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), VideoPlayerActivity.class);
                    intent.putExtra("videosrc", bundle.getString("videosrc"));
                    startActivity(intent);
                }
            }
        });

        watchTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (casty.isConnected()) {

                    casty.getPlayer().loadMediaAndPlay(createSampleMediaData());

                } else {

                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), VideoPlayerActivity.class);
                    intent.putExtra("videosrc", bundle.getString("trailer"));
                    startActivity(intent);
                }
            }
        });

    }

        private static MediaData createSampleMediaData() {
        return new MediaData.Builder("http://distribution.bbb3d.renderfarming.net/video/mp4/bbb_sunflower_1080p_30fps_normal.mp4")
                .setStreamType(MediaData.STREAM_TYPE_BUFFERED)
                .setContentType("videos/mp4")
                .setMediaType(MediaData.MEDIA_TYPE_MOVIE)
                .setTitle("Sample title")
                .setSubtitle("Sample subtitle")
                .addPhotoUrl("https://peach.blender.org/wp-content/uploads/bbb-splash.png?x11217")
                .build();
    }


    private void setUpMediaRouteButton() {
        MediaRouteButton mediaRouteButton = findViewById(R.id.media_route_button4);
        casty.setUpMediaRouteButton(mediaRouteButton);
    }

}
