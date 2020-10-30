package com.ehq.ehq.ehq.fragments;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ehq.ehq.ehq.Holders.comedyViewHolder;
import com.ehq.ehq.ehq.Modals.comedyModal;
import com.ehq.ehq.ehq.R;
import com.ehq.ehq.ehq.transistionActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class comedy extends Fragment {

    public String TAG ="comedy fragment";
    Context context;
    RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;

    public comedy() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("comedy");
        databaseReference.keepSynced(true);
        context=getContext();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_comedy, container, false);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("comedy");
        databaseReference.keepSynced(true);

        recyclerView = view.findViewById(R.id.recyclerviewcomedy);

        FirebaseRecyclerAdapter<comedyModal,comedyViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<comedyModal, comedyViewHolder>
                (comedyModal.class,R.layout.comedy_row,comedyViewHolder.class,databaseReference) {
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
                            intent.setClass(Objects.requireNonNull(getContext()), transistionActivity.class);
                            intent.putExtra("imgsrc",viewHolder.getImgsrc());
                            intent.putExtra("videosrc",viewHolder.getVideosrc());
                            intent.putExtra("summary",viewHolder.getSummary());
                            intent.putExtra("title",viewHolder.getTitle());
                            intent.putExtra("duration",viewHolder.getDuration());
                            intent.putExtra("director",viewHolder.getDirector());
                            intent.putExtra("dor",viewHolder.getDor());
                            intent.putExtra("backimg",viewHolder.getBackimg());
                            intent.putExtra("trailer",viewHolder.getTrailersrc());

                            Pair[] pair = new Pair[1];
                            pair[0]=new Pair<View,String>(viewHolder.imageView,"imageTransistions");

                            ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                                    pair);
                            startActivity(intent,options.toBundle());
                        }
                    });
            }


        };



        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);

//        gridLayoutManager.setReverseLayout(true);

//        gridLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(gridLayoutManager);


        recyclerView.setAdapter(firebaseRecyclerAdapter);

        return view ;
    }


}
