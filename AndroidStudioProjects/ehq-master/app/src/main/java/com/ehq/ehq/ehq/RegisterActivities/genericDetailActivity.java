package com.ehq.ehq.ehq.RegisterActivities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ehq.ehq.ehq.Modals.genericArtistModal;
import com.ehq.ehq.ehq.PaymentActivity;
import com.ehq.ehq.ehq.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;
import java.util.UUID;

public class genericDetailActivity extends AppCompatActivity {

    private String title;
    private TextView fedu;
    private Button sendData,customUpload;
    private genericArtistModal model;
    private EditText formal_education,workExperience,sample_work,optionalLink1,optionalLink2;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private int requestCodePdf=2,requestcodeAudio=3,requestcodeVieo=4,requestCodeImage=5;
    StorageReference ref;
    Uri path;
    StorageReference storageReference;
    FirebaseStorage firebaseStorage;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_detail);
        bundle=getIntent().getExtras();
        title=bundle.getString("type");

        database= FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("artist_database").child(title);

        customUpload=findViewById(R.id.genericArtistUpload);

        customUpload.setVisibility(View.INVISIBLE);

        firebaseStorage = FirebaseStorage.getInstance();

        storageReference=firebaseStorage.getReference().child("artist_media_data");

        setButtonFunction();

        model= new genericArtistModal();


        formal_education=findViewById(R.id.GenericFormalEducation);
        workExperience=findViewById(R.id.GenericFormalEducation);
        sample_work= findViewById(R.id.GenericWorkLink);
        sendData=findViewById(R.id.GenericButtonSendData);
        optionalLink1=findViewById(R.id.optionalLink1);
        optionalLink2=findViewById(R.id.optionalLink2);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.setName(bundle.getString("name"));
                model.setDob(bundle.getString("dob"));
                model.setPhone(bundle.getString("phone"));
                model.setEmail(bundle.getString("email"));
                model.setAddress(bundle.getString("address"));
                model.setAge(bundle.getString("age"));
                model.setLanguage(bundle.getString("language"));
                model.setQualification(bundle.getString("qualification"));
                model.setLanguage(bundle.getString("language"));
                model.setGender(bundle.getString("ling"));
                model.setFormalEducation(formal_education.getText().toString());
                model.setWorkExperience(workExperience.getText().toString());
                model.setSampleWork(sample_work.getText().toString());
                sendData(view);
            }

        });

    }

    private void setButtonFunction() {

        if(title.equals("sound_recordist")||title.equals("sound_editor")||title.equals("music_composer")||title.equals("foley_artist")||title.equals("music_director")){
            customUpload.setText("upload MP3 work (if any)");
            customUpload.setVisibility(View.VISIBLE);

            customUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setType("audio/*");
                    intent.setAction(intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent.createChooser(intent,"Choose"),requestcodeAudio);

                }
            });
        }else if(title.equals("screenplay_writer")||title.equals("story_writer")||title.equals("poet")){
            customUpload.setText("upload document/pdf work (if any)");
            customUpload.setVisibility(View.VISIBLE);

            customUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setType("application/*");
                    intent.setAction(intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent.createChooser(intent,"Choose"),requestCodePdf);

                }
            });
        }else if(title.equals("Comedian")){

            customUpload.setText("upload video of work (if any)");
            customUpload.setVisibility(View.VISIBLE);

            customUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setType("video/*");
                    intent.setAction(intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent.createChooser(intent,"Choose"),requestcodeVieo);

                }
            });

        }else if(title.equals("cinematographer")||title.equals("costume")||title.equals("makeup")){

            customUpload.setText("upload images of work (if any)");
            customUpload.setVisibility(View.VISIBLE);

            customUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent.createChooser(intent,"Choose"),requestCodeImage);

                }
            });

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");


//        if(resultCode==RESULT_OK && requestCode==requestCodeImage && data!=null && data.getData()!=null){
//            String addressOfLink= UUID.randomUUID().toString();
//            ref = storageReference.child(addressOfLink);
//            path = data.getData();
//            ref.putFile(path);
//            model.setWorkUploadLink(addressOfLink);
//
//        }else if(resultCode==RESULT_OK && requestCode==requestCodePdf && data!=null && data.getData()!=null){
//            String addressOfLink= UUID.randomUUID().toString();
//            ref = storageReference.child(addressOfLink);
//            path = data.getData();
//            ref.putFile(path);
//            model.setWorkUploadLink(addressOfLink);
//
//        }else if(resultCode==RESULT_OK && requestCode==requestcodeAudio && data!=null && data.getData()!=null){
//            String addressOfLink= UUID.randomUUID().toString();
//            ref = storageReference.child(addressOfLink);
//            path = data.getData();
//            ref.putFile(path);
//            model.setWorkUploadLink(addressOfLink);
//        }else

        if(resultCode==RESULT_OK && (requestCode==requestcodeVieo||requestCode==requestcodeAudio||requestCode==requestCodePdf||requestCode==requestCodeImage) && data!=null && data.getData()!=null){
            String addressOfLink= UUID.randomUUID().toString();
            ref = storageReference.child(addressOfLink);
            path = data.getData();
            ref.putFile(path).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Video"+"failed to upload,please try again", Toast.LENGTH_SHORT).show();

                }
            }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    Toast.makeText(getApplicationContext(), "Video"+"uploaded", Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                    double progress=(100)*(taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("uploaded"+progress+"%");
                }
            });;
            model.setWorkUploadLink(addressOfLink);

            progressDialog.show();

        }

    }

    private void sendData(View view) {


        if(model.getFormalEducation().length()<=0){
            Snackbar.make(view, "Please fill the Formal education Column", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        if(model.getSampleWork().length()<=0){
            Snackbar.make(view, "Please Enter the link to Sample Work", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        model.setOptionalLink1(optionalLink1.getText().toString());
        model.setOptionalLink1(optionalLink1.getText().toString());

        Intent intent1 = new Intent();
        intent1.setClass(getApplicationContext(),PaymentActivity.class);
        intent1.putExtra("type",title);
        intent1.putExtra("model",model);
        startActivity(intent1);



    }
}
