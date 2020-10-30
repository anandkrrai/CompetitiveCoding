package com.ehq.ehq.ehq.fragments;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ehq.ehq.ehq.Holders.socialViewHolder;
import com.ehq.ehq.ehq.Modals.socialModal;
import com.ehq.ehq.ehq.R;
import com.ehq.ehq.ehq.transistionActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class social extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String TAG ="comedy fragment";

    Context context;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerView;
        private DatabaseReference databaseReference;
        private FirebaseDatabase database;


    public social() {
        // Required empty public constructor
    }

    public static social newInstance(String param1, String param2) {
        social fragment = new social();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("social");
        databaseReference.keepSynced(true);
        context=getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view=inflater.inflate(R.layout.fragment_social, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerviewsocial);

        FirebaseRecyclerAdapter<socialModal,socialViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<socialModal, socialViewHolder>
                (socialModal.class,R.layout.comedy_row,socialViewHolder.class,databaseReference) {
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
                        intent.putExtra("imgsrc",viewHolder.getImgsrc().toString());
                        intent.putExtra("videosrc",viewHolder.getVideosrc().toString());
                        intent.putExtra("summary",viewHolder.getSummary().toString());
                        intent.putExtra("title",viewHolder.getTitle().toString());
                        intent.putExtra("duration",viewHolder.getDuration().toString());
                        intent.putExtra("director",viewHolder.getDirector().toString());
                        intent.putExtra("dor",viewHolder.getDor().toString());
                        intent.putExtra("backimg",viewHolder.getBackimg().toString());
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



        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));


        recyclerView.setAdapter(firebaseRecyclerAdapter);

        return view ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
