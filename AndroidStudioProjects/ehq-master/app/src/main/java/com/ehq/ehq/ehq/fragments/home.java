package com.ehq.ehq.ehq.fragments;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehq.ehq.ehq.GenericTabActivity;
import com.ehq.ehq.ehq.Holders.comedyViewHolder;
import com.ehq.ehq.ehq.Holders.danceViewHolder;
import com.ehq.ehq.ehq.Holders.musicCategorygenericViewholder;
import com.ehq.ehq.ehq.Holders.seasonViewHolder;
import com.ehq.ehq.ehq.Holders.socialViewHolder;
import com.ehq.ehq.ehq.Holders.storyViewHolder;
import com.ehq.ehq.ehq.Modals.comedyModal;
import com.ehq.ehq.ehq.Modals.danceModal;
import com.ehq.ehq.ehq.Modals.musicCategoryModal;
import com.ehq.ehq.ehq.Modals.seasonModal;
import com.ehq.ehq.ehq.Modals.socialModal;
import com.ehq.ehq.ehq.Modals.storyModal;
import com.ehq.ehq.ehq.R;
import com.ehq.ehq.ehq.VideoPlayerActivity;
import com.ehq.ehq.ehq.danceCategory;
import com.ehq.ehq.ehq.musicCategory;
import com.ehq.ehq.ehq.playdance;
import com.ehq.ehq.ehq.playmusic;
import com.ehq.ehq.ehq.seasonMiddleActivity;
import com.ehq.ehq.ehq.transistionActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;


public class home extends Fragment {
    public String TAG="Home fragment";
    private SimpleExoPlayerView simpleExoPlayerView;
    private SimpleExoPlayer player;
    private FirebaseDatabase database;


    RecyclerView recyclerViewcomedy;
    private DatabaseReference databaseReferencecomedy;
    private FirebaseDatabase databasecomedy;



    RecyclerView recyclerVieworiginals;
    private DatabaseReference databaseReferenceoriginals;
    private FirebaseDatabase databaseoriginals;

    RecyclerView recyclerViewsocial;
    private DatabaseReference databaseReferencesocal;
    private FirebaseDatabase databasesocial;

    View view;

    private final String STATE_RESUME_WINDOW = "resumeWindow";
    private final String STATE_RESUME_POSITION = "resumePosition";
    private final String STATE_PLAYER_FULLSCREEN = "playerFullscreen";

    private SimpleExoPlayerView mExoPlayerView;
    private MediaSource mVideoSource;
    private boolean mExoPlayerFullscreen = false;
    private FrameLayout mFullScreenButton;
    private ImageView mFullScreenIcon;
    private Dialog mFullScreenDialog;

    private int mResumeWindow;
    private long mResumePosition;

    public Button home_original,home_social,home_comedy;
    private RecyclerView recyclerViewmusic_band,recyclerViewmusic_covers,recyclerViewmusic_dj,recyclerViewmusic_ehqProduction,recyclerViewmusic_originals;
    private DatabaseReference databaseReferenceband,databaseReferenceehqproductions,databaseReferenceoriginalsmusic,databaseReferencedj,
            databaseReferencecovers,databaseReferencepoetry,databaseReferencestory,databaseReferencedastan;

    Context context;

    private Button button_music_band,button_music_covers,button_music_dj,button_music_ehqproduction,button_music_originals;

    RecyclerView recyclerViewEhqOriginal,recyclerVieweChreographer,recyclerViewCover;
    RecyclerView recyclerViewpoetry,recyclerViewstory,recyclerViewdastan;
    Button seemore_poetry,seemore_story,seemore_dastan;

    private DatabaseReference databaseReferenceEhqOriginal,databaseReferenceChreographer,databaseReferenceCover;
    Button seemore_EhqOriginal,seemore_Chreographer,seemore_Cover;


    int maxRow=5;
    Query query;


    public home() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        context=getContext();

