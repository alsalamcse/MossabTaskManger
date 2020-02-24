package com.yassen.mossab.mossabtaskmanger;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddCar extends AppCompatActivity {
    private ImageView edImage;
    private Button btnChoose,btnUpload,btnSave;
    private EditText edTybe,edPrice,edModel,edColor,edKilometerage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        edImage=(ImageView)(findViewById(R.id.edImage));
        btnSave=(Button)(findViewById(R.id.btnSave));
        btnUpload=(Button)(findViewById(R.id.btnUpload));
        edTybe=(EditText)(findViewById(R.id.edTybe));
        edPrice=(EditText)(findViewById(R.id.edPrice));
        edModel=(EditText)(findViewById(R.id.edModel));
        edColor=(EditText)(findViewById(R.id.edColor));
        edKilometerage=(EditText)(findViewById(R.id.edKilometerage));




    }
}
