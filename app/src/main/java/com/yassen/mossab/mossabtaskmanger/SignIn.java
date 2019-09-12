package com.yassen.mossab.mossabtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignIn extends AppCompatActivity {
    private ImageView imageView;
    private EditText edtEmail,edtPassword;
    private Button btnSignIn,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        imageView=(ImageView)(findViewById(R.id.imageView));
        edtEmail=(EditText)(findViewById(R.id.edtEmail));
        edtPassword=(EditText)(findViewById(R.id.edtPassword));
        btnSignIn=(Button)(findViewById(R.id.btnSignIn));
        btnSignUp=(Button)(findViewById(R.id.btnSignUp));


    }


}