        if (savedInstanceState != null) {
            mResumeWindow = savedInstanceState.getInt(STATE_RESUME_WINDOW);
            mResumePosition = savedInstanceState.getLong(STATE_RESUME_POSITION);
            mExoPlayerFullscreen = savedInstanceState.getBoolean(STATE_PLAYER_FULLSCREEN);

        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home, container, false);
        database = FirebaseDatabase.getInstance();
        databasecomedy = FirebaseDatabase.getInstance();
        databaseReferencecomedy = database.getReference().child("comedy");
        databaseReferencecomedy.keepSynced(true);
        recyclerViewcomedy = view.findViewById(R.id.recyclerview_home_comedy);


        databaseoriginals = FirebaseDatabase.getInstance();
        databaseReferenceoriginals = database.getReference().child("originals");
        databaseReferenceoriginals.keepSynced(true);


        databasesocial = FirebaseDatabase.getInstance();
        databaseReferencesocal = database.getReference().child("social");
        databaseReferencesocal.keepSynced(true);

        home_comedy=view.findViewById(R.id.button_home_comedy);
        home_original=view.findViewById(R.id.button_home_original);
        home_social=view.findViewById(R.id.button_home_social);

        button_music_band=view.findViewById(R.id.button_home_music_band);
        button_music_dj=view.findViewById(R.id.button_music_dj);
        button_music_originals=view.findViewById(R.id.button_music_originals);
        button_music_ehqproduction=view.findViewById(R.id.button_music_ehqProduction);
        button_music_covers=view.findViewById(R.id.button_home_music_covers);

        seemore_Chreographer=view.findViewById(R.id.seemore_Chreographer);
        seemore_Cover=view.findViewById(R.id.seemore_Cover);
        seemore_EhqOriginal=view.findViewById(R.id.seemore_EhqOriginal);


        recyclerViewmusic_band=view.findViewById(R.id.recyclerview_home_music_band);
        recyclerViewmusic_dj=view.findViewById(R.id.recyclerview_music_dj);
        recyclerViewmusic_covers=view.findViewById(R.id.recyclerview_music_covers);
        recyclerViewmusic_ehqProduction=view.findViewById(R.id.recyclerview_music_production);
        recyclerViewmusic_originals=view.findViewById(R.id.recyclerview_music_originals);

        databaseReferenceband = database.getReference().child("music").child("covers");
        databaseReferenceehqproductions = database.getReference().child("music").child("covers");
        databaseReferenceoriginalsmusic = database.getReference().child("music").child("covers");
        databaseReferencedj = database.getReference().child("music").child("covers");
        databaseReferencecovers = database.getReference().child("music").child("covers");

        databaseReferenceband.keepSynced(true);
        databaseReferenceehqproductions.keepSynced(true);
        databaseReferenceoriginalsmusic.keepSynced(true);
        databaseReferencedj.keepSynced(true);
        databaseReferencecovers.keepSynced(true);

//        populateTheRecyclerViewMusic(databaseReferenceband,recyclerViewmusic_band);
//        populateTheRecyclerViewMusic(databaseReferenceehqproductions,recyclerViewmusic_ehqProduction);
//        populateTheRecyclerViewMusic(databaseReferenceoriginalsmusic,recyclerViewmusic_originals);
//        populateTheRecyclerViewMusic(databaseReferencedj,recyclerViewmusic_dj);
//        populateTheRecyclerViewMusic(databaseReferencecovers,recyclerViewmusic_covers);

        //9454647260

        new populateInThread().execute("");

        recyclerViewEhqOriginal = view.findViewById(R.id.recyclerview_ehq_dance_original);
        recyclerVieweChreographer = view.findViewById(R.id.recyclerview_chreograpgy);
        recyclerViewCover = view.findViewById(R.id.recyclerview_ehq_dance_covers);

        databaseReferenceEhqOriginal = database.getReference().child("dance").child("original");
        databaseReferenceChreographer = database.getReference().child("dance").child("choreography");
        databaseReferenceCover = database.getReference().child("dance").child("cover");

