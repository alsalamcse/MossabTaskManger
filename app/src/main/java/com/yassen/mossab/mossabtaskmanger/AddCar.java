package com.yassen.mossab.mossabtaskmanger;

import android.arch.lifecycle.ViewModelProvider;
import android.location.Address;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Data.MyCar;

public class AddCar extends AppCompatActivity {
    private ImageView edImage;
    private Button btnChoose,btnUpload,btnSave;
    private EditText edTybe,edPrice,edModel,edColor,edKilometerage,edNumber,edAdrees;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        edImage=(ImageView)(findViewById(R.id.edImage));
        btnSave=(Button)(findViewById(R.id.btnSave));
        btnChoose=(Button)(findViewById(R.id.btnChoose));
        btnUpload=(Button)(findViewById(R.id.btnUpload));
        edTybe=(EditText)(findViewById(R.id.edTybe));
        edPrice=(EditText)(findViewById(R.id.edPrice));
        edModel=(EditText)(findViewById(R.id.edModel));
        edColor=(EditText)(findViewById(R.id.edColor));
        edKilometerage=(EditText)(findViewById(R.id.edKilometerage));
        edNumber=(EditText)(findViewById(R.id.edNumber));
        edAdrees=(EditText)(findViewById(R.id.edAdrees));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
      //  btnUpload.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View v) {

           // }
       // });
      //  btnChoose.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {


            }
       // });




    public void dataHandler()
    {
        String Tybe=edTybe.getText().toString();
        String Model=edModel.getText().toString();
        String Price=edPrice.getText().toString();
        Integer p1=Integer.parseInt(Price);
        String Color=edColor.getText().toString();
        String Kilometerage=edKilometerage.getText().toString();
        Double kilometer=Double.parseDouble(Kilometerage);
        String PhoneNumber=edNumber.getText().toString();
        String Adrees=edAdrees.getText().toString();
        boolean isOk=true;

        if (Tybe.length()<1)
        {
            edTybe.setError("Tittle lenght error");
            isOk=false;
        }
        if (Model.length()<4)
        {
            edModel.setError("Model length error");
            isOk=false;
        }
        if (PhoneNumber.length()!=10)
        {
            edNumber.setError("PhoneNumber length error");
        }
       if (Price.length()<1)
       {
            edColor.setError("Price length error");
            isOk=false;
        }
        if (Color.length()<3)
        {
            edColor.setError("Color length error");
        }
        if (Adrees.length()<1)
        {
            edAdrees.setError("Addres lenght error");
        }

        if (isOk)
        {
            MyCar car=new MyCar();
            car.setColor(Color);
            car.setModel(Model);
            car.setPrice(Price);
            car.setKilometerage(Kilometerage);
            car.setTybe(Tybe);
            car.setPhoneNumber(PhoneNumber);
            createCar(car);

        }

    }
    private void createCar(MyCar car)
    {

        //.1
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();

        FirebaseAuth auth= FirebaseAuth.getInstance(); // to get the under uid (or other details like email)
        String uid = auth.getCurrentUser().getUid();
        car.setOwner(uid);

        String key = reference.child("Cars").push().getKey();
        car.setKey(key);
        reference.child("Cars").child(uid).child(key).setValue(car).addOnCompleteListener(AddCar.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> car) {
                if (car.isSuccessful())
                {
                    Toast.makeText(AddCar.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddCar.this, "add failed"+car.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    car.getException().printStackTrace();
                }
            }
        });


    }
}
