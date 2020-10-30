package com.ehq.ehq.ehq;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import com.ehq.ehq.ehq.Holders.comedyViewHolder;
import com.ehq.ehq.ehq.Holders.danceViewHolder;
import com.ehq.ehq.ehq.Holders.musicCategorygenericViewholder;
import com.ehq.ehq.ehq.Holders.seasonViewHolder;
import com.ehq.ehq.ehq.Holders.socialViewHolder;
import com.ehq.ehq.ehq.Modals.danceModal;
import com.ehq.ehq.ehq.Modals.musicCategoryModal;
import com.ehq.ehq.ehq.Modals.seasonModal;
import com.ehq.ehq.ehq.Modals.socialModal;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class searchActivity extends AppCompatActivity {

    private EditText mSearchField;
    private RecyclerView mResultList,recyclerView1,recyclerView2,recyclerView3,recyclerView4;
    private DatabaseReference mUserDatabase;
    public String TAG="Search Activity";
    private final int REQ_CODE_SPEECH_INPUT = 100;
    List<String> list;
    Spinner spinner;
    String field="originals";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mUserDatabase = FirebaseDatabase.getInstance().getReference();

        ImageButton btnSpeak = findViewById(R.id.btnSpeak);

        mSearchField = findViewById(R.id.search_field);
        mResultList =  findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        recyclerView2=findViewById(R.id.result_list2);
        recyclerView1=findViewById(R.id.result_list1);
        recyclerView3=findViewById(R.id.result_list3);
        recyclerView4=findViewById(R.id.result_list4);


        spinner=findViewById(R.id.searchSpinner);
        list = new ArrayList<String>();
        list.add("comedy");
        list.add("originals");
        list.add("social");
        list.add("dance");
        list.add("music");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


//                Toast.makeText(getApplicationContext(),list.get(position) + " ", Toast.LENGTH_LONG).show();

                field=list.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_layout, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(dataAdapter);


        mSearchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              String searchText = mSearchField.getText().toString();
                    searchByfield(searchText);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = mSearchField.getText().toString();
                searchByfield(searchText);
            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

    }

    public void searchByfield(String searchText){

        clearTheDataOfRecyclerViews();

        if(field.equals("comedy")) {
            firebaseUserSearchcomedy(searchText);
        }else if(field.equals("originals")){
//            Log.d(TAG, "searchByfield: searching for originals");
            firebaseUserSearchoriginals(searchText);
           }else if(field.equals("social")){
            firebaseUserSearchsocial(searchText);
        }else if(field.equals("music")){
            firebaseUserSearchMusicBand(searchText);
            firebaseUserSearchMusicCover(searchText);
            firebaseUserSearchMusicDj(searchText);
            firebaseUserSearchMusicEhqProducton(searchText);
            firebaseUserSearchMusicOriginal(searchText);
        }else if(field.equals("dance")){
            firebaseUserSearchDanceOriginal(searchText);
            firebaseUserSearchDanceCover(searchText);
            firebaseUserSearchDanceChoreographer(searchText);

        }
    }

    private void firebaseUserSearchDanceOriginal(String searchText) {

        mUserDatabase = FirebaseDatabase.getInstance().getReference("dance").child("cover");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("title").startAt(searchText).endAt(searchText + "\uf8ff");


        FirebaseRecyclerAdapter<danceModal,danceViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<danceModal, danceViewHolder>
                (danceModal.class,R.layout.music_category_generic,danceViewHolder.class,firebaseSearchQuery) {
            @Override
            protected void populateViewHolder(danceViewHolder viewHolder, danceModal model, int position) {

                viewHolder.setChoreographer(model.getChoreographer());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setArtist(model.getArtist());
                viewHolder.setLocation(model.getLocation());
            }

            @Override
            public void onBindViewHolder(final danceViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playdance.class);
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("chreo_name",viewHolder.getChoreographer());
                        intent.putExtra("location",viewHolder.getLocation());
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("artist",viewHolder.getArtist());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("dor",viewHolder.getDor());
                        startActivity(intent);
                    }
                });


            }
        };


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        mResultList.setLayoutManager(layoutManager);
        mResultList.setAdapter(firebaseRecyclerAdapter);
    }
    private void firebaseUserSearchDanceCover(String searchText) {
        recyclerView1=findViewById(R.id.result_list1);

        mUserDatabase = FirebaseDatabase.getInstance().getReference("dance").child("cover");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("title").startAt(searchText).endAt(searchText + "\uf8ff");


        FirebaseRecyclerAdapter<danceModal,danceViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<danceModal, danceViewHolder>
                (danceModal.class,R.layout.music_category_generic,danceViewHolder.class,firebaseSearchQuery) {
            @Override
            protected void populateViewHolder(danceViewHolder viewHolder, danceModal model, int position) {

                viewHolder.setChoreographer(model.getChoreographer());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setArtist(model.getArtist());
                viewHolder.setLocation(model.getLocation());
            }

            @Override
            public void onBindViewHolder(final danceViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playdance.class);
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("chreo_name",viewHolder.getChoreographer());
                        intent.putExtra("location",viewHolder.getLocation());
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("artist",viewHolder.getArtist());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());
                        intent.putExtra("dor",viewHolder.getDor());
                        startActivity(intent);
                    }
                });


            }
        };


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(firebaseRecyclerAdapter);
    }
    private void firebaseUserSearchDanceChoreographer(String searchText) {

        recyclerView2=findViewById(R.id.result_list2);


        mUserDatabase = FirebaseDatabase.getInstance().getReference("dance").child("cover");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("title").startAt(searchText).endAt(searchText + "\uf8ff");


        FirebaseRecyclerAdapter<danceModal,danceViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<danceModal, danceViewHolder>
                (danceModal.class,R.layout.music_category_generic,danceViewHolder.class,firebaseSearchQuery) {
            @Override
            protected void populateViewHolder(danceViewHolder viewHolder, danceModal model, int position) {

                viewHolder.setChoreographer(model.getChoreographer());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setArtist(model.getArtist());
                viewHolder.setLocation(model.getLocation());
            }

            @Override
            public void onBindViewHolder(final danceViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playdance.class);
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


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(firebaseRecyclerAdapter);
    }

    private void clearTheDataOfRecyclerViews() {

        // some functio n to clear the contents of the recycler view

        mResultList.setAdapter(null);
        recyclerView1.setAdapter(null);
        recyclerView2.setAdapter(null);
        recyclerView3.setAdapter(null);
        recyclerView4.setAdapter(null);


    }

    private void firebaseUserSearchMusicBand(String searchText) {
        mUserDatabase = FirebaseDatabase.getInstance().getReference("music").child("covers");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("songname").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,firebaseSearchQuery) {
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
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playmusic.class);
                        intent.putExtra("videosrc",viewHolder.getSongsrc());
                        intent.putExtra("artistname",viewHolder.getArtistname());
                        intent.putExtra("composer",viewHolder.getComposer());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("editor",viewHolder.getEditor());
                        intent.putExtra("location_credits",viewHolder.getLocation_credits());
                        intent.putExtra("lyricist",viewHolder.getLyricist());
                        intent.putExtra("more_info",viewHolder.getMore_info());
                        intent.putExtra("songname",viewHolder.getSongname());
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());
                        intent.putExtra("recorder",viewHolder.getSound_recorder());
                        startActivity(intent);
                    }
                });
            }
        };

        mResultList.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

    private void firebaseUserSearchMusicCover(String searchText) {

        recyclerView1=findViewById(R.id.result_list1);
        mUserDatabase = FirebaseDatabase.getInstance().getReference("music").child("covers");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("songname").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,firebaseSearchQuery) {
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
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playmusic.class);
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

        recyclerView1.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView1.setAdapter(firebaseRecyclerAdapter);
    }

    private void firebaseUserSearchMusicDj(String searchText) {
        recyclerView2=findViewById(R.id.result_list2);

        mUserDatabase = FirebaseDatabase.getInstance().getReference("music").child("dj");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("songname").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,firebaseSearchQuery) {
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
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playmusic.class);
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

        recyclerView2.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView2.setAdapter(firebaseRecyclerAdapter);
    }

    private void firebaseUserSearchMusicEhqProducton(String searchText) {
        recyclerView3=findViewById(R.id.result_list3);


        mUserDatabase = FirebaseDatabase.getInstance().getReference("music").child("ehqproduction");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("songname").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,firebaseSearchQuery) {
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
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playmusic.class);
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

        recyclerView3.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView3.setAdapter(firebaseRecyclerAdapter);
    }

    private void firebaseUserSearchMusicOriginal(String searchText) {

        recyclerView4=findViewById(R.id.result_list4);


        mUserDatabase = FirebaseDatabase.getInstance().getReference("music").child("original");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("songname").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,firebaseSearchQuery) {
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
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),playmusic.class);
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

        recyclerView4.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView4.setAdapter(firebaseRecyclerAdapter);
    }

    private void firebaseUserSearchcomedy(String searchText) {
        mUserDatabase = FirebaseDatabase.getInstance().getReference("comedy");
        Query firebaseSearchQuery = mUserDatabase.orderByChild("title").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<socialModal,comedyViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<socialModal, comedyViewHolder>
                (socialModal.class,R.layout.comedy_row,comedyViewHolder.class,firebaseSearchQuery) {
            @Override
            protected void populateViewHolder(comedyViewHolder viewHolder, socialModal model, int position) {


                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setDirector(model.getDirector());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setSummary(model.getSummary());
                viewHolder.setBackimg(model.getBackimg());

            }

            @Override
            public void onBindViewHolder(final comedyViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);


                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "onClick: "+viewHolder.getImgsrc());
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(), transistionActivity.class);
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("summary",viewHolder.getSummary());
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("director",viewHolder.getDirector());
                        intent.putExtra("dor",viewHolder.getDor());
                        intent.putExtra("backimg",viewHolder.getBackimg());



