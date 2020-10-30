package com.ehq.ehq.ehq.RegisterActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ehq.ehq.ehq.R;

public class WriterCategory extends AppCompatActivity {

    Button lyricist,screenplay_writer,story_writer,poet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer_category);

        lyricist=findViewById(R.id.buttonLyricist);
        screenplay_writer=findViewById(R.id.buttonscreenplay);
        story_writer=findViewById(R.id.buttonStory);
        poet = findViewById(R.id.buttonpoet);


        lyricist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","lyricist");
                startActivity(intent);
            }
        });

        screenplay_writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","screenplay_writer");
                startActivity(intent);
            }
        });

        story_writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","story_writer");
                startActivity(intent);
            }
        });

        poet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","poet");
                startActivity(intent);
            }
        });



    }
}
