package com.ehq.ehq.ehq.RegisterActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ehq.ehq.ehq.R;

public class postProductionCategory extends AppCompatActivity {

    Button video_editor,colorist,vfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_production_category);

    video_editor=findViewById(R.id.buttonVideoEditor);
    colorist=findViewById(R.id.buttoncolorist);
    vfx= findViewById(R.id.buttonVFX);


        video_editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","video_editor");
                startActivity(intent);
            }
        });

        colorist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","colorist");
                startActivity(intent);
            }
        });

        vfx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","vfx");
                startActivity(intent);
            }
        });


    }
}