        databaseReferenceEhqOriginal.keepSynced(true);
        databaseReferenceChreographer.keepSynced(true);
        databaseReferenceCover.keepSynced(true);

        recyclerViewEhqOriginal = view.findViewById(R.id.recyclerViewEhqOriginal);
        recyclerVieweChreographer = view.findViewById(R.id.recyclerVieweChreographer);
        recyclerViewCover = view.findViewById(R.id.recyclerViewCover);

        seemore_poetry=view.findViewById(R.id.button_more_poetry);
        seemore_story=view.findViewById(R.id.button_more_story);
        seemore_dastan=view.findViewById(R.id.button_more_dastan);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
         databaseReferencepoetry = database.getReference().child("story").child("poetry");
         databaseReferencestory = database.getReference().child("story").child("story");
         databaseReferencedastan = database.getReference().child("story").child("dastan");

        databaseReferencepoetry.keepSynced(true);
        databaseReferencestory.keepSynced(true);
        databaseReferencedastan.keepSynced(true);

        recyclerViewpoetry = view.findViewById(R.id.recyclerview_poetry);
        recyclerViewstory = view.findViewById(R.id.recyclerview_story);
        recyclerViewdastan = view.findViewById(R.id.recyclerview_daston);


//
//        populateTheRecyclerView(databaseReferenceEhqOriginal,recyclerViewEhqOriginal);
//        populateTheRecyclerView(databaseReferenceChreographer,recyclerVieweChreographer);
//        populateTheRecyclerView(databaseReferenceCover,recyclerViewCover);




