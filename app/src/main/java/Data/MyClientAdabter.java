package Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yassen.mossab.mossabtaskmanger.R;

//1 new class                         //2 extends...
public class MyClientAdabter extends ArrayAdapter<Client>
{
    //3 fix error
    public MyClientAdabter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    //4 override get view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
       //4.1 build item XML view
        View view= LayoutInflater.from(getContext()).inflate(R.layout.client_item,parent,false);
        //4.2 findViewById
        ImageView imageView=view.findViewById(R.id.imgCleint);
        ImageButton imgCall=view.findViewById(R.id.imgButtonCall);
        Button btnDel=view.findViewById(R.id.btnItemDel);
        TextView tvName=view.findViewById(R.id.tvItemName);

        //4.3 get data object
        final Client client = getItem(position);

        //4.4 set object data on the view
        tvName.setText(client.getName());

        //4.5 add event listener
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "calling"+client.getPhoneNumber(),Toast.LENGTH_SHORT).show();
            }
        });
        //4.6
        return view;
    }
}
