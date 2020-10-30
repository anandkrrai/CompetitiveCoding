package com.ehq.ehq.ehq.RegisterActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ehq.ehq.ehq.R;

public class dancenChreographyCategory extends AppCompatActivity {

    Button choreographer, dancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dancen_chreography_category);

        dancer = findViewById(R.id.buttonDancer);
        choreographer=findViewById(R.id.buttonChoreographer);

        dancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","dancer");
                startActivity(intent);
            }
        });

        choreographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","choreographer");
                startActivity(intent);
            }
        });
    }
}
