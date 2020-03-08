package com.yassen.mossab.mossabtaskmanger.ui.main;


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
import Data.MyTask;
import Data.TasksAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTasksFragment extends Fragment {

    private TasksAdapter tasksAdapte;
    private ListView lvTasks;


    public AllTasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        tasksAdapte=new TasksAdapter(getContext());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_tasks, container, false);
        lvTasks=view.findViewById(R.id.lstvTasks);

        lvTasks.setAdapter(tasksAdapte);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase();
    }

    public void readTasksFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();// to connect to Firebase
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                tasksAdapte.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    MyCar car=d.getValue(MyCar.class);
                    Log.d("MyTask",car.toString());
                    tasksAdapte.add(car);
                    
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });


    }

}