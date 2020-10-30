package com.ehq.ehq.ehq.RegisterActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ehq.ehq.ehq.R;

public class crewCategory extends AppCompatActivity {

    Button setDesigner,spotboy,assistant_composer,production_manager,sound_assistant,
            jimmy_jib,focus_puller,lighting,camera_assist,casting_assistant,makeup_assist,costume_assist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_category);

        setDesigner=findViewById(R.id.buttonSetDesigner);
        spotboy=findViewById(R.id.buttonSpotboy);
        assistant_composer=findViewById(R.id.buttonac);
        production_manager=findViewById(R.id.buttonProductionManager);
        sound_assistant=findViewById(R.id.buttonSoundAssistant);
        jimmy_jib=findViewById(R.id.buttonJimmyJIb);
        focus_puller=findViewById(R.id.buttonFocusPuller);
        lighting=findViewById(R.id.buttonLighting);
        camera_assist=findViewById(R.id.CameraAssistant);
        casting_assistant=findViewById(R.id.castingAssist);
        makeup_assist=findViewById(R.id.makeupAssist);
        costume_assist=findViewById(R.id.costumeAssist);

        setDesigner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","setDesigner");
                startActivity(intent);
            }
        });


        spotboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","spotboy");
                startActivity(intent);
            }
        });

        assistant_composer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","assistant_composer");
                startActivity(intent);
            }
        });

        production_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","production_manager");
                startActivity(intent);
            }
        });

        costume_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","costume_assist");
                startActivity(intent);
            }
        });


        makeup_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","makeup_assist");
                startActivity(intent);
            }
        });

        casting_assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","casting_assistant");
                startActivity(intent);
            }
        });

        camera_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","camera_assist");
                startActivity(intent);
            }
        });


        lighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","lighting");
                startActivity(intent);
            }
        });

        focus_puller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","focus_puller");
                startActivity(intent);
            }
        });

        jimmy_jib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","jimmy_jib");
                startActivity(intent);
            }
        });

        sound_assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","sound_assistant");
                startActivity(intent);
            }
        });

    }
}
