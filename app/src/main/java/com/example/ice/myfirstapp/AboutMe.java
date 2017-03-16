package com.example.ice.myfirstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {

    //Explicit
    MediaPlayer mediaPlayer;
    int soundID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        //toast onClick
        ImageView ClickImageView = (ImageView) findViewById(R.id.imvMypic);
        ClickImageView.setOnClickListener(new View.OnClickListener() { // ให้พิมพ์เเค่ new on
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello My name is Kiattisak Dulyakarn",Toast.LENGTH_SHORT).show();
                soundID = R.raw.sound1;
                playSound(soundID);

            }
        });

        //sound

        //Toast onLongClick
        ImageView longClickImageview = (ImageView) findViewById(R.id.imvMypic);
        longClickImageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "Thank your very much", Toast.LENGTH_SHORT).show();
                soundID = R.raw.sound1;
                playSound(soundID);

                return true;
            }
        });

        //phone onClick
        TextView phoneTextview =(TextView) findViewById(R.id.txtteL);
        phoneTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:0953650255"));
                startActivity(phoneIntent);
            }
        });




        }// Main Method

    private void playSound(int soundID) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(),soundID);
        mediaPlayer.start();
    }

    public void onClickAboutMe(View view) {
        finish();
    }

    public void onClickface(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/KiattisakDulyakarn"));
        startActivity(intent);
    }

    }//Main Class


