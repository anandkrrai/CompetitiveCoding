package com.ehq.ehq.ehq.RegisterActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ehq.ehq.ehq.R;

public class costumesAndMakeupCategory extends AppCompatActivity {

    Button costume,makeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costumes_and_makeup_category);

            costume=findViewById(R.id.buttonCostume);
            makeup=findViewById(R.id.buttonMakeup);


        costume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","costume");
                startActivity(intent);
            }
        });


        makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),BasicInformationActivity.class);
                intent.putExtra("type","makeup");
                startActivity(intent);
            }
        });
    }
}
