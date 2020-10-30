package com.ehq.ehq.ehq.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ehq.ehq.ehq.Holders.musicCategorygenericViewholder;
import com.ehq.ehq.ehq.Modals.musicCategoryModal;
import com.ehq.ehq.ehq.R;
import com.ehq.ehq.ehq.musicCategory;
import com.ehq.ehq.ehq.playmusic;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;


public class music extends Fragment {

    RecyclerView recyclerViewband,recyclerViewehqproductions,recyclerVieworiginals,recyclerViewdj,recyclerViewcovers;
    public String TAG ="music fragment";

    Button seemore_band,seemore_covers,seemore_dj,seemore_ehqproduction,seemore_originals;

    int maxRow=5;

    public music() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_music, container, false);


        seemore_band=view.findViewById(R.id.button_more_band);
        seemore_covers=view.findViewById(R.id.button_more_covers);
        seemore_dj=view.findViewById(R.id.button_more_dj);
        seemore_ehqproduction=view.findViewById(R.id.button_more_ehqproduction);
        seemore_originals=view.findViewById(R.id.button_more_originals);


        seemore_band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","band");
                startActivity(intent);
            }
        });

        seemore_covers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","covers");
                startActivity(intent);
            }
        });

        seemore_dj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","dj");
                startActivity(intent);
            }
        });

        seemore_ehqproduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","ehqproduction");
                startActivity(intent);
            }
        });

        seemore_originals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","original");
                startActivity(intent);
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReferenceband = database.getReference().child("music").child("band");
        DatabaseReference databaseReferenceehqproductions = database.getReference().child("music").child("ehqproduction");
        DatabaseReference databaseReferenceoriginals = database.getReference().child("music").child("original");
        DatabaseReference databaseReferencedj = database.getReference().child("music").child("dj");
        DatabaseReference databaseReferencecovers = database.getReference().child("music").child("covers");

        databaseReferenceband.keepSynced(true);
        databaseReferenceehqproductions.keepSynced(true);
        databaseReferenceoriginals.keepSynced(true);
        databaseReferencedj.keepSynced(true);
        databaseReferencecovers.keepSynced(true);

        recyclerViewband = view.findViewById(R.id.recyclerview_band);
        recyclerViewehqproductions = view.findViewById(R.id.recyclerview_ehqproduction);
        recyclerVieworiginals = view.findViewById(R.id.recyclerview_originals);
        recyclerViewdj = view.findViewById(R.id.recyclerview_dj);
        recyclerViewcovers = view.findViewById(R.id.recyclerview_cover);

        populateTheRecyclerView(databaseReferenceband,recyclerViewband);
        populateTheRecyclerView(databaseReferenceehqproductions,recyclerViewehqproductions);
        populateTheRecyclerView(databaseReferenceoriginals,recyclerVieworiginals);
        populateTheRecyclerView(databaseReferencedj,recyclerViewdj);
        populateTheRecyclerView(databaseReferencecovers,recyclerViewcovers);

          return view;
    }

    private void populateTheRecyclerView(DatabaseReference databaseReference, RecyclerView recyclerView) {

        Query query =databaseReference.limitToLast(maxRow);


        FirebaseRecyclerAdapter<musicCategoryModal,musicCategorygenericViewholder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<musicCategoryModal, musicCategorygenericViewholder>
                (musicCategoryModal.class,R.layout.music_category_generic,musicCategorygenericViewholder.class,query) {


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


}
