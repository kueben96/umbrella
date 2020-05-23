package com.example.umbrella;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class VisionFragment extends Fragment {

  private TextView txtVision;


  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_vision, null);
    txtVision = (TextView) rootView.findViewById(R.id.txtVision);


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



    return rootView;
  }
}
