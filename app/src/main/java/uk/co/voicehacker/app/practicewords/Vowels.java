package uk.co.voicehacker.app.practicewords;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Matt on 01-May-17.
 */

public class Vowels extends Fragment {

    // Declares Buttons & Sounds

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21;
    MediaPlayer sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9, sound10, sound11, sound12, sound13, sound14, sound15, sound16, sound17, sound18, sound19, sound20, sound21;


    // Create Button Method

    public void createButton(Button btn, final sound s, final MediaPlayer mp) {
        btn = (Button) getView().findViewById(s.buttonid);
        btn.setText(s.symbol);
        btn.setSoundEffectsEnabled(false);
        // mp = MediaPlayer.create(this, s.soundfile);

        final int sf = s.soundfile;

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                MediaPlayer media = mp;
                media = MediaPlayer.create(getActivity(), sf);

                media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
                media.start();



            }
        });

    }



    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static Vowels newInstance(int page, String title) {
        Vowels vowels = new Vowels();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        vowels.setArguments(args);
        return vowels;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vowels, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Short Vowels

        sound shortAhsound = new sound(R.id.button1,"æ",R.raw.ah,"The /æ/ Sound", 1,1,1, new String[]{"think","thumb","thistle"});
        sound ehSound = new sound(R.id.button2,"e",R.raw.eh,"The /e/ Sound", 2,1,1, new String[]{"although","this","them"});
        sound ihSound = new sound(R.id.button3,"ɪ",R.raw.ih,"The /ɪ/ Sound", 3,1,1, new String[]{"simple"});
        sound shortOohSound = new sound(R.id.button4,"ʊ",R.raw.ouh,"The /ʊ/ Sound", 1,2,1, new String[]{"these"});
        sound ohSound = new sound(R.id.button5,"ɒ",R.raw.oh,"The /ɒ/ Sound", 2,2,1, new String[]{"find"});
        sound uhSound = new sound(R.id.button6,"ʌ",R.raw.uh,"The /ʌ/ Sound", 3,2,1, new String[]{"vindicate"});
        sound schwaSound = new sound(R.id.button7,"ə",R.raw.schwa,"The Schwa", 1,3,1, new String[]{"hello", "hall", "high"});

        createButton(button1, shortAhsound, sound1);
        createButton(button2, ehSound, sound2);
        createButton(button3, ihSound, sound3);
        createButton(button4, shortOohSound, sound4);
        createButton(button5, ohSound, sound5);
        createButton(button6, uhSound, sound6);
        createButton(button7, schwaSound, sound7);

        // Long Vowels

        sound eeSound = new sound(R.id.button8,"iː",R.raw.ee,"The /iː/ Sound", 1,1,2, new String[]{"shush", "relationship"});
        sound ooSound = new sound(R.id.button9,"uː",R.raw.oo,"The /uː/ Sound", 2,1,2, new String[]{"measure", "treasure"});
        sound urSound = new sound(R.id.button10,"ɜː",R.raw.ur,"The /ɜː/ Sound", 3,1,2, new String[]{"person, people"});
        sound orSound = new sound(R.id.button11,"ɔː",R.raw.or,"The /ɔː/ Sound", 1,2,2, new String[]{"bowl", "bible"});
        sound arSound = new sound(R.id.button12,"ɑː",R.raw.longah,"The /ɑː/ Sound", 2,2,2, new String[]{"teen", "time"});

        createButton(button8, eeSound, sound8);
        createButton(button9, ooSound, sound9);
        createButton(button10, urSound, sound10);
        createButton(button11, orSound, sound11);
        createButton(button12, arSound, sound12);

        // Diphthongs

        sound ay = new sound(R.id.button13,"eɪ",R.raw.ay,"The /eɪ/ Sound", 1,1,3, new String[]{"dead", "header"});
        sound igh = new sound(R.id.button14,"aɪ",R.raw.igh,"The /aɪ/ Sound", 2,1,3, new String[]{"queue", "quite"});
        sound ow = new sound(R.id.button15,"aʊ",R.raw.ow,"The /aʊ/ Sound", 3,1,3, new String[]{"great", "green"});
        sound oh = new sound(R.id.button16,"əʊ",R.raw.o,"The /əʊ/ Sound", 1,2,3, new String[]{"chime", "chew"});
        sound ear = new sound(R.id.button17,"ɪə",R.raw.ear,"The /ɪə/ Sound", 2,2,3, new String[]{"project", "manager"});
        sound ehuh = new sound(R.id.button18,"eə",R.raw.air,"The /eə/ Sound", 3,2,3, new String[]{"chime", "mother"});
        sound oy = new sound(R.id.button19,"ɔɪ",R.raw.oy,"The /ɔɪ/ Sound", 1,3,3, new String[]{"none", "crown"});
        sound ure = new sound(R.id.button20,"ʊə",R.raw.ure,"The /ʊə/ Sound", 2,3,3, new String[]{"sing", "finger"});

        createButton(button13, ay, sound13);
        createButton(button14, igh, sound14);
        createButton(button15, ow, sound15);
        createButton(button16, oh, sound16);
        createButton(button17, ear, sound17);
        createButton(button18, ehuh, sound18);
        createButton(button19, oy, sound19);
        createButton(button20, ure, sound20);



    }

}