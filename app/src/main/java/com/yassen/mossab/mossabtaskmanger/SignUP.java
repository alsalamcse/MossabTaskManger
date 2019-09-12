package com.yassen.mossab.mossabtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUP extends AppCompatActivity {

    private EditText edtFname,edtLname,edtPhone,edtEmail,edtPassword,edtReEnter;
    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtFname=(EditText)(findViewById(R.id.edtFname));
        edtLname=(EditText)(findViewById(R.id.edtLname));
        edtPhone=(EditText)(findViewById(R.id.edtPhone));
        edtEmail=(EditText)(findViewById(R.id.edtEmail));
        edtPassword=(EditText)(findViewById(R.id.edtPassword));
        edtReEnter=(EditText)(findViewById(R.id.edtReEnter));
        btnsave=(Button)(findViewById(R.id.btnSave));

    }
}
