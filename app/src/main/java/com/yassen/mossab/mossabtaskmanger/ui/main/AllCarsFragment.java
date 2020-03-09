package com.yassen.mossab.mossabtaskmanger.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yassen.mossab.mossabtaskmanger.R;

import Data.MyCar;
import Data.MyCarAdapter;


public class AllCarsFragment extends Fragment {
    private ListView lvcars;
    private MyCarAdapter myCarAdapter;

    public AllCarsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        myCarAdapter=new MyCarAdapter(getContext());
       View view= inflater.inflate(R.layout.fragment_all_cars, container, false);
        lvcars=view.findViewById(R.id.lvcars);
        lvcars.setAdapter(myCarAdapter);

        return view;
    }


    @Override
    public void onResume() {
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

        reference.child("Cars").addValueEventListener(new ValueEventListener() {
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