//                        Pair[] pair = new Pair[1];
//                        pair[0]=new Pair<View,String>(viewHolder.imageView,"imageTransistions");
//
//                        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity) getApplicationContext(),
//                                pair);
//                        startActivity(intent,options.toBundle());

                        startActivity(intent);
                    }
                });
            }


        };

        mResultList.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));

        mResultList.setAdapter(firebaseRecyclerAdapter);

    }

    private void firebaseUserSearchsocial(String searchText) {

        mUserDatabase = FirebaseDatabase.getInstance().getReference("social");


        Query firebaseSearchQuery = mUserDatabase.orderByChild("title").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<socialModal,socialViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<socialModal, socialViewHolder>
                (socialModal.class,R.layout.comedy_row,socialViewHolder.class,firebaseSearchQuery) {
            @Override
            protected void populateViewHolder(socialViewHolder viewHolder, socialModal model, int position) {


                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
                viewHolder.setImgsrc(model.getImgsrc());
                viewHolder.setVideosrc(model.getVideosrc());
                viewHolder.setDirector(model.getDirector());
                viewHolder.setDor(model.getDor());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setSummary(model.getSummary());
                viewHolder.setBackimg(model.getBackimg());
                viewHolder.setTrailer(model.getTrailer());
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
                        intent.setClass(getApplicationContext(), transistionActivity.class);
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());
                        intent.putExtra("videosrc",viewHolder.getVideosrc());
                        intent.putExtra("summary",viewHolder.getSummary());
                        intent.putExtra("title",viewHolder.getTitle());
                        intent.putExtra("duration",viewHolder.getDuration());
                        intent.putExtra("director",viewHolder.getDirector());
                        intent.putExtra("dor",viewHolder.getDor());
                        intent.putExtra("backimg",viewHolder.getBackimg());
                        intent.putExtra("trailer",viewHolder.getTrailer());

                        startActivity(intent);
                    }
                });
            }
        };

        mResultList.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));

        mResultList.setAdapter(firebaseRecyclerAdapter);

    }

    private void firebaseUserSearchoriginals(String searchText) {


        mUserDatabase = FirebaseDatabase.getInstance().getReference("originals");


        Query firebaseSearchQuery = mUserDatabase.orderByChild("title").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<seasonModal,seasonViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<seasonModal,seasonViewHolder>(

                seasonModal.class,
                R.layout.comedy_row,
                seasonViewHolder.class,
                firebaseSearchQuery

        ) {
            @Override
            protected void populateViewHolder(seasonViewHolder viewHolder, seasonModal model, int position) {
                viewHolder.setImage(getApplicationContext(),model.getImgsrc());
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

                viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),seasonMiddleActivity.class);
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
        mResultList.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    //recieve speech input

        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mSearchField.setText(result.get(0).toLowerCase());
                }
                break;
            }

        }
    }

}
