package com.example.umbrella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{

  private Button mSendData;
  private Button loadHistory;
  private Button loadVision;
  private Button loadContact;
  private TextView txtVision;

  //private FirebaseDatabase mRef;
  //private DatabaseReference

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    //set view
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //load widgets
    int myBtnColor = Color.parseColor("#006837");
    loadHistory = (Button) findViewById(R.id.btnLoadHistory);
    loadVision = (Button) findViewById(R.id.btnLoadVision);
    loadContact = (Button) findViewById(R.id.btnLoadContact);
    txtVision = (TextView) findViewById(R.id.txtVision);

    loadContact.setBackgroundColor(myBtnColor);
    loadHistory.setBackgroundColor(myBtnColor);
    loadVision.setBackgroundColor(myBtnColor);


    mSendData = (Button) findViewById(R.id.btnLoadContact);


    //get a database reference
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef;
    myRef = database.getReference("company_info");

    myRef.child("vision").addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String vision = dataSnapshot.getValue(String.class);
        txtVision.setText(vision);
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });



    loadContact.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
          DatabaseReference mRefChild = myRef.child("vision");
        //String vision = dataSnapshot.getValue(String.class);
        Log.d("tag","click");
      }
    });

    mSendData.setOnClickListener(new View.OnClickListener(){
      public void onClick(View view){
        DatabaseReference mRefChild = myRef.child("Name");
        mRefChild.setValue("Anil");
        Log.d("tag", "click");
      }
    });


  }
}
