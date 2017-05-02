package uk.co.voicehacker.app.practicewords;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Matt on 01-May-17.
 */

public class Consonants extends Fragment {

    // Declares Buttons & Sounds

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25;
    MediaPlayer sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9, sound10, sound11, sound12, sound13, sound14, sound15, sound16, sound17, sound18, sound19, sound20, sound21, sound22, sound23, sound24, sound25;


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
    public static Consonants newInstance(int page, String title) {
        Consonants consonants = new Consonants();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        consonants.setArguments(args);
        return consonants;
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
        View view = inflater.inflate(R.layout.consonants, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Creates Buttons

        sound unvoicedTHsound = new sound(R.id.button1,"θ",R.raw.unvoicedth,"The Unvoiced TH", 1,1,1, new String[]{"think","thumb","thistle"});
        sound voicedTHsound = new sound(R.id.button2,"ð",R.raw.voicedth,"The Voiced TH", 2,1,1, new String[]{"although","this","them"});
        sound sSound = new sound(R.id.button3,"s",R.raw.ssound,"The S Sound", 3,1,1, new String[]{"simple"});
        sound zSound = new sound(R.id.button4,"z",R.raw.zsound,"The Z Sound", 1,2,1, new String[]{"these"});
        sound fSound = new sound(R.id.button5,"f",R.raw.fsound,"The F Sound", 2,2,1, new String[]{"find"});
        sound vSound = new sound(R.id.button6,"v",R.raw.vsound,"The V Sound", 3,2,1, new String[]{"vindicate"});
        sound hSound = new sound(R.id.button7,"h",R.raw.hsound,"The H Sound", 1,3,1, new String[]{"hello", "hall", "high"});
        sound shSound = new sound(R.id.button8,"ʃ",R.raw.shsound,"The SH Sound", 2,3,1, new String[]{"shush", "relationship"});
        sound zhSound = new sound(R.id.button9,"ʒ",R.raw.zhsound,"The /ʒ/ Sound", 3,3,1, new String[]{"measure", "treasure"});

        createButton(button1, unvoicedTHsound, sound1);
        createButton(button2, voicedTHsound, sound2);
        createButton(button3, sSound, sound3);
        createButton(button4, zSound, sound4);
        createButton(button5, fSound, sound5);
        createButton(button6, vSound, sound6);
        createButton(button7, hSound, sound7);
        createButton(button8, shSound, sound8);
        createButton(button9, zhSound, sound9);

        // Plosives

        sound pSound = new sound(R.id.button10,"p",R.raw.psound,"The P Sound", 1,1,2, new String[]{"person, people"});
        sound bSound = new sound(R.id.button11,"b",R.raw.bsound,"The B Sound", 2,1,2, new String[]{"bowl", "bible"});
        sound tSound = new sound(R.id.button12,"t",R.raw.tsound,"The T Sound", 3,1,2, new String[]{"teen", "time"});
        sound dSound = new sound(R.id.button13,"d",R.raw.dsound,"The D Sound", 1,2,2, new String[]{"dead", "header"});
        sound kSound = new sound(R.id.button14,"k",R.raw.ksound,"The K Sound", 2,2,2, new String[]{"queue", "quite"});
        sound gSound = new sound(R.id.button15,"g",R.raw.gsound,"The G Sound", 3,2,2, new String[]{"great", "green"});

        createButton(button10, pSound, sound10);
        createButton(button11, bSound, sound11);
        createButton(button12, tSound, sound12);
        createButton(button13, dSound, sound13);
        createButton(button14, kSound, sound14);
        createButton(button15, gSound, sound15);

        // Affricates

        sound chSound = new sound(R.id.button16,"tʃ",R.raw.chsound,"The CH Sound", 1,1,3, new String[]{"chime", "chew"});
        sound jSound = new sound(R.id.button17,"dʒ",R.raw.jsound,"The J Sound", 2,1,3, new String[]{"project", "manager"});
        createButton(button16, chSound, sound16);
        createButton(button17, jSound, sound17);

        // Nasals

        sound mSound = new sound(R.id.button18,"m",R.raw.msound,"The M Sound", 1,1,4, new String[]{"chime", "mother"});
        sound nSound = new sound(R.id.button19,"n",R.raw.nsound,"The N Sound", 2,1,4, new String[]{"none", "crown"});
        sound ngSound = new sound(R.id.button20,"ŋ",R.raw.ngsound,"The NG Sound", 3,1,4, new String[]{"sing", "finger"});
        createButton(button18, mSound, sound18);
        createButton(button19, nSound, sound19);
        createButton(button20, ngSound, sound20);

        // Approximants

        sound lightLSound = new sound(R.id.button21,"l",R.raw.lightl,"The Light L", 1,1,5, new String[]{"light", "really"});
        sound darkLSound = new sound(R.id.button22,"ɫ",R.raw.darkl,"The Dark L", 2,1,5, new String[]{"real", "milk"});
        sound rSound = new sound(R.id.button23,"r",R.raw.rsound,"The R Sound", 3,1,5, new String[]{"project", "round"});
        sound ySound = new sound(R.id.button24,"j",R.raw.ysound,"The Yod", 1,2,5, new String[]{"you", "beautiful"});
        sound wSound = new sound(R.id.button25,"w",R.raw.wsound,"The W Sound", 1,2,5, new String[]{"when", "why"});
        createButton(button21, lightLSound, sound21);
        createButton(button22, darkLSound, sound22);
        createButton(button23, rSound, sound23);
        createButton(button24, ySound, sound24);
        createButton(button25, wSound, sound25);


    }

}