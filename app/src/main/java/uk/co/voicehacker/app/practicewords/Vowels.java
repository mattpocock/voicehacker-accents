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

    MediaPlayer allsounds;

    boolean navBarOn = false;

    // Create Button Method

    public void createButton(Button btn, final sound s) {
        btn = (Button) getView().findViewById(s.buttonid);
        btn.setText(s.symbol);
        btn.setSoundEffectsEnabled(false);
        // mp = MediaPlayer.create(this, s.soundfile);

        final int sf = s.soundfile;

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (allsounds != null) {
                    allsounds.release();
                }

                allsounds = MediaPlayer.create(getActivity(), sf);
                allsounds.start();

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



                insertedBtn.setText("/" + s.symbol + "/ - PRACTICE");
                insertedBtn.setAllCaps(false);
                insertedBtn.setTextSize(20);
                insertedBtn.setSoundEffectsEnabled(false);
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
                        i.putExtra("sentFrom", 1);
                        i.putExtra("moreInfoSections", s.moreinfosections);
                        if (allsounds != null) {
                            allsounds.release();
                        }
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

        sound shortAhsound = new sound(R.id.button1,"æ",R.raw.ah,"The /æ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_openjaw, R.string.desc_spreadlips, R.string.desc_placementfront}, 1,1,1, new String[]{"attack","cat","stand","cancel","back","add","fashion","lamp","bag","had"});
        sound ehSound = new sound(R.id.button2,"e",R.raw.eh,"The /e/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_spreadlips, R.string.desc_placementfront}, 2,1,1, new String[]{"guest","bet","get","friend","lend","mend","pet","many","expensive","very"});
        sound ihSound = new sound(R.id.button3,"ɪ",R.raw.ih,"The /ɪ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_closedjaw, R.string.desc_neutrallips, R.string.desc_placementfront}, 1,2,1, new String[]{"think","bit","fill","still","hill","city","biscuit","ring","music","kitchen"});
        sound shortOohSound = new sound(R.id.button4,"ʊ",R.raw.ouh,"The /ʊ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementback}, 1,2,1, new String[]{"book","could","couldn't","foot","full","good","look","pull","put","shook"});
        sound ohSound = new sound(R.id.button5,"ɒ",R.raw.oh,"The /ɒ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_openjaw, R.string.desc_roundedlips, R.string.desc_placementback}, 2,2,1, new String[]{"won","off","not","cost","hot","dog","sock","sausage","pot","chocolate"});
        sound uhSound = new sound(R.id.button6,"ʌ",R.raw.uh,"The /ʌ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementcentral}, 1,3,1, new String[]{"button","just","hut","other","mother","government","blood","bus","chuckle","enough"});
        sound schwaSound = new sound(R.id.button7,"ə",R.raw.schwa,"The Schwa", new int[]{R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementcentral}, 2,3,1, new String[]{"comma","better","complete","station","england","doctor","delicate","allow","forgot","local"});

        createButton(button1, shortAhsound);
        createButton(button2, ehSound);
        createButton(button3, ihSound);
        createButton(button4, shortOohSound);
        createButton(button5, ohSound);
        createButton(button6, uhSound);
        createButton(button7, schwaSound);

        // Long Vowels

        sound eeSound = new sound(R.id.button8,"iː",R.raw.ee,"The /iː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_closedjaw, R.string.desc_spreadlips, R.string.desc_placementfront}, 1,4,2, new String[]{"free","keep","mean","clean","speech","need","feed","seen","believe","thirteen"});
        sound ooSound = new sound(R.id.button9,"uː",R.raw.oo,"The /uː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_closedjaw, R.string.desc_roundedlips, R.string.desc_placementback}, 2,4,2, new String[]{"blue","food","new","who","queue","few","group","do","movie","shoe"});
        sound urSound = new sound(R.id.button10,"ɜː",R.raw.ur,"The /ɜː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementcentral}, 3,4,2, new String[]{"hurt","shirt","first","thirteen","work","worse","were","urgent","word","earth"});
        sound orSound = new sound(R.id.button11,"ɔː",R.raw.or,"The /ɔː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_midjaw, R.string.desc_roundedlips, R.string.desc_placementback}, 1,5,2, new String[]{"tall","more","thought","caution","order","also","short","taught","north","august"});
        sound arSound = new sound(R.id.button12,"ɑː",R.raw.longah,"The /ɑː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_openjaw, R.string.desc_neutrallips, R.string.desc_placementback}, 2,5,2, new String[]{"fast","car","staff","photograph","past","calm","bath","after","heart","party"});

        createButton(button8, eeSound);
        createButton(button9, ooSound);
        createButton(button10, urSound);
        createButton(button11, orSound);
        createButton(button12, arSound);

        // Diphthongs

        sound ay = new sound(R.id.button13,"eɪ",R.raw.ay,"The /eɪ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 1,6,3, new String[]{"same","fame","rain","hey","game","brain","amaze","hate","case","aim"});
        sound igh = new sound(R.id.button14,"aɪ",R.raw.igh,"The /aɪ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 2,6,3, new String[]{"fine","line","time","mine","kind","find","sign","die","hi","my"});
        sound ow = new sound(R.id.button15,"aʊ",R.raw.ow,"The /aʊ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 3,6,3, new String[]{"out","about","now","how","shower","power","found","loud","proud","without"});
        sound oh = new sound(R.id.button16,"əʊ",R.raw.o,"The /əʊ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 1,7,3, new String[]{"home","know","grow","show","flow","OK","open","location","load","cold"});
        sound ear = new sound(R.id.button17,"ɪə",R.raw.ear,"The /ɪə/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 2,7,3, new String[]{"ear","real","area","beer","dear","hear","nearly","year","weird","really"});
        sound ehuh = new sound(R.id.button18,"eə",R.raw.air,"The /eə/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 3,7,3, new String[]{"chair","air","care","area","there","mary","dare","nightmare","rare","share"});
        sound oy = new sound(R.id.button19,"ɔɪ",R.raw.oy,"The /ɔɪ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 1,8,3, new String[]{"boy","coin","foil","noise","toy","choice","avoid","join","point","voice"});
        sound ure = new sound(R.id.button20,"ʊə",R.raw.ure,"The /ʊə/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_morecoming}, 2,8,3, new String[]{"pure","cure","endure","jewel","usual","fury","mature","during","secure","curious"});

        createButton(button13, ay);
        createButton(button14, igh);
        createButton(button15, ow);
        createButton(button16, oh);
        createButton(button17, ear);
        createButton(button18, ehuh);
        createButton(button19, oy);
        createButton(button20, ure);



    }

}