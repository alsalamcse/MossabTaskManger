package com.yassen.mossab.mossabtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {
    private EditText edtTittle,edtSubject;
    private SeekBar Seekbar;
    private TextView tvPriority;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        edtTittle=(EditText)(findViewById(R.id.edtTitlle));
        edtSubject=(EditText)(findViewById(R.id.edtSubject));
        Seekbar=(SeekBar)(findViewById(R.id.seekbar));
        tvPriority=(TextView)(findViewById(R.id.tvPriority));
        btnSave=(Button)(findViewById(R.id.btnSave));
    }
}
