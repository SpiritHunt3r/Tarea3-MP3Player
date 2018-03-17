package com.example.juan.mp3player;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private final String[] lyricsSongs = {"Una mattina mi son svegliato\n" +
            "O bella, ciao! bella, ciao! bella, ciao, ciao, ciao!\n" +
            "Una mattina mi son svegliato\n" +
            "E ho trovato l'invasor\n" +
            "\n" +
            "O partigiano, portami via\n" +
            "O bella, ciao! bella, ciao! bella, ciao, ciao, ciao!\n" +
            "O partigiano, portami via\n" +
            "Ché mi sento di morir\n" +
            "\n" +
            "E se io muoio da partigiano\n" +
            "(E se io muoio sulla montagna)\n" +
            "O bella, ciao! bella, ciao! bella, ciao, ciao, ciao!\n" +
            "E se io muoio da partigiano\n" +
            "(E se io muoio sulla montagna)\n" +
            "Tu mi devi seppellir\n" +
            "\n" +
            "E seppellire lassù in montagna\n" +
            "(E tu mi devi seppellire)\n" +
            "O bella, ciao! bella, ciao! bella, ciao, ciao, ciao!\n" +
            "E seppellire lassù in montagna\n" +
            "(E tu mi devi seppellire)\n" +
            "Sotto l'ombra di un bel fior\n" +
            "\n" +
            "Tutte le genti che passeranno\n" +
            "(E tutti quelli che passeranno)\n" +
            "O bella, ciao! bella, ciao! bella, ciao, ciao, ciao!\n" +
            "Tutte le genti che passeranno\n" +
            "(E tutti quelli che passeranno)\n" +
            "Mi diranno «Che bel fior!»\n" +
            "(E poi diranno «Che bel fior!»)\n" +
            "\n" +
            "«È questo il fiore del partigiano»\n" +
            "\n" +
            "(E questo è il fiore del partigiano)\n" +
            "O bella, ciao! bella, ciao! bella, ciao, ciao, ciao!\n" +
            "«È questo il fiore del partigiano\n" +
            "\n" +
            "(E questo è il fiore del partigiano)\n" +
            "Morto per la libertà!»","[Verse 1: Mike Shinoda]\n" +
            "Yeah, here we go for the hundredth time\n" +
            "Hand grenade pins in every line\n" +
            "Throw 'em up and let something shine\n" +
            "Going out of my fucking mind\n" +
            "Filthy mouth, no excuse\n" +
            "Find a new place to hang this noose\n" +
            "String me up from atop these roofs\n" +
            "Knot it tight so I won't get loose\n" +
            "Truth is, you can stop and stare\n" +
            "Run myself out and no one cares\n" +
            "Dug the trench out, laid down there\n" +
            "With a shovel up out of reach, somewhere\n" +
            "Yeah, someone pour it in\n" +
            "Make it a dirt dance floor, again\n" +
            "Say your prayers and stomp it out\n" +
            "When they bring that chorus in\n" +
            "\n" +
            "[Chorus: Chester Bennington]\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "Just to throw it away, just to throw it away\n" +
            "I bleed it out\n" +
            "\n" +
            "[Verse 2: Mike]\n" +
            "I bleed it out, go, stop the show\n" +
            "Choppy words and a sloppy flow\n" +
            "Shotgun opera, lock and load\n" +
            "Cock it back and then watch it go\n" +
            "Mama, help me, I've been cursed\n" +
            "Death is rolling in every verse\n" +
            "Candy paint on his brand new hearse\n" +
            "Can't contain him, he knows he works\n" +
            "Fuck, this hurts, I won't lie\n" +
            "Doesn't matter how hard I try\n" +
            "Half the words don't mean a thing\n" +
            "And I know that I won't be satisfied\n" +
            "So, I try ignoring him\n" +
            "Make it a dirt dance floor, again\n" +
            "Say your prayers and stomp it out\n" +
            "When they bring that chorus in\n" +
            "\n" +
            "[Chorus: Chester]\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "Just to throw it away, just to throw it away\n" +
            "I bleed it out\n" +
            "\n" +
            "[Bridge: Chester]\n" +
            "I've opened up these scars\n" +
            "I'll make you face this\n" +
            "I've pulled myself so far\n" +
            "I'll make you face this, now\n" +
            "\n" +
            "[Chorus: Chester]\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "Just to throw it away, just to throw it away\n" +
            "\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "I bleed it out, digging deeper just to throw it away\n" +
            "Just to throw it away, just to throw it away\n" +
            "\n" +
            "[Outro: Chester]\n" +
            "I bleed it out\n" +
            "I bleed it out\n" +
            "I bleed it out","[Instrumental]","[Verse 1]\n" +
            "Tell me what I've gotta do\n" +
            "There's no getting through to you\n" +
            "The lights are on but nobody's home (nobody's home)\n" +
            "You say I can't understand\n" +
            "But you're not giving me a chance\n" +
            "When you leave me, where do you go? (Where do you go?)\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "All the walls that you keep building\n" +
            "All this time that I spent chasing\n" +
            "All the ways that I keep losing you\n" +
            "\n" +
            "[Chorus]\n" +
            "The truth is, you turn into someone else\n" +
            "You keep running like the sky is falling\n" +
            "I can whisper, I can yell\n" +
            "But I know, yeah I know, yeah I know\n" +
            "I'm just talking to myself\n" +
            "Talking to myself\n" +
            "Talking to myself\n" +
            "But I know, yeah I know, yeah I know\n" +
            "I'm just talking to myself\n" +
            "\n" +
            "[Verse 2]\n" +
            "I admit I made mistakes\n" +
            "But yours might cost you everything\n" +
            "Can't you hear me calling you home?\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "Oh, all the walls that you keep building\n" +
            "All this time that I spent chasing\n" +
            "All the ways that I keep losing you\n" +
            "\n" +
            "[Chorus]\n" +
            "The truth is, you turned into someone else\n" +
            "You keep running like the sky is falling\n" +
            "I can whisper, I can yell\n" +
            "But I know, yeah I know, yeah I know\n" +
            "I'm just talking to myself\n" +
            "Talking to myself\n" +
            "Talking to myself\n" +
            "Yeah I know, yeah I know, yeah I know\n" +
            "I'm just talking to myself\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "All the walls that you keep building\n" +
            "All this time that I spent chasing\n" +
            "All the ways that I keep losing you\n" +
            "\n" +
            "[Chorus/Outro]\n" +
            "The truth is, you turned into someone else\n" +
            "You keep running like the sky is falling\n" +
            "I can whisper, I can yell\n" +
            "But I know, yeah I know, yeah I know\n" +
            "I'm just talking to myself\n" +
            "Talking to myself\n" +
            "Talking to myself\n" +
            "Yeah I know, yeah I know, yeah I know\n" +
            "Talking to myself","[Verse 1]\n" +
            "As a child, you would wait and watch from far away\n" +
            "But you always knew that you'd be the one\n" +
            "To work while they all play\n" +
            "In youth, you'd lay awake at night and scheme\n" +
            "Of all the things that you would change\n" +
            "But it was just a dream\n" +
            "\n" +
            "[Chorus]\n" +
            "Here we are, don't turn away now\n" +
            "We are the warriors that built this town\n" +
            "Here we are, don't turn away now\n" +
            "We are the warriors that built this town\n" +
            "From dust\n" +
            "\n" +
            "[Verse 2]\n" +
            "The time will come, when you will have to rise\n" +
            "Above the best, and prove yourself\n" +
            "Your spirit never dies\n" +
            "Farewell, I've gone, to take my throne above\n" +
            "But don't weep for me, 'cause this will be\n" +
            "The labor of my love\n" +
            "\n" +
            "[Chorus]\n" +
            "Here we are, don't turn away now\n" +
            "We are the warriors that built this town\n" +
            "Here we are, don't turn away now\n" +
            "We are the warriors that built this town\n" +
            "From dust\n" +
            "Here we are, don't turn away now\n" +
            "We are the warriors that built this town\n" +
            "Here we are, don't turn away now\n" +
            "We are the warriors that built this town\n" +
            "From dust\n" +
            "\n" +
            "  "};
    private final int[] resID = {R.raw.bellaciao, R.raw.bleeditout, R.raw.jysuisjamaisalle, R.raw.talkingtomyself,
            R.raw.warriors};
    private final String[] listCont = {"Bella Ciao -Adolfo Celdran", "Bleed It Out - Linkin Park",
            "JY Suis Jamais Allé -Yann Tiersen", "Talking To Myself - Linkin Park", "Warriors - Image Dragons"};
    boolean clicked = true;
    private SeekBar songBar;
    public  TextView songTime,lyrics;
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
        lyrics.setText(lyricsSongs[songIndex]);
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
        lyrics = findViewById(R.id.lyrics);


        lyrics.setMovementMethod(new ScrollingMovementMethod());

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
                        newSong();
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
