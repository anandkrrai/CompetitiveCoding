package com.ehq.ehq.ehq.RegisterActivities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ehq.ehq.ehq.R;
import java.util.Calendar;

public class BasicInformationActivity extends AppCompatActivity {


    private String type="",ling="";
    private String title;
    private RadioGroup gender;
    private Button btnContinue;
    private EditText name ,address,phone,email,age,language,qualification;
    private TextView dob;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_information);

        Bundle bundle=getIntent().getExtras();
        type=bundle.getString("type");



        gender=findViewById(R.id.GenericGender1);
        name = findViewById(R.id.GenericName1);
        address = findViewById(R.id.GenericAddress1);
        phone=findViewById(R.id.GenericPhone1);
        email=findViewById(R.id.GenericEmail1);
        dob=findViewById(R.id.GenericDate1);
        age=findViewById(R.id.GenericAge1);
        language=findViewById(R.id.GenericLanguage1);
        qualification=findViewById(R.id.GenericQualification1);
        btnContinue=findViewById(R.id.BAsicInfoContinue);



        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=(RadioButton)findViewById(checkedId);
                Toast.makeText(getApplicationContext(),rb.getText(), Toast.LENGTH_SHORT).show();
                ling=rb.getText().toString();

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
                        BasicInformationActivity.this,
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


        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(v);
            }


        });
    }

    private void sendData(View view) {


        if(name.getText().length()<=0){
            Snackbar.make(view, "Please Enter The Name", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(address.getText().length()<=0){
            Snackbar.make(view, "Please Enter the Address", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(phone.getText().length()<=0){
            Snackbar.make(view, "Please Enter the phone Number", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        if(ling.length()<=0){
            Snackbar.make(view, "Please Choose the Gender", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
       if(dob.getText().length()<=0){
            Snackbar.make(view, "Please Enter the Date Of Birth", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(qualification.getText().length()<=0){
            Snackbar.make(view, "Please Enter the Qualification", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(email.getText().length()<=0){
            Snackbar.make(view, "Please Enter the Email Id", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(age.getText().length()<=0){
            Snackbar.make(view, "Please Enter the Age", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }if(language.getText().length()<=0){
            Snackbar.make(view, "Please Enter the Language", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }


        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),actor.class);

        if(type.equals("actor")){
            intent.setClass(getApplicationContext(),ActorDetailActivity.class);

        }else{
            intent.setClass(getApplicationContext(),genericDetailActivity.class);
        }

        intent.putExtra("name",name.getText().toString());
        intent.putExtra("address",address.getText().toString());
        intent.putExtra("phone",phone.getText().toString());
        intent.putExtra("email",email.getText().toString());
        intent.putExtra("dob",dob.getText().toString());
        intent.putExtra("age",age.getText().toString());
        intent.putExtra("language",language.getText().toString());
        intent.putExtra("gender",ling);
        intent.putExtra("qualification",qualification.getText().toString());
        intent.putExtra("type",type);

        startActivity(intent);

    }


}
