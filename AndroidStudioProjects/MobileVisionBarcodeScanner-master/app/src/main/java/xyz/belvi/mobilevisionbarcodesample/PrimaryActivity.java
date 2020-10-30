package xyz.belvi.mobilevisionbarcodesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrimaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPhoneActivity(View view) {
        Intent intent = new Intent(PrimaryActivity.this, PhoneActivity.class);
        startActivity(intent);
    }
}
