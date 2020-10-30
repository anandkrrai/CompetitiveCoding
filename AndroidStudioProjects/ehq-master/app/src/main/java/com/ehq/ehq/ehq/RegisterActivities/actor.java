package com.ehq.ehq.ehq.RegisterActivities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ehq.ehq.ehq.Modals.actorModal;
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

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

public class actor extends AppCompatActivity {

    private RadioGroup gender,maritalStatus,complexion;
    private Button sendData;
    private actorModal model;

    private EditText name ,address,phone,email,age,language,qualification,eye_colour,height,weight,formal_education,workExperience,sample_work;

    private ImageView image1,image2,image3,image4;
   private Uri filepath1,filepath2,filepath3,filepath4;

   private TextView dob;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    private DatePickerDialog.OnDateSetListener mDateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Actor Application Form");
        setSupportActionBar(toolbar);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("artist_database").child("actor");
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference().child("artist_media_data").child("Actor_images");


        model= new actorModal();


        gender=findViewById(R.id.actorGender);
        maritalStatus=findViewById(R.id.viewGroupMaritalStatus);
        complexion=findViewById(R.id.radioGroupActorComplexion);
        sendData=findViewById(R.id.actorButtonSendData);
        name = findViewById(R.id.actorName);
        address = findViewById(R.id.actorAddress);
        phone=findViewById(R.id.actorPhone);
        email=findViewById(R.id.actorEmail);
        dob=findViewById(R.id.editTextActorDate);
        age=findViewById(R.id.editTextActorAge);
        language=findViewById(R.id.actorLanguage);
        qualification=findViewById(R.id.actorQualification);
        eye_colour=findViewById(R.id.actorEyecolour);
        height=findViewById(R.id.actorHeight);
        weight=findViewById(R.id.actorWeight);
        formal_education=findViewById(R.id.actorFormalEducation);
        workExperience=findViewById(R.id.actorFormalEducation);
        sample_work= findViewById(R.id.actorWorkLink);

        image1=findViewById(R.id.actorImage1);
        image2=findViewById(R.id.actorImage2);
        image3=findViewById(R.id.actorImage3);
        image4=findViewById(R.id.actorImage4);


        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=(RadioButton)findViewById(checkedId);
                Toast.makeText(getApplicationContext(),rb.getText(), Toast.LENGTH_SHORT).show();
                model.setGender(rb.getText().toString());

            }
        });

        maritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=(RadioButton)findViewById(checkedId);
//                Toast.makeText(getApplicationContext(),rb.getText(),Toast.LENGTH_SHORT).show();
                model.setMaritalStatus(rb.getText().toString());

            }
        });


        complexion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=(RadioButton)findViewById(checkedId);
//                Toast.makeText(getApplicationContext(),rb.getText(),Toast.LENGTH_SHORT).show();
                model.setComplexion(rb.getText().toString());

            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseImage(1);
            }


        });   image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseImage(2);
            }


        });   image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseImage(3);
            }


        });   image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseImage(4);
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
                model.setEyeColour(eye_colour.getText().toString());
                model.setHeight(height.getText().toString());
                model.setWeight(weight.getText().toString());
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
                        actor.this,
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

    public void sendData(View view){


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
        if(model.getComplexion().length()<=0){
            Snackbar.make(view, "Please Choose the Complexion", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(model.getHeight().length()<=0){
            Snackbar.make(view, "Please Enter the Height", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        if(model.getWeight().length()<=0){
            Snackbar.make(view, "Please Enter the Weight", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        if(model.getMaritalStatus().length()<=0){
            Snackbar.make(view, "Please Choose the Marital Status", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(model.getDob().length()<=0){
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
        if(model.getEyeColour().length()<=0){
            Snackbar.make(view, "Please Enter the Eye colour", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(model.getSampleWork().length()<=0){
            Snackbar.make(view, "Please Enter the link to Sample Work", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(filepath1==null){
            Snackbar.make(view, "Please Upload the 1st Image", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;

        } if(filepath2==null){
            Snackbar.make(view, "Please Upload the 2nd Image", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;

        } if(filepath3==null){
            Snackbar.make(view, "Please Upload the 3rd Image", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;

        } if(filepath4==null){
            Snackbar.make(view, "Please Upload the 4th Image", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;

        }

//        UploadImage(filepath1,1);
//        UploadImage(filepath2,2);
//        UploadImage(filepath3,3);
//        UploadImage(filepath4,4);

//        databaseReference.child(databaseReference.push().getKey()).setValue(model);
//        databaseReference.child(model.getPhone()).setValue(model);

        Intent intent1 = new Intent();
        intent1.setClass(getApplicationContext(),PaymentActivity.class);
        intent1.putExtra("type","actor");
        intent1.putExtra("model",model);
        startActivity(intent1);

    }

    private void UploadImage(Uri filepath, final int x) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");

        String addressOfLink= UUID.randomUUID().toString();
        if(x==1){
            model.setImage1(addressOfLink);
        }else if(x==2){
            model.setImage2(addressOfLink);

        }else if(x==3){
            model.setImage3(addressOfLink);

        }else if(x==4){
            model.setImage4(addressOfLink);

        }
        StorageReference ref = storageReference.child(addressOfLink);

        ref.putFile(filepath)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Image"+x+"failed to upload,please try again", Toast.LENGTH_SHORT).show();

                    }
                }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                Toast.makeText(getApplicationContext(), "Image"+x+"uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                double progress=(100)*(taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setMessage("uploaded"+progress+"%");
            }
        });


        progressDialog.show();


    }



    private void ChooseImage(int photoRequestcode) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent,"Choose the Headshot"),photoRequestcode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK&&data!=null&&data.getData()!=null){

            try {
                if(requestCode==1){
                    filepath1= data.getData();
                    Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath1);
                    image1.setImageBitmap(bitmap);
                            UploadImage(filepath1,1);


                } if(requestCode==2){
                    filepath2= data.getData();
                    Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath2);
                    image2.setImageBitmap(bitmap);
                            UploadImage(filepath2,2);

                }
                if(requestCode==3){
                    filepath3= data.getData();
                    Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath3);
                    image3.setImageBitmap(bitmap);
                            UploadImage(filepath3,3);

                }
                if(requestCode==4){
                    filepath4= data.getData();
                    Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath4);
                    image4.setImageBitmap(bitmap);
                            UploadImage(filepath4,4);

                }

            }catch (IOException e){
//                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Error!!", Toast.LENGTH_SHORT);
            }

        }
    }
}
