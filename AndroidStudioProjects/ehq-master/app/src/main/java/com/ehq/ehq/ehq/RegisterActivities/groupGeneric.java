package com.ehq.ehq.ehq.RegisterActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ehq.ehq.ehq.Modals.groupArtistModal;
import com.ehq.ehq.ehq.PaymentActivity;
import com.ehq.ehq.ehq.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class groupGeneric extends AppCompatActivity {

    private String title;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private groupArtistModal model;

    private EditText name ,phone,email,workExperience,sample_work;

    Button sendData;

    Spinner spinner;
    String list[]={"2","3","4","5","6","7","8","8+"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_generic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("type");
        title= title.replace('-',' ');
        toolbar.setTitle(title);

        setSupportActionBar(toolbar);

        title=bundle.getString("type");

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("artist_database").child(title);

        model= new groupArtistModal();

        name = findViewById(R.id.GenericName);
        phone=findViewById(R.id.GenericPhone);
        email=findViewById(R.id.GenericEmail);
        workExperience=findViewById(R.id.GenericFormalEducation);
        sample_work= findViewById(R.id.GenericWorkLink);

        spinner=findViewById(R.id.spinner_numbers);
        sendData=findViewById(R.id.GenericButtonSendData);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                model.setMemberNumber(list[position].toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.setName(name.getText().toString());
                model.setPhone(phone.getText().toString());
                model.setEmail(email.getText().toString());
                model.setSamleWork(sample_work.getText().toString());
                sendData(view);
            }

        });
    }


    private void sendData(View view) {


        if(model.getName().length()<=0){
            Snackbar.make(view, "Please Enter The Name", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

       if(model.getEmail().length()<=0){
            Snackbar.make(view, "Please Enter the Email Id", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        if(model.getMemberNumber().length()<=0){
            Snackbar.make(view, "Please Enter the number of Team Members", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        if(model.getName().length()<=0){
            Snackbar.make(view, "Please Enter the phone number", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        if(model.getSamleWork().length()<=0){
            Snackbar.make(view, "Please Enter the Sample work", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

//        databaseReference.child(model.getPhone()).setValue(model);

        Intent intent1 = new Intent();
        intent1.setClass(getApplicationContext(),PaymentActivity.class);
        intent1.putExtra("type",title);
        intent1.putExtra("model",model);
        startActivity(intent1);

    }
}
