package com.example.csebook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FirstActivity extends BaseActivity {

    private Toolbar toolbar;
    ListView listView1;
    String mTitle[];
    String mDescription[];
    int image[] = {R.drawable.first,R.drawable.first,R.drawable.first,R.drawable.first,R.drawable.first,R.drawable.first};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        listView1 = findViewById(R.id.listView1);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTitle = getResources().getStringArray(R.array.firstList);
        mDescription = getResources().getStringArray(R.array.firstSubList);

        MyAdapter adapter = new MyAdapter(this,mTitle,mDescription,image);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String str = listView1.getItemAtPosition(i).toString();
                Intent in = new Intent(FirstActivity.this,PdfViewActivity.class);
                //in.putExtra("item",adapterView.getItemAtPosition(i).toString());
                in.putExtra("item",str);
                startActivity(in);

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];
        MyAdapter(Context c,String title[],String description[],int image[]){
            super(c,R.layout.sample_view,R.id.textviewId1,title);
            this.context =c;
            this.rTitle=title;
            this.rDescription = description;
            this.rImage = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View simpleView = layoutInflater.inflate(R.layout.sample_view,parent,false);
            ImageView imageView = simpleView.findViewById(R.id.imageId);
            TextView myTitle = simpleView.findViewById(R.id.textviewId1);
            TextView myDescription = simpleView.findViewById(R.id.textviewId2);

            imageView.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);





            return simpleView;
        }
    }
}
