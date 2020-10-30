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
import com.ehq.ehq.ehq.Holders.storyViewHolder;
import com.ehq.ehq.ehq.Modals.storyModal;
import com.ehq.ehq.ehq.R;
import com.ehq.ehq.ehq.VideoPlayerActivity;
import com.ehq.ehq.ehq.musicCategory;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;


public class story extends Fragment {

    RecyclerView recyclerViewpoetry,recyclerViewstory,recyclerViewdastan;
    public String TAG ="Story fragment";
    Button seemore_poetry,seemore_story,seemore_dastan;
    int maxRow=5;
    Context context = getContext();

    public story() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);

        seemore_poetry=view.findViewById(R.id.button_more_poetry);
        seemore_story=view.findViewById(R.id.button_more_story);
        seemore_dastan=view.findViewById(R.id.button_more_dastan);


        seemore_poetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","poetry");
                intent.putExtra("parent","story");
                startActivity(intent);
            }
        });

        seemore_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","story");
                intent.putExtra("parent","story");
                startActivity(intent);
            }
        });

        seemore_dastan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),musicCategory.class);
                intent.putExtra("category","dastan");
                intent.putExtra("parent","story");
                startActivity(intent);
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReferencepoetry = database.getReference().child("story").child("poetry");
        DatabaseReference databaseReferencestory = database.getReference().child("story").child("story");
        DatabaseReference databaseReferencedastan = database.getReference().child("story").child("dastan");

        databaseReferencepoetry.keepSynced(true);
        databaseReferencestory.keepSynced(true);
        databaseReferencedastan.keepSynced(true);

        recyclerViewpoetry = view.findViewById(R.id.recyclerview_poetry);
        recyclerViewstory = view.findViewById(R.id.recyclerview_story);
        recyclerViewdastan = view.findViewById(R.id.recyclerview_daston);

        populateTheRecyclerView(databaseReferencepoetry,recyclerViewpoetry);
        populateTheRecyclerView(databaseReferencestory,recyclerViewstory);
        populateTheRecyclerView(databaseReferencedastan,recyclerViewdastan);


        return view;
    }


    private void populateTheRecyclerView(DatabaseReference databaseReference, RecyclerView recyclerView) {

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
