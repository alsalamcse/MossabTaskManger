package com.yassen.mossab.mossabtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Sitting extends AppCompatActivity {
    private Switch sound;
    private TextView frontSize;
    private SeekBar Seekbar;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitting);
        sound=(Switch)(findViewById(R.id.sound));
        frontSize=(TextView)(findViewById(R.id.frontSize));
        Seekbar=(SeekBar)(findViewById(R.id.Seekbar));
        btnSave=(Button)(findViewById(R.id.btnSave));



    }
}
