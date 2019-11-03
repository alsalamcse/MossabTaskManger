package com.yassen.mossab.mossabtaskmanger;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Data.MyTask;

public class AddTask extends AppCompatActivity {
    private EditText edtTittle,edtSubject;
    private SeekBar Seekbar;
    private TextView tvPriority;
    private Button btnSave2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        edtTittle=(EditText)(findViewById(R.id.edtTitlle));
        edtSubject=(EditText)(findViewById(R.id.edtSubject));
        Seekbar=(SeekBar)(findViewById(R.id.seekbar));
        tvPriority=(TextView)(findViewById(R.id.tvPriority));
        btnSave2=(Button)(findViewById(R.id.btnSave2));

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }
    
    private void dataHandler()
    {
        String title= edtTittle.getText().toString();
        String subject= edtSubject.getText().toString();
        int sekbar= Seekbar.getProgress();
        boolean isOk=true;

        if (title.length()<1)
        {
            edtTittle.setError("Tittle lenght error");
            isOk=false;
        }

        if (subject.length()<1)
        {
            edtSubject.setError("subject lenght error");
            isOk=false;
        }
        if (isOk) {

            MyTask t = new MyTask();
            t.setTittle(title);
            createTask(t);
            createTask(title, subject, sekbar);

        }
    }

    private void createTask(MyTask t)
    {
        //.1
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();

        FirebaseAuth auth= FirebaseAuth.getInstance(); // to get the under uid (or other details like email)
        String uid = auth.getCurrentUser().getUid();
        t.setOnwer(uid);
        
        String key = reference.child("tasks").push().getKey();
        reference.child("tasks").child(uid).child(key).setValue(t).addOnCompleteListener(AddTask.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddTask.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddTask.this, "add failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }

    private void createTask(String title,String subject,int sekbar)
    {

    }

}
