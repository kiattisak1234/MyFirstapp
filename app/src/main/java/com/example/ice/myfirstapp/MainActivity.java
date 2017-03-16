package com.example.ice.myfirstapp;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
//Explicit
    ListView listView;
    private  int [] ints = new int[] {R.drawable.traffic_01,R.drawable.traffic_02,R.drawable.traffic_03,R.drawable.traffic_04,
                                        R.drawable.traffic_05,R.drawable.traffic_06,R.drawable.traffic_07,R.drawable.traffic_08,
                                        R.drawable.traffic_09,R.drawable.traffic_10,R.drawable.traffic_11,R.drawable.traffic_12,
                                        R.drawable.traffic_13,R.drawable.traffic_14,R.drawable.traffic_15,R.drawable.traffic_16,
                                        R.drawable.traffic_17,R.drawable.traffic_18,R.drawable.traffic_19,R.drawable.traffic_20,};

    private String[]titlesStrings,detailString,shorStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inital view
        listView = (ListView) findViewById(R.id.livTroffic);
        //Get volue
        titlesStrings = getResources().getStringArray(R.array.title);
        detailString = getResources().getStringArray(R.array.detail);
        //SubString detailString ตัดข้อความให้สั้นตามที่ต้องการ
        shorStrings = new String[detailString.length]; //จำลองพื้นที่
        for (int i = 0; i < detailString.length;i++){
        shorStrings[i] = detailString [i] .substring(0,25)+"...";

        }// end for
        //create ListView
        Myadpter myadpter = new Myadpter(MainActivity.this,ints,titlesStrings,shorStrings);
        listView.setAdapter(myadpter);

        //active when click live View ลิงค์ไปข้างหน้า detail เมื่อเลือก item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
                    public  void onItemClick(AdapterView<?> parent,View view, int positon, long id) {
                    Intent intent = new Intent(MainActivity.this,Detail.class);
                intent.putExtra("Titel",titlesStrings[positon]);
                intent.putExtra("Detail",detailString[positon]);
                intent.putExtra("Image",ints[positon]);
                startActivity(intent);
            }

        });

    }//main Method onCreate
    public void onCickMoreInfo(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/"));
        startActivity(intent);

    }
    public void btnAboutMe (View view){
        Intent intent = new Intent(MainActivity.this,AboutMe.class);
        startActivity(intent);
    }
} //main class
