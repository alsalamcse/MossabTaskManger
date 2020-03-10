package com.yassen.mossab.mossabtaskmanger;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.yassen.mossab.mossabtaskmanger.Data.Client;
import com.yassen.mossab.mossabtaskmanger.Data.MyClientAdabter;

//5 new activity
//5.1 add ListView to the XML
public class MyClientsActivity extends AppCompatActivity {

    //5.2
    private ListView listView;
    private MyClientAdabter myClientAdabter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clients);
        //5.3
        listView=findViewById(R.id.listview);
        myClientAdabter=new MyClientAdabter(getBaseContext(),R.layout.client_item);

        //5.4
        listView.setAdapter(myClientAdabter);
    }
    //5.5 download data from firebase

    public void readTasksFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();// to connect to database
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        //5.6 add listener to update us about any change
        //change group name
        reference.child("Clients").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                myClientAdabter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                     Client c=d.getValue(Client.class);
                    Log.d("Client",c.toString());
                    myClientAdabter.add(c);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });


    }

}



