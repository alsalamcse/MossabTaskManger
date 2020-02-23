package com.yassen.mossab.mossabtaskmanger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private ImageView imageView;
    private EditText edtEmail, edtPassword;
    private Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        imageView = (ImageView) (findViewById(R.id.imageView));
        edtEmail = (EditText) (findViewById(R.id.edtEmail));
        edtPassword = (EditText) (findViewById(R.id.edtPassword));
        btnSignIn = (Button) (findViewById(R.id.btnSignIn));
        btnSignUp = (Button) (findViewById(R.id.btnSignUp));

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignUP.class);
                startActivity(i);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });

    }

    private void dataHandler() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        boolean isok = true;

       if (email.length() < 4)
       {
            edtEmail.setError("Email lenght error");
            isok = false;
       }

        if (email.indexOf("@") < 0 || email.indexOf(".") < 0) {
            edtEmail.setError("email wrong format");
            isok = false;
        }

//        if (isValidEmailAddress(email)==false)
//        {
//            edtEmail.setError("Invalid Email");
//            isok=false;
//        }

        if (password.length() < 8) {
            edtPassword.setError("password lenght error");
            isok = false;
        }
        if (isok)
        {
            signIn(email,password);
        }

    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();

    }

    private void signIn(String email, String password)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    //todo go to main screen(all task activity)
                    Intent intent=new Intent(getApplication(),MainTasksActivity.class);
                    startActivity(intent);
                }
                else
                {
                    edtEmail.setError("email or password is wrong");
                }
            }
        });

    }

}
