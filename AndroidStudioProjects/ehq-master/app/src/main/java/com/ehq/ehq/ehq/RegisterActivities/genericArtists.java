package com.ehq.ehq.ehq.RegisterActivities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

public class genericArtists extends AppCompatActivity {

    private String title;
    private TextView fedu;

    private RadioGroup gender;
    private Button sendData,customUpload;
    private genericArtistModal model;

    private EditText name ,address,phone,email,age,language,qualification,formal_education,workExperience,sample_work,optionalLink1,optionalLink2;
    private TextView dob;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private int requestCodePdf=2,requestcodeAudio=3,requestcodeVieo=4,requestCodeImage=5;

    private DatePickerDialog.OnDateSetListener mDateSetListener;


    StorageReference ref;
    Uri path;
    StorageReference storageReference;
    FirebaseStorage firebaseStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_artists);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("type");
        title= title.replace('-',' ');

        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        title=bundle.getString("type");


        fedu = findViewById(R.id.GenericFormalEducationDisplay);
        fedu.setText("Formal Education in "+title+"(if Any)");

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("artist_database").child(title);

        customUpload=findViewById(R.id.genericArtistUpload);

        customUpload.setVisibility(View.INVISIBLE);

        firebaseStorage = FirebaseStorage.getInstance();

        storageReference=firebaseStorage.getReference().child("artist_media_data");

        setButtonFunction();

        model= new genericArtistModal();


        gender=findViewById(R.id.GenericGender);
        name = findViewById(R.id.GenericName);
        address = findViewById(R.id.GenericAddress);
        phone=findViewById(R.id.GenericPhone);
        email=findViewById(R.id.GenericEmail);
        dob=findViewById(R.id.GenericDate);
        age=findViewById(R.id.GenericAge);
        language=findViewById(R.id.GenericLanguage);
        qualification=findViewById(R.id.GenericQualification);
        formal_education=findViewById(R.id.GenericFormalEducation);
        workExperience=findViewById(R.id.GenericFormalEducation);
        sample_work= findViewById(R.id.GenericWorkLink);
        sendData=findViewById(R.id.GenericButtonSendData);
        optionalLink1=findViewById(R.id.optionalLink1);
        optionalLink2=findViewById(R.id.optionalLink2);



        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=(RadioButton)findViewById(checkedId);
                Toast.makeText(getApplicationContext(),rb.getText(), Toast.LENGTH_SHORT).show();
                model.setGender(rb.getText().toString());

            }
        });


        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.setName(name.getText().toString());
                model.setDob(dob.getText().toString());
                model.setPhone(phone.getText().toString());
                model.setEmail(email.getText().toString());
                model.setAddress(address.getText().toString());
                model.setAge(age.getText().toString());
                model.setLanguage(language.getText().toString());
                model.setQualification(qualification.getText().toString());
                model.setLanguage(language.getText().toString());
                model.setFormalEducation(formal_education.getText().toString());
                model.setWorkExperience(workExperience.getText().toString());
                model.setSampleWork(sample_work.getText().toString());


                sendData(view);
            }

        });

        dob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        genericArtists.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
//                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                dob.setText(date);
            }
        };


    }

    private void setButtonFunction() {

        if(title.equals("Singer")||title.equals("Music-Composer")||title.equals("Sound-Recorder")){
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
        }else if(title.equals("Lyricist")||title.equals("ScriptWriter")){
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

        }else if(title.equals("Cinematographer")||title.equals("Makeup-and-HairStyle")||title.equals("Costume-Designer")){

            customUpload.setText("upload image of work (if any)");
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


        if(model.getName().length()<=0){
            Snackbar.make(view, "Please Enter The Name", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(model.getAddress().length()<=0){
            Snackbar.make(view, "Please Enter the Address", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(model.getPhone().length()<=0){
            Snackbar.make(view, "Please Enter the phone Number", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(model.getGender().length()<=0){
            Snackbar.make(view, "Please Choose the Gender", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

       if(model.getDob().length()<=0){
            Snackbar.make(view, "Please Enter the Date Of Birth", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(model.getQualification().length()<=0){
            Snackbar.make(view, "Please Enter the Qualification", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(model.getEmail().length()<=0){
            Snackbar.make(view, "Please Enter the Email Id", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(model.getAge().length()<=0){
            Snackbar.make(view, "Please Enter the Age", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(model.getLanguage().length()<=0){
            Snackbar.make(view, "Please Enter the Date Of Birth", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(model.getWorkExperience().length()<=0){
            Snackbar.make(view, "Please Enter the Work Experience", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(model.getFormalEducation().length()<=0){
            Snackbar.make(view, "Please fill the Formal education Column", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }


        if(model.getSampleWork().length()<=0){
            Snackbar.make(view, "Please Enter the link to Sample Work", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }


        model.setOptionalLink1(optionalLink1.getText().toString());
        model.setOptionalLink1(optionalLink1.getText().toString());

//        databaseReference.child(databaseReference.push().getKey()).setValue(model);
//        databaseReference.child(model.getPhone()).setValue(model);

        Intent intent1 = new Intent();
        intent1.setClass(getApplicationContext(),PaymentActivity.class);
        intent1.putExtra("type",title);
        intent1.putExtra("model",model);
        startActivity(intent1);



    }
}
