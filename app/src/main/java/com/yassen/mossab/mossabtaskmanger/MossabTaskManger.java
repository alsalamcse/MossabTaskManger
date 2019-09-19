package com.yassen.mossab.mossabtaskmanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MossabTaskManger extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mossab_task_manger);

        Thread th=new Thread()
        {
            @Override
        public void run()
        {
            try {
                sleep(3*1000);
                Intent i=new Intent(getApplication(),SignIn.class);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        };

        th.start();

    }
}
