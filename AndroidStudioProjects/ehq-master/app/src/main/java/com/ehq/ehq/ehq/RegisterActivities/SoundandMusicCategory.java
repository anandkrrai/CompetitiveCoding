package com.ehq.ehq.ehq.RegisterActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ehq.ehq.ehq.R;

public class SoundandMusicCategory extends AppCompatActivity {

    Button music_composer,sound_editor,sound_recordist,foley_artist,music_director;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundand_music_category);


        music_composer= findViewById(R.id.buttonMusicComposer);
        sound_editor=findViewById(R.id.buttonSoundEditor);
        sound_recordist=findViewById(R.id.buttonSoundRecordist);
        foley_artist=findViewById(R.id.buttonFoleyArtist);
        music_director=findViewById(R.id.buttonMusicDirector);


        music_director.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","music_director");
                startActivity(intent);
            }
        });

        music_composer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","music_composer");
                startActivity(intent);
            }
        });

        sound_editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","sound_editor");
                startActivity(intent);
            }
        });

        sound_recordist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","sound_recordist");
                startActivity(intent);
            }
        });

        foley_artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","foley_artist");
                startActivity(intent);
            }
        });

    }
}
