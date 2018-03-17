package com.example.juan.mp3player;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private final int[] resID = {R.raw.bellaciao, R.raw.bleeditout, R.raw.jysuisjamaisalle, R.raw.talkingtomyself,
            R.raw.warriors};
    private final String[] listCont = {"Bella Ciao -Adolfo Celdran", "Bleed It Out - Linkin Park",
            "JY Suis Jamais Allé -Yann Tiersen", "Talking To Myself - Linkin Park", "Warriors - Image Dragons"};
    boolean clicked = true;
    private SeekBar songBar;
    public  TextView songTime;
    private ImageButton playpause, next, prev;
    int pos;
    Handler handler = new Handler();


    private Runnable moveSeekBarThread = new Runnable() {
        public void run() {
            if(mp.isPlaying()){

                int mediaPos_new = mp.getCurrentPosition();
                int mediaMax_new = mp.getDuration();
                int tiempo = mediaPos_new/1000;
                int tiempoT = mediaMax_new/1000;
                songBar.setMax(mediaMax_new);
                songBar.setProgress(mediaPos_new);
                if (mp.getCurrentPosition() >= mp.getDuration()-400){
                    if (pos == listCont.length - 1) {
                        playSong(0);
                    } else {
                        playSong(pos + 1);
                    }
                }
                int minutes = (tiempo % 3600) / 60;
                int seconds = tiempo % 60;
                int Fminutes = (tiempoT % 3600) / 60;
                int Fseconds = tiempoT% 60;
                songTime.setText(String.format("%02d:%02d / %02d:%02d", minutes, seconds, Fminutes, Fseconds));

                handler.postDelayed(this, 100);
            }

        }
    };

    private void newSong(){
        int mediaPos = mp.getCurrentPosition();
        int mediaMax = mp.getDuration();

        songBar.setMax(mediaMax);
        songBar.setProgress(mediaPos);

        handler.removeCallbacks(moveSeekBarThread);
        handler.postDelayed(moveSeekBarThread, 100);
    }





    public void playSong(int songIndex) {
        pos = songIndex;
        TextView actual = findViewById(R.id.songtxt);
        playpause.setImageDrawable(
                ContextCompat.getDrawable(getApplicationContext(), R.drawable.pause_ico));
        actual.setText(listCont[songIndex]);
        mp.reset();
        mp = MediaPlayer.create(getApplicationContext(), resID[songIndex]);
        mp.start();
        newSong();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = new MediaPlayer();
        ListView mainList = findViewById(R.id.songs);
        playpause = findViewById(R.id.playBTN);
        next = findViewById(R.id.nextBTN);
        prev = findViewById(R.id.prevBTN);
        songBar = findViewById(R.id.songBar);
        songTime = findViewById(R.id.songClock);


        songBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar songBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar songBar) {

            }

            @Override
            public void onProgressChanged(SeekBar songBar, int progress,
                                          boolean fromUser) {
                if(fromUser){
                    mp.seekTo(progress);
                    songBar.setProgress(progress);

                }

            }
        });




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listCont);
        mainList.setAdapter(adapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                playSong(position);
                clicked = false;

            }
        });


        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked) {
                    playSong(0);
                    clicked = false;
                    playpause.setImageDrawable(
                            ContextCompat.getDrawable(getApplicationContext(), R.drawable.pause_ico));
                } else {
                    if (mp.isPlaying()) {
                        mp.pause();
                        playpause.setImageDrawable(
                                ContextCompat.getDrawable(getApplicationContext(), R.drawable.play_ico));
                    } else {
                        mp.start();
                        playpause.setImageDrawable(
                                ContextCompat.getDrawable(getApplicationContext(), R.drawable.pause_ico));
                    }
                }
            }

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos == listCont.length - 1) {
                    playSong(0);
                } else {
                    playSong(pos + 1);
                }
            }

        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos == 0) {
                    playSong(resID.length - 1);
                } else {
                    playSong(pos - 1);
                }
            }

        });


    }





}
