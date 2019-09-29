package com.yassen.mossab.mossabtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
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
            //creatAcount(email,passw);
        }
    }

}
