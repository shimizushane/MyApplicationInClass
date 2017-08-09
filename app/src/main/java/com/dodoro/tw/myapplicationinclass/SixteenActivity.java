package com.dodoro.tw.myapplicationinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SixteenActivity extends AppCompatActivity implements ValueEventListener {

    EditText ed, ed2;
    TextView tv, tv2;
    FirebaseDatabase database;
    DatabaseReference myRef,myRef1;
    final String TAG = "CHECK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixteen);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        myRef1 = database.getReference("temper");


        // Read from the database
        myRef.addValueEventListener(this);
        myRef1.addValueEventListener(this);
    }
    public void clickupdata(View v)
    {
        ed = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
        myRef.setValue(ed.getText().toString());
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String value = dataSnapshot.getValue(String.class);
        tv = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv.setText(value);
        Log.d(TAG, "Value is: " + value);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

        // Failed to read value
        Log.w(TAG, "Failed to read value.", databaseError.toException());
    }
}
