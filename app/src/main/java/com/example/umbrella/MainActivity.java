package com.example.umbrella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

  //private FirebaseDatabase mRef;
  //private DatabaseReference

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    //set view
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView navigation = findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(this);

    loadFragment(new HomeFragment());

  }

  private boolean loadFragment(Fragment fragment){
    if(fragment!=null){

        getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.fragmen_container, fragment)
          .commit();

      return true;
    }
    return false;
  }


  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {

    Fragment fragment = null;

    switch (item.getItemId()){
      case R.id.nav_home:
        fragment = new HomeFragment();
        break;
      case R.id.nav_contact:
        fragment = new ContactFragment();
        break;
      case R.id.nav_history:
        fragment = new HistoryFragment();
        break;
      case  R.id.nav_vision:
        fragment = new VisionFragment();
        break;
    }
    return loadFragment(fragment);
  }
}
