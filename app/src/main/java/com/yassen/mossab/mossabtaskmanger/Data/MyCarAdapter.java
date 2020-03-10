package com.yassen.mossab.mossabtaskmanger.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.yassen.mossab.mossabtaskmanger.R;

//1 new class                      //2 extends....
public class MyCarAdapter extends ArrayAdapter<MyCar>
{
     //3 fix error
    public MyCarAdapter(@NonNull Context context) {
        super(context,R.layout.car_item);
    }



    //4 override getview
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //4.1 build item xml view
        View view= LayoutInflater.from(getContext()).inflate(R.layout.car_item,parent,false);

        //4.2
        // findviewbyid
       // ImageView imageCar=view.findViewById(R.id.imgCar);
        TextView etPrice=view.findViewById(R.id.etPrice);
        TextView etType=view.findViewById(R.id.etType);
        TextView etKilometerage=view.findViewById(R.id.etKilometerage);
       // TextView etDenstance=view.findViewById(R.id.etDenstance);
        CheckBox cbIsdelete=view.findViewById(R.id.cbIsdelete);
        ImageButton imgPhone=view.findViewById(R.id.imgPhone);

        //4.3

        final MyCar myCar = getItem(position);


        cbIsdelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    //todo delete this item
                    FirebaseUtils.getRefrence().child(myCar.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if(databaseError==null)
                            {
                                Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                Toast.makeText(getContext(), "not deleted:"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        //4.5
        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "calling"+myCar.getPhoneNumber(), Toast.LENGTH_SHORT).show();

            }
        });


        //4.4
        etPrice.setText(myCar.getPrice());
        etType.setText(myCar.getTybe());
        etKilometerage.setText(myCar.getKilometerage());
        //4.6
        return view;

    }
}
