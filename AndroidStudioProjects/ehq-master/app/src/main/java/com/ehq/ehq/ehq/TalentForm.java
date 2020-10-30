package com.ehq.ehq.ehq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ehq.ehq.ehq.RegisterActivities.BasicInformationActivity;
import com.ehq.ehq.ehq.RegisterActivities.SoundandMusicCategory;
import com.ehq.ehq.ehq.RegisterActivities.WriterCategory;
import com.ehq.ehq.ehq.RegisterActivities.costumesAndMakeupCategory;
import com.ehq.ehq.ehq.RegisterActivities.crewCategory;
import com.ehq.ehq.ehq.RegisterActivities.dancenChreographyCategory;
import com.ehq.ehq.ehq.RegisterActivities.directorCategory;
import com.ehq.ehq.ehq.RegisterActivities.postProductionCategory;

public class TalentForm extends AppCompatActivity {

    Button actor,direction,cinematographer,postProduction,soundnMusic,dancenChoroegraphy,crew,writer,others,costumenMakeup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talent_form);

        actor = findViewById(R.id.buttonActor);
        direction = findViewById(R.id.buttonDirection);
        cinematographer = findViewById(R.id.buttonCinematography);
        postProduction = findViewById(R.id.buttonPostProduction);
        soundnMusic = findViewById(R.id.buttonSoundAndMusic);
        dancenChoroegraphy = findViewById(R.id.buttonDanceAndChoreography);
        crew = findViewById(R.id.buttonCrew);
        writer = findViewById(R.id.buttonWriter);
        others = findViewById(R.id.buttonOthers);
        costumenMakeup=findViewById(R.id.buttonCostumenMakeup);


        actor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), BasicInformationActivity.class);
                intent.putExtra("type","actor");
                startActivity(intent);
            }
        });

        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), directorCategory.class);
                intent.putExtra("type","direction");
                startActivity(intent);
            }
        });


        cinematographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), BasicInformationActivity.class);
                intent.putExtra("type","cinematographer");
                startActivity(intent);
            }
        });


        postProduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), postProductionCategory.class);
                intent.putExtra("type","postProduction");
                startActivity(intent);
            }
        });


        soundnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), SoundandMusicCategory.class);
                intent.putExtra("type","soundnMusic");
                startActivity(intent);
            }
        });


        dancenChoroegraphy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), dancenChreographyCategory.class);
                intent.putExtra("type","dancenChoroegraphy");
                startActivity(intent);
            }
        });


        crew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), crewCategory.class);
                intent.putExtra("type","crew");
                startActivity(intent);

            }
        });


        writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), WriterCategory.class);
                intent.putExtra("type","writer");
                startActivity(intent);
            }
        });


        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), BasicInformationActivity.class);
                intent.putExtra("type","others");
                startActivity(intent);
            }
        });

        costumenMakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(getApplicationContext(), costumesAndMakeupCategory.class);
                intent.putExtra("type","costumenmakeup");
                startActivity(intent);
            }
        });




    }
}
