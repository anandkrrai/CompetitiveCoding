package com.ehq.ehq.ehq;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactMainActivity extends Activity {
	ArrayList<Contact> listContacts;
	ListView lvContacts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		// Here, thisActivity is the current activity
//		if (ContextCompat.checkSelfPermission(getApplicationContext(),
//				Manifest.permission.READ_CONTACTS)
//				!= PackageManager.PERMISSION_GRANTED) {
//
//			// Permission is not granted
//			// Should we show an explanation?
//			if (ActivityCompat.shouldShowRequestPermissionRationale(ContactMainActivity.this,
//					Manifest.permission.READ_CONTACTS)) {
//				// Show an explanation to the user *asynchronously* -- don't block
//				// this thread waiting for the user's response! After the user
//				// sees the explanation, try again to request the permission.
//			} else {
//				// No explanation needed; request the permission
//				ActivityCompat.requestPermissions(ContactMainActivity.this,
//						new String[]{Manifest.permission.READ_CONTACTS},
//						1);
//
//				// MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//				// app-defined int constant. The callback method gets the
//				// result of the request.
//			}
//		} else {
//			// Permission has already been granted
//		}
		listContacts = new ContactFetcher(this).fetchAll();
		lvContacts = (ListView) findViewById(R.id.lvContacts);
		ContactsAdapter adapterContacts = new ContactsAdapter(this, listContacts);
		lvContacts.setAdapter(adapterContacts);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.maincontact, menu);
		return true;
	}

}
