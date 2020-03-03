package com.yassen.mossab.mossabtaskmanger;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Data.MyCar;
import Data.MyCarAdapter;
import Data.MyTask;

//5 new activity

//5.1 add Listview to the xml
public class MyCarsActivity extends AppCompatActivity {

    //5.2
    private ListView lvcars;
    private MyCarAdapter myCarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cars);

        //5.3
        lvcars=findViewById(R.id.lvcars);
        myCarAdapter=new MyCarAdapter(getBaseContext(),R.layout.car_item);

        //5.4
        lvcars.setAdapter(myCarAdapter);
    }

    //6
    @Override
    protected void onResume() {
        super.onResume();
        readFromFirebase();
    }

    //5.5 download data from firebase
    public void readFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();// to connect to Firebase
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get user UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        // 5.6 add listener to update us about any change
        // change group name

        reference.child("cars").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                //5.7
                myCarAdapter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    //5.8
                    MyCar t=d.getValue(MyCar.class);
                    Log.d("MyCar",t.toString());
                    myCarAdapter.add(t);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });


    }


}