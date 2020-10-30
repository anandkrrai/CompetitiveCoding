package com.ehq.ehq.ehq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ehq.ehq.ehq.Modals.actorModal;
import com.ehq.ehq.ehq.Modals.genericArtistModal;
import com.ehq.ehq.ehq.Modals.groupArtistModal;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends Activity implements PaymentResultListener {
    private static final String TAG = PaymentActivity.class.getSimpleName();
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private String type="";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_payment);

        /*
         To ensure faster loading of the Checkout form,
          call this method as early as possible in your checkout flow.
         */
        Checkout.preload(getApplicationContext());

        // Payment button created by you in XML layout
        Button button = (Button) findViewById(R.id.btn_pay);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });


        Bundle bundle=getIntent().getExtras();
        type=bundle.getString("type");

    }


    private void putData(){
        database=FirebaseDatabase.getInstance();

        if(type==null){
            Toast.makeText(getApplicationContext(),"FAiled to get the type", Toast.LENGTH_LONG).show();
            return;
        }
        if(type.equals("actor")){

            databaseReference=database.getReference().child("artist_database").child("actor");
            actorModal model = getIntent().getParcelableExtra("model");
            databaseReference.child(databaseReference.push().getKey()).setValue(model);

        }else if(type.equals("Dance-Groups")){
            databaseReference=database.getReference().child("artist_database").child("Dance-Groups");
            groupArtistModal model = getIntent().getParcelableExtra("model");
            databaseReference.child(databaseReference.push().getKey()).setValue(model);


        }else if(type.equals("Music-Bands")){
            databaseReference=database.getReference().child("artist_database").child("Music-Bands");
            groupArtistModal model = getIntent().getParcelableExtra("model");
            databaseReference.child(databaseReference.push().getKey()).setValue(model);

        }else {
            databaseReference=database.getReference().child("artist_database").child(type);
            genericArtistModal model = getIntent().getParcelableExtra("model");
            databaseReference.child(databaseReference.push().getKey()).setValue(model);
            Toast.makeText(getApplicationContext(),"reached payment part of generic activity",Toast.LENGTH_LONG).show();

        }

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),Main2Activity.class);
        startActivity(intent);

        finish();

    }

    public void startPayment() {
        /*
          You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
        final Activity activity = this;

        final Checkout co = new Checkout();

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Razorpay Corp");
            options.put("description", "Demoing Charges");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount", "100");

            JSONObject preFill = new JSONObject();
            preFill.put("email", "test@razorpay.com");
            preFill.put("contact", "9876543210");

            options.put("prefill", preFill);

            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }
    }

    /**
     * The name of the function has to be
     * onPaymentSuccess
     * Wrap your code in try catch, as shown, to ensure that this method runs correctly
     */
    @SuppressWarnings("unused")
    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        try {
            Toast.makeText(this, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentSuccess", e);
        }
    }

    /**
     * The name of the function has to be
     * onPaymentError
     * Wrap your code in try catch, as shown, to ensure that this method runs correctly
     */
    @SuppressWarnings("unused")
    @Override
    public void onPaymentError(int code, String response) {

        putData();

        try {
            Toast.makeText(this, "Payment failed: " + code + " " + response, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentError", e);
        }
    }
}