        seemore_Chreographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),danceCategory.class);
                intent.putExtra("category","choreography");
                startActivity(intent);
            }
        });

        seemore_Cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),danceCategory.class);
                intent.putExtra("category","cover");
                startActivity(intent);
            }
        });

        seemore_EhqOriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),danceCategory.class);
                intent.putExtra("category","original");
                startActivity(intent);
            }
        });


        button_music_band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Objects.requireNonNull(getContext()),musicCategory.class);
                intent.putExtra("category","band");
                startActivity(intent);
            }
        });

        button_music_covers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Objects.requireNonNull(getContext()),musicCategory.class);
                intent.putExtra("category","covers");
                startActivity(intent);
            }
        });

        button_music_dj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","dj");
                startActivity(intent);
            }
        });

        button_music_ehqproduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","ehqproduction");
                startActivity(intent);
            }
        });

        button_music_originals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","originals");
                startActivity(intent);
            }
        });


        home_comedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.putExtra("title","comedy");
                intent.setClass(getContext(),GenericTabActivity.class);
                startActivity(intent);
            }
        });


        home_original.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("title","originals");
                intent.setClass(getContext(),GenericTabActivity.class);
                startActivity(intent);
            }
        });


        home_social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("title","social");
                intent.setClass(getContext(),GenericTabActivity.class);
                startActivity(intent);

            }
        });


        seemore_poetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context,musicCategory.class);
                intent.putExtra("category","poetry");
                intent.putExtra("parent","story");
                startActivity(intent);
            }
        });

        seemore_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context,musicCategory.class);
                intent.putExtra("category","story");
                intent.putExtra("parent","story");
                startActivity(intent);
            }
        });

        seemore_dastan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context,musicCategory.class);
                intent.putExtra("category","dastan");
                intent.putExtra("parent","story");
                startActivity(intent);
            }
        });



        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);

        query = databaseReferencecomedy.limitToLast(maxRow);


        FirebaseRecyclerAdapter<comedyModal,comedyViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<comedyModal, comedyViewHolder>
                (comedyModal.class,R.layout.comedy_row,comedyViewHolder.class,query) {
            @Override
            protected void populateViewHolder(comedyViewHolder viewHolder, comedyModal model, int position) {


                viewHolder.setImage(getContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setDirector(model.getDirector());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setSummary(model.getSummary());
                viewHolder.setBackimg(model.getBackimg());
                viewHolder.setTrailersrc(model.getTrailersrc());

            }

            @Override
            public void onBindViewHolder(final comedyViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);


                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(), transistionActivity.class);
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("summary",viewHolder.getSummary());
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("director",viewHolder.getDirector());
                        intent.putExtra("dor",viewHolder.getDor());
                        intent.putExtra("backimg",viewHolder.getBackimg());
                        intent.putExtra("trailer",viewHolder.getTrailersrc());

                        startActivity(intent);
                    }
                });
            }
        };


        layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewcomedy.setLayoutManager(layoutManager);
        recyclerViewcomedy.setAdapter(firebaseRecyclerAdapter);


        recyclerVieworiginals = view.findViewById(R.id.recyclerview_home_original);
        query =databaseReferenceoriginals.limitToLast(maxRow);


        FirebaseRecyclerAdapter<seasonModal,seasonViewHolder> firebaseRecyclerAdapteroriginals =new FirebaseRecyclerAdapter<seasonModal, seasonViewHolder>
                (seasonModal.class,R.layout.comedy_row,seasonViewHolder.class,query) {

            @Override
            protected void populateViewHolder(seasonViewHolder viewHolder, seasonModal model, int position) {


                viewHolder.setImage(getContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setDor(model.getDor());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setSummary(model.getSummary());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setDirector(model.getDirector());
                viewHolder.setLanguage(model.getLanguage());

            }


            @Override
            public void onBindViewHolder(final seasonViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(),seasonMiddleActivity.class);
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("director",viewHolder.getDirector());
                        intent.putExtra("dor",viewHolder.getDor());
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("summary",viewHolder.getSummary());
                        intent.putExtra("child","originals");
                        intent.putExtra("series",viewHolder.getTitle());
                        intent.putExtra("language",viewHolder.getLanguage());

                        startActivity(intent);
                    }
                });
            }
        };



        layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerVieworiginals.setLayoutManager(layoutManager);


        recyclerVieworiginals.setAdapter(firebaseRecyclerAdapteroriginals);



        recyclerViewsocial = view.findViewById(R.id.recyclerview_home_social);

        query= databaseReferencesocal.limitToLast(maxRow);


        FirebaseRecyclerAdapter<socialModal,socialViewHolder> firebaseRecyclerAdaptersocial =new FirebaseRecyclerAdapter<socialModal, socialViewHolder>
                (socialModal.class,R.layout.comedy_row,socialViewHolder.class,query) {
            @Override
            protected void populateViewHolder(socialViewHolder viewHolder, socialModal model, int position) {


                viewHolder.setImage(getContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setDirector(model.getDirector());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setSummary(model.getSummary());
                viewHolder.setBackimg(model.getBackimg());
                viewHolder.setTrailer(model.getTrailer());

            }

            @Override
            public void onBindViewHolder(final socialViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);


                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "onClick: "+viewHolder.getImgsrc());
                        Intent intent = new Intent();
                        intent.setClass(getContext(), transistionActivity.class);
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("summary",viewHolder.getSummary());
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("director",viewHolder.getDirector());
                        intent.putExtra("dor",viewHolder.getDor());
                        intent.putExtra("backimg",viewHolder.getBackimg());
                        intent.putExtra("trailer",viewHolder.getTrailer());


                        Pair[] pair = new Pair[1];
                        pair[0]=new Pair<View,String>(viewHolder.imageView,"imageTransistions");

                        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                                pair);

                        startActivity(intent,options.toBundle());
                    }
                });
            }
        };



        layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewsocial.setLayoutManager(layoutManager);

        recyclerViewsocial.setAdapter(firebaseRecyclerAdaptersocial);


        return view;

    }


    private class populateInThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            populateTheRecyclerViewMusic(databaseReferenceband,recyclerViewmusic_band);
            populateTheRecyclerViewMusic(databaseReferenceehqproductions,recyclerViewmusic_ehqProduction);
            populateTheRecyclerViewMusic(databaseReferenceoriginalsmusic,recyclerViewmusic_originals);
            populateTheRecyclerViewMusic(databaseReferencedj,recyclerViewmusic_dj);
            populateTheRecyclerViewMusic(databaseReferencecovers,recyclerViewmusic_covers);



            populateTheRecyclerView(databaseReferenceEhqOriginal,recyclerViewEhqOriginal);
            populateTheRecyclerView(databaseReferenceChreographer,recyclerVieweChreographer);
            populateTheRecyclerView(databaseReferenceCover,recyclerViewCover);


            populateTheRecyclerViewStory(databaseReferencepoetry,recyclerViewpoetry);
            populateTheRecyclerViewStory(databaseReferencestory,recyclerViewstory);
            populateTheRecyclerViewStory(databaseReferencedastan,recyclerViewdastan);
            return "done";
        }

        @Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

    @Override
    public void onResume() {

        super.onResume();

        if (mExoPlayerView == null) {

            mExoPlayerView = view.findViewById(R.id.exoplayer_home);
            initFullscreenDialog();
            initFullscreenButton();
//            String streamUrl = "https://mnmedias.api.telequebec.tv/m3u8/29880.m3u8";
//            String streamUrl="http://wow01.105.net/live/virgin1/chunklist_w25732073.m3u8";
            String streamUrl="http://212224109111.dogannet.tv/S1/HLS_LIVE/cnn_turk/1000/prog_index.m3u8";
            String userAgent = Util.getUserAgent(getContext(), getContext().getApplicationInfo().packageName);
            DefaultHttpDataSourceFactory httpDataSourceFactory = new DefaultHttpDataSourceFactory(userAgent, null, DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS, DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS, true);
            DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(getContext(), null, httpDataSourceFactory);
            Uri daUri = Uri.parse(streamUrl);

            mVideoSource = new HlsMediaSource(daUri, dataSourceFactory, 1, null, null);
        }

        initExoPlayer();

        if (mExoPlayerFullscreen) {
            ((ViewGroup) mExoPlayerView.getParent()).removeView(mExoPlayerView);
            mFullScreenDialog.addContentView(mExoPlayerView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_fullscreen_skrink));
            mFullScreenDialog.show();
        }
    }


    @Override
    public void onPause() {

        super.onPause();

        if (mExoPlayerView != null && mExoPlayerView.getPlayer() != null) {
            mResumeWindow = mExoPlayerView.getPlayer().getCurrentWindowIndex();
            mResumePosition = Math.max(0, mExoPlayerView.getPlayer().getContentPosition());

            mExoPlayerView.getPlayer().release();
        }

        if (mFullScreenDialog != null)
            mFullScreenDialog.dismiss();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt(STATE_RESUME_WINDOW, mResumeWindow);
        outState.putLong(STATE_RESUME_POSITION, mResumePosition);
        outState.putBoolean(STATE_PLAYER_FULLSCREEN, mExoPlayerFullscreen);

        super.onSaveInstanceState(outState);
    }


    private void initFullscreenDialog() {

        mFullScreenDialog = new Dialog(getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen) {
            public void onBackPressed() {
                if (mExoPlayerFullscreen)
                    closeFullscreenDialog();
                super.onBackPressed();
            }
        };
    }


    private void openFullscreenDialog() {

        ((ViewGroup) mExoPlayerView.getParent()).removeView(mExoPlayerView);
        mFullScreenDialog.addContentView(mExoPlayerView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_fullscreen_skrink));
        mExoPlayerFullscreen = true;
        mFullScreenDialog.show();
    }


    private void closeFullscreenDialog() {

        ((ViewGroup) mExoPlayerView.getParent()).removeView(mExoPlayerView);
        ((FrameLayout) view.findViewById(R.id.main_media_frame_home)).addView(mExoPlayerView);
        mExoPlayerFullscreen = false;
        mFullScreenDialog.dismiss();
        mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.ic_fullscreen_expand));
    }


    private void initFullscreenButton() {

        PlaybackControlView controlView = mExoPlayerView.findViewById(R.id.exo_controller);
        mFullScreenIcon = controlView.findViewById(R.id.exo_fullscreen_icon);
        mFullScreenButton = controlView.findViewById(R.id.exo_fullscreen_button);
        mFullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mExoPlayerFullscreen)
                    openFullscreenDialog();
                else
                    closeFullscreenDialog();
            }
        });
    }


    private void initExoPlayer() {

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        LoadControl loadControl = new DefaultLoadControl();
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(getContext()), trackSelector, loadControl);
        mExoPlayerView.setPlayer(player);

        boolean haveResumePosition = mResumeWindow != C.INDEX_UNSET;

        if (haveResumePosition) {
            mExoPlayerView.getPlayer().seekTo(mResumeWindow, mResumePosition);
        }

        mExoPlayerView.getPlayer().prepare(mVideoSource);
