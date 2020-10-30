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

import com.ehq.ehq.ehq.Holders.danceViewHolder;
import com.ehq.ehq.ehq.Modals.danceModal;
import com.ehq.ehq.ehq.R;
import com.ehq.ehq.ehq.danceCategory;
import com.ehq.ehq.ehq.playdance;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class dance extends Fragment {


    RecyclerView recyclerViewEhqOriginal,recyclerVieweChreographer,recyclerViewCover;
    public String TAG ="dance fragment";
    Context context;
    Button seemore_EhqOriginal,seemore_Chreographer,seemore_Cover;

    int maxRow =5;

    public dance() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            context=getContext();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dance, container, false);

        seemore_Chreographer=view.findViewById(R.id.button_more_dance_chreography);
        seemore_Cover=view.findViewById(R.id.button_more_dance_covers);
        seemore_EhqOriginal=view.findViewById(R.id.button_more_ehq_dance_original);

        FirebaseDatabase database = FirebaseDatabase.getInstance();


        DatabaseReference databaseReferenceEhqOriginal = database.getReference().child("dance").child("original");
        DatabaseReference databaseReferenceChreographer = database.getReference().child("dance").child("choreography");
        DatabaseReference databaseReferenceCover = database.getReference().child("dance").child("cover");

        databaseReferenceEhqOriginal.keepSynced(true);
        databaseReferenceChreographer.keepSynced(true);
        databaseReferenceCover.keepSynced(true);

        recyclerViewEhqOriginal = view.findViewById(R.id.recyclerview_ehq_dance_original);
        recyclerVieweChreographer = view.findViewById(R.id.recyclerview_chreograpgy);
        recyclerViewCover = view.findViewById(R.id.recyclerview_ehq_dance_covers);

        populateTheRecyclerView(databaseReferenceEhqOriginal,recyclerViewEhqOriginal);
        populateTheRecyclerView(databaseReferenceChreographer,recyclerVieweChreographer);
        populateTheRecyclerView(databaseReferenceCover,recyclerViewCover);



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



        return view;
    }



    private void populateTheRecyclerView(DatabaseReference databaseReference, RecyclerView recyclerView) {

        Query query =databaseReference.limitToLast(maxRow);


        FirebaseRecyclerAdapter<danceModal,danceViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<danceModal, danceViewHolder>
                (danceModal.class,R.layout.music_category_generic,danceViewHolder.class,query) {
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}