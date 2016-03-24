package bello.andrea.listviewexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        final MioAdapter adapter = new MioAdapter();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MioElemento mioElemento = new MioElemento();
                if(Math.random() > 0.5)
                    mioElemento.imageId = R.drawable.image1;
                else
                    mioElemento.imageId = R.drawable.image2;
                mioElemento.text = Math.random() + "";
                adapter.add(mioElemento);
                adapter.notifyDataSetChanged();
            }
        });
    }


    public class MioAdapter extends BaseAdapter{

        ArrayList<MioElemento> array;

        public MioAdapter() {
            this.array = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return array.size();
        }

        @Override
        public Object getItem(int position) {
            return array.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.element_layout, parent);
            }

            MioElemento mioElemento = array.get(position);
            ((ImageView)convertView.findViewById(R.id.image)).setImageDrawable(ContextCompat.getDrawable(parent.getContext(), mioElemento.imageId));
            ((TextView)convertView.findViewById(R.id.testo)).setText(mioElemento.text);
            return convertView;
        }

        public void add(MioElemento mioElemento){
            array.add(mioElemento);
        }
    }

    class MioElemento{
        int imageId;
        String text;
    }

}
