package com.ehq.ehq.ehq.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ehq.ehq.ehq.Holders.seasonViewHolder;
import com.ehq.ehq.ehq.Modals.seasonModal;
import com.ehq.ehq.ehq.R;
import com.ehq.ehq.ehq.seasonMiddleActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Objects;


public class originals extends Fragment {

    RecyclerView recyclerView;
    private DatabaseReference databaseReference;

    public originals() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("originals");
        databaseReference.keepSynced(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        final View view=inflater.inflate(R.layout.fragment_originals, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_originals);

        FirebaseRecyclerAdapter<seasonModal,seasonViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<seasonModal, seasonViewHolder>
                (seasonModal.class,R.layout.comedy_row,seasonViewHolder.class,databaseReference) {


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
                        intent.setClass(Objects.requireNonNull(getContext()),seasonMiddleActivity.class);
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

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        return view ;
    }

}