//        mExoPlayerView.getPlayer().setPlayWhenReady(true);
    }


    private void populateTheRecyclerViewMusic(DatabaseReference databaseReference, RecyclerView recyclerView) {

        Query que =databaseReference.limitToLast(maxRow);


        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,que) {
            @Override
            protected void populateViewHolder(musicCategorygenericViewholder viewHolder, musicCategoryModal model, int position) {
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setImage(getContext(),model.getImgsrc());
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
                        Intent intent = new Intent();
                        intent.setClass(Objects.requireNonNull(getContext()),playmusic.class);
                        intent.putExtra("videosrc",viewHolder.getSongsrc());
                        intent.putExtra("artistname",viewHolder.getArtistname());
                        intent.putExtra("composer",viewHolder.getComposer());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("editor",viewHolder.getEditor());
                        intent.putExtra("location_credits",viewHolder.getLocation_credits());
                        intent.putExtra("lyricist",viewHolder.getLyricist());
                        intent.putExtra("more_info",viewHolder.getMore_info());
                        intent.putExtra("songname",viewHolder.getSongname());
                        intent.putExtra("recorder",viewHolder.getSound_recorder());
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());

                        startActivity(intent);
                    }
                });

            }
        };


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private void populateTheRecyclerView(DatabaseReference databaseReference, RecyclerView recyclerView) {

        Query quer = databaseReference.limitToLast(maxRow);


        FirebaseRecyclerAdapter<danceModal,danceViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<danceModal, danceViewHolder>
                (danceModal.class,R.layout.music_category_generic,danceViewHolder.class,quer) {
            @Override
            protected void populateViewHolder(danceViewHolder viewHolder, danceModal model, int position) {

                viewHolder.setChoreographer(model.getChoreographer());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setImage(getContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setArtist(model.getArtist());
                viewHolder.setLocation(model.getLocation());
            }

//            @Override
//            public danceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                return super.onCreateViewHolder(parent, viewType);
//            }

            @Override
            public void onBindViewHolder(final danceViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(context,playdance.class);
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("chreo_name",viewHolder.getChoreographer());
                        intent.putExtra("location",viewHolder.getLocation());
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("artist",viewHolder.getArtist());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("dor",viewHolder.getDor());
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());

                        startActivity(intent);
                    }
                });


            }
        };


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private void populateTheRecyclerViewStory(DatabaseReference databaseReference, RecyclerView recyclerView) {

        Query query =databaseReference.limitToLast(maxRow);

        FirebaseRecyclerAdapter<storyModal,storyViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<storyModal, storyViewHolder>
                (storyModal.class,R.layout.story_row,storyViewHolder.class,query) {



            @Override
            protected void populateViewHolder(storyViewHolder viewHolder, storyModal model, int position) {
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setImage(getContext(),model.getImgsrc());
                viewHolder.setVideosrc(model.getVideosrc());

            }


            @Override
            public void onBindViewHolder(final storyViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(Objects.requireNonNull(getContext()),VideoPlayerActivity.class);
                        intent.putExtra("videosrc", viewHolder.getVideosrc());
                        startActivity(intent);
                    }
                });
            }
        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }


}
