package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Matt on 01-May-17.
 */

public class Vowels extends Fragment {

    // Declares Buttons & Sounds

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21;
    MediaPlayer sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9, sound10, sound11, sound12, sound13, sound14, sound15, sound16, sound17, sound18, sound19, sound20, sound21;

    boolean navBarOn = false;

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

                // Handles nav bar creation

                LinearLayout newll = new LinearLayout(getContext());

                newll.setId(R.id.navbarll);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(16,12,16,0);
                params.gravity = Gravity.CENTER_HORIZONTAL;

                Button navbtn = new Button(getContext());
                navbtn.setId(R.id.navbarbtn);



                LinearLayout oldll = (LinearLayout) getView().findViewById(R.id.vowelsll); // Used in both statements

                // Takes Out NavBtn

                if (navBarOn) {
                    Button insertedBtn = (Button) getView().findViewById(R.id.navbarbtn);
                    LinearLayout newllid = (LinearLayout) getView().findViewById(R.id.navbarll);
                    newllid.removeView(insertedBtn);
                    oldll.removeView(newllid);
                    navBarOn = false;
                }

                // Puts in Button

                int insertId = s.row + (s.section + 1);

                oldll.addView(newll, insertId, params);

                LinearLayout newllid = (LinearLayout) getView().findViewById(R.id.navbarll);

                newllid.addView(navbtn, 0, params);

                navBarOn = true;
                Button insertedBtn = (Button) getView().findViewById(R.id.navbarbtn);



                insertedBtn.setText("/" + s.symbol + "/ PRACTICE WORDS");
                insertedBtn.setAllCaps(false);
                insertedBtn.setTextSize(20);
                insertedBtn.setTextColor(getResources().getColor(R.color.white));
                insertedBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                // Prepare the View for the animation
                insertedBtn.setAlpha(0.0f);
                // Start the animation
                insertedBtn.animate()
                        .alpha(1.0f);

                insertedBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(getContext(), ShowWordsPager.class);
                        i.putExtra("title", s.title);
                        i.putExtra("wordArr", s.words);
                        startActivity(i);
                    }
                });

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

        sound shortAhsound = new sound(R.id.button1,"æ",R.raw.ah,"The /æ/ Sound", 1,1,1, new String[]{"attack","attribute","actual"});
        sound ehSound = new sound(R.id.button2,"e",R.raw.eh,"The /e/ Sound", 2,1,1, new String[]{"ahead","already","bed","bedroom","bell","better","cell","check","dead","death","definitely","edge","else","fell","felt","forget","gently","get","head","heavy","held","hello","help","herself","himself","instead","led","left","leg","less","let","letter","meant","met","myself","pretend","red","said","self","set","settle","smell","tell","ten","well","yell","yet","yourself"});
        sound ihSound = new sound(R.id.button3,"ɪ",R.raw.ih,"The /ɪ/ Sound", 1,2,1, new String[]{"admit","anything","big","bit","blink","bring","build","business","city","did","different","dinner","disappear","drink","figure","fill","finger","finish","fit","fix","flip","giggle","give","grin","grip","him","his","hit","if","ignore","imagine","important","inside","instead","into","isn't","it","kick","kid","kill","kiss","kitchen","lip","listen","little","live","middle","minute","mirror","miss","morning","Mr.","Mrs.","music","nothing","notice","office","pick","picture","pink","possible","promise","quick","shift","shirt","sick","since","single","sister","sit","situation","six","skin","something","stick","still","stupid","thick","thing","think","this","trip","until","visit","which","whisper","will","wish","with","within","without"});
        sound shortOohSound = new sound(R.id.button4,"ʊ",R.raw.ouh,"The /ʊ/ Sound", 1,2,1, new String[]{"book","could","couldn't","foot","full","good","look","pull","put","shook","should","shouldn't","stood","took","wood","would","wouldn't"});
        sound ohSound = new sound(R.id.button5,"ɒ",R.raw.oh,"The /ɒ/ Sound", 2,2,1, new String[]{"cot","hot"});
        sound uhSound = new sound(R.id.button6,"ʌ",R.raw.uh,"The /ʌ/ Sound", 1,3,1, new String[]{"but","shut","fuss"});
        sound schwaSound = new sound(R.id.button7,"ə",R.raw.schwa,"The Schwa", 2,3,1, new String[]{"comma","better","compress"});

        createButton(button1, shortAhsound, sound1);
        createButton(button2, ehSound, sound2);
        createButton(button3, ihSound, sound3);
        createButton(button4, shortOohSound, sound4);
        createButton(button5, ohSound, sound5);
        createButton(button6, uhSound, sound6);
        createButton(button7, schwaSound, sound7);

        // Long Vowels

        sound eeSound = new sound(R.id.button8,"iː",R.raw.ee,"The /iː/ Sound", 1,4,2, new String[]{"mean", "seen"});
        sound ooSound = new sound(R.id.button9,"uː",R.raw.oo,"The /uː/ Sound", 2,4,2, new String[]{"soon", "bloom"});
        sound urSound = new sound(R.id.button10,"ɜː",R.raw.ur,"The /ɜː/ Sound", 3,4,2, new String[]{"hurt, search"});
        sound orSound = new sound(R.id.button11,"ɔː",R.raw.or,"The /ɔː/ Sound", 1,5,2, new String[]{"cause", "force"});
        sound arSound = new sound(R.id.button12,"ɑː",R.raw.longah,"The /ɑː/ Sound", 2,5,2, new String[]{"pass", "master"});

        createButton(button8, eeSound, sound8);
        createButton(button9, ooSound, sound9);
        createButton(button10, urSound, sound10);
        createButton(button11, orSound, sound11);
        createButton(button12, arSound, sound12);

        // Diphthongs

        sound ay = new sound(R.id.button13,"eɪ",R.raw.ay,"The /eɪ/ Sound", 1,6,3, new String[]{"day", "fade"});
        sound igh = new sound(R.id.button14,"aɪ",R.raw.igh,"The /aɪ/ Sound", 2,6,3, new String[]{"quite", "try"});
        sound ow = new sound(R.id.button15,"aʊ",R.raw.ow,"The /aʊ/ Sound", 3,6,3, new String[]{"mouth", "now"});
        sound oh = new sound(R.id.button16,"əʊ",R.raw.o,"The /əʊ/ Sound", 1,7,3, new String[]{"go", "open"});
        sound ear = new sound(R.id.button17,"ɪə",R.raw.ear,"The /ɪə/ Sound", 2,7,3, new String[]{"near", "fear"});
        sound ehuh = new sound(R.id.button18,"eə",R.raw.air,"The /eə/ Sound", 3,7,3, new String[]{"air", "care"});
        sound oy = new sound(R.id.button19,"ɔɪ",R.raw.oy,"The /ɔɪ/ Sound", 1,8,3, new String[]{"boy", "soil"});
        sound ure = new sound(R.id.button20,"ʊə",R.raw.ure,"The /ʊə/ Sound", 2,8,3, new String[]{"pure", "cure"});

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