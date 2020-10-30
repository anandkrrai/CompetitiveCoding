package com.ehq.ehq.ehq;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

import pl.droidsonroids.casty.Casty;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN = 1,REQUEST_INVITE=99;
    public Button registerButton;
    public ImageView searchImageView;
    public ImageView searchImageViewmic;
    public String mUsername="Anonymous";
    public String TAG ="Main2Activity";
    public FirebaseUser user;
    public FirebaseDatabase firebaseDatabasecontactSync;
    public DatabaseReference databaseReferenceContactSync;
    private Casty casty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // wrap the exoplayer in async task to avoid crashing in low end samrt phones

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Utils.getDatabase();

        searchImageView=findViewById(R.id.search);
        searchImageViewmic=findViewById(R.id.searchmic);

        TabLayout tabLayout = findViewById(R.id.tab);
        ViewPager viewPager = findViewById(R.id.viewpager);
        tabsPager tabspager = new tabsPager(getSupportFragmentManager());
        viewPager.setAdapter(tabspager);
        tabLayout.setupWithViewPager(viewPager);

        //---------------------casting------------------


        casty = Casty.create(this)
                .withMiniController();

////        setUpPlayButton();
////        setUpMediaRouteButton();
//
//
//
//        casty.setOnConnectChangeListener(new Casty.OnConnectChangeListener() {
//
//            @Override
//            public void onConnected() {
//                casty.getPlayer().loadMediaAndPlay(createSampleMediaData());
//
//            }
//
//            @Override
//            public void onDisconnected() {
//
//            }
//        });


//------------------------------------

        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseApp.initializeApp(this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        firebaseDatabasecontactSync=FirebaseDatabase.getInstance();
        databaseReferenceContactSync=firebaseDatabasecontactSync.getReference().child("user_sync");
        databaseReferenceContactSync.keepSynced(true);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    setNavigartionDrawerDetails();
                    contactSync();
                } else {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.PhoneBuilder().build()
                                    )).setTheme(R.style.BlackTheme)
                                    .build(),
                            RC_SIGN_IN);
                }
            }


        };

        registerButton = findViewById(R.id.RegisterButton2);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),TalentForm.class);
                startActivity(intent);
            }
        });

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),searchActivity.class);
                startActivity(intent);
            }
        }); searchImageViewmic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),searchActivity.class);
                startActivity(intent);
            }
        });



//        Toast.makeText(getApplicationContext(),"Internet Connection:" +isConnected(),Toast.LENGTH_LONG).show();
    }

//    private void setUpMediaRouteButton() {
//        MediaRouteButton mediaRouteButton = (MediaRouteButton) findViewById(R.id.media_route_button);
//        casty.setUpMediaRouteButton(mediaRouteButton);
//    }

    public void putData(){
        ContactsAdapter adapterContacts = new ContactsAdapter(this,  new ContactFetcher(this).fetchAll());
            databaseReferenceContactSync.child(mUsername).setValue("yes");
    }


    public void contactSync(){

        databaseReferenceContactSync.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (mUsername!=null&&!dataSnapshot.hasChild(mUsername)) {
                    putData();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        setNavigartionDrawerDetails();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Sign-in succeeded, set up the UI
                setNavigartionDrawerDetails();
                Toast.makeText(this, "Signed in!"+mUsername, Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                // Sign in was canceled by the user, finish the activity
                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        casty.addMediaRouteMenuItem(menu);
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent();

        if (id == R.id.nav_home) {
        } else if (id == R.id.nav_originals) {
            intent.putExtra("title","originals");
            intent.setClass(this,GenericTabActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_social) {
            intent.putExtra("title","social");
            intent.setClass(this,GenericTabActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_comedy) {
            intent.putExtra("title","comedy");
            intent.setClass(this,GenericTabActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_reality) {
            intent.putExtra("title","reality");
            intent.setClass(this,GenericTabActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_dance) {
            intent.putExtra("title","dance");
            intent.setClass(this,GenericTabActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_music) {
            intent.putExtra("title","music");
            intent.setClass(this,GenericTabActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_story) {
            intent.putExtra("title","story");
            intent.setClass(this,GenericTabActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_register) {
            intent.setClass(getApplicationContext(),TalentForm.class);
            startActivity(intent);
        }else if(id==R.id.nav_signOut){
            TextView name = findViewById(R.id.navigationDrawerName);
            TextView email = findViewById(R.id.navigationDrawerEmail);
            TextView number = findViewById(R.id.navigationDrawerMoblie);
            ImageView profilepicture=findViewById(R.id.navigationDrawerimageView);

            name.setText("");
            email.setText("");
            number.setText("");
            profilepicture.setBackground(null);
            AuthUI.getInstance().signOut(this);
            return true;
        }else if(id==R.id.nav_TermsAndCondition){
            intent.setClass(getApplicationContext(),TermsAndConditions.class);
            startActivity(intent);
        }else if(id==R.id.nav_share){
             intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
                    .setMessage(getString(R.string.invitation_message))
                    .setCallToActionText(getString(R.string.invitation_cta))
                    .build();
            startActivityForResult(intent, REQUEST_INVITE);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setNavigartionDrawerDetails(){
         TextView name = findViewById(R.id.navigationDrawerName);
         TextView email = findViewById(R.id.navigationDrawerEmail);
         TextView number = findViewById(R.id.navigationDrawerMoblie);

        if(user==null){
            return ;
        }

        if(name==null||email==null||number==null){
            return;
        }

        mUsername=user.getDisplayName();


        ImageView profilepicture=findViewById(R.id.navigationDrawerimageView);

        if(user.getPhotoUrl()!=null) {
            Picasso.with(getApplicationContext()).load(user.getPhotoUrl()).into(profilepicture);
        }

        name.setText(mUsername);
        if(user.getEmail()!=null) {
            email.setText(user.getEmail());
        }

        if(user.getPhoneNumber()!=null){
            number.setText(user.getPhoneNumber());
        }

    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return (connectivityManager.getActiveNetworkInfo() != null)
                && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

}
