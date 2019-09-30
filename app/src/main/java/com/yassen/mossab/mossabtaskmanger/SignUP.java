package com.yassen.mossab.mossabtaskmanger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUP extends AppCompatActivity {

    private EditText edtFname,edtLname,edtPhone,edtEmail,edtPassword,edtReEnter;
    private Button btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtFname=findViewById(R.id.edtFname);
        edtLname=(EditText)(findViewById(R.id.edtLname));
        edtPhone=(EditText)(findViewById(R.id.edtPhone));
        edtEmail=(EditText)(findViewById(R.id.edtEmail));
        edtPassword=(EditText)(findViewById(R.id.edtPassword));
        edtReEnter=(EditText)(findViewById(R.id.edtReEnter));
        btnS=(Button)(findViewById(R.id.btnS));

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datahandler();
            }
            });
    }
    private void datahandler()
    {
        String first=edtFname.getText().toString();
        String name=edtLname.getText().toString();
        String phone=edtPhone.getText().toString();
        String email=edtEmail.getText().toString();
        String pass=edtPassword.getText().toString();
        String pass1= edtReEnter.getText().toString();

        boolean isOk=true;
        if (email.length()<4 || email.indexOf("@")<0 || email.indexOf(".")<0)
        {
            edtEmail.setError(("wrong email"));
            isOk=false;
        }
        if (pass.length()<8|| pass1.equals(pass)==false)
        {
            edtPassword.setError("Have to be least 8 char and the same password");
            edtReEnter.setError("Have to be least 8 char and the same password");
            isOk=false;
        }
        if (first.length()==0)
        {
            edtFname.setError("enter name");
            isOk=false;
        }
        if (isOk)
        {
            creatAcount(email,pass,first,name,phone);
        }

    }

    private void creatAcount(String email, String pass, String first, String name, String phone)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(SignUP.this, "Sign up succesful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    edtEmail.setError("Sing n up failed");
                }

            }
        });

    }

}
