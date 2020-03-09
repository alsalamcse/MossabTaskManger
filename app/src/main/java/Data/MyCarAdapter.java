package Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yassen.mossab.mossabtaskmanger.R;

import org.w3c.dom.Text;

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
        ImageView imageCar=view.findViewById(R.id.imgCar);
        TextView etPrice=view.findViewById(R.id.etPrice);
        TextView etType=view.findViewById(R.id.etType);
        TextView etKilometerage=view.findViewById(R.id.etKilometerage);
        TextView etDenstance=view.findViewById(R.id.etDenstance);
        Button btnDelete=view.findViewById(R.id.btnDelete);
        ImageButton imgPhone=view.findViewById(R.id.imgPhone);

        //4.3
        final MyCar myCar = getItem(position);

        //4.4
        etPrice.setText(myCar.getPrice());
        etType.setText(myCar.getTybe());
        etKilometerage.setText(myCar.getKilometerage());

        //4.5
        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "calling"+myCar.getPhoneNumber(), Toast.LENGTH_SHORT).show();

            }
        });

        //4.6
        return view;

    }
}
