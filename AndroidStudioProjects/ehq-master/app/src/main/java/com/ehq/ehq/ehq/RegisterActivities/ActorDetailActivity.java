package com.ehq.ehq.ehq.RegisterActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.UUID;

public class ActorDetailActivity extends AppCompatActivity {

    private RadioGroup maritalStatus,complexion;
    private EditText eye_colour,height,weight,formal_education,workExperience,sample_work;

    private actorModal model;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    Button sendData;

    private ImageView image1,image2,image3,image4;
    private Uri filepath1,filepath2,filepath3,filepath4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("artist_database").child("actor");
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference().child("artist_media_data").child("Actor_images");

        final Bundle bundle=getIntent().getExtras();



        model= new actorModal();

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
        sendData=findViewById(R.id.sendData);
        maritalStatus=findViewById(R.id.viewGroupMaritalStatus);
        complexion=findViewById(R.id.radioGroupActorComplexion);


        complexion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=(RadioButton)findViewById(checkedId);
//                Toast.makeText(getApplicationContext(),rb.getText(),Toast.LENGTH_SHORT).show();
                model.setComplexion(rb.getText().toString());

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

                model.setName(bundle.getString("name"));
                model.setDob(bundle.getString("dob"));
                model.setPhone(bundle.getString("phone"));
                model.setEmail(bundle.getString("email"));
                model.setAddress(bundle.getString("address"));
                model.setAge(bundle.getString("age"));
                model.setLanguage(bundle.getString("language"));
                model.setQualification(bundle.getString("qualification"));
                model.setLanguage(bundle.getString("language"));
                model.setEyeColour(eye_colour.getText().toString());
                model.setGender(bundle.getString("ling"));
                model.setHeight(height.getText().toString());
                model.setWeight(weight.getText().toString());
                model.setFormalEducation(formal_education.getText().toString());
                model.setWorkExperience(workExperience.getText().toString());
                model.setSampleWork(sample_work.getText().toString());


                sendData(view);
            }
        });

    }


    public void sendData(View view){

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
        }if(model.getWorkExperience().length()<=0){
            Snackbar.make(view, "Please Enter the Work Experience", Snackbar.LENGTH_LONG).setAction("Action", null).show();
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

        Intent intent1 = new Intent();
        intent1.setClass(getApplicationContext(),PaymentActivity.class);
        intent1.putExtra("type","actor");
        intent1.putExtra("model",model);
        startActivity(intent1);

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

}
