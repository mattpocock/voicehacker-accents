package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Matt on 01-May-17.
 */

public class Vowels extends Fragment {

    // Declares Buttons & Sounds

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20;

    MediaPlayer allsounds;

    SharedPreferences sharedPref;

    int[] vowelArr = new int[20];
    int vowelCounter = 0;

    boolean[] vowelStarred = new boolean[20];
    String importedVowelStarred;
    boolean firstStarPress = true;

    boolean navBarOn = false;

    // Convert Pixels to Dps

    public int pixelsToDps(int pix) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (pix * scale + 0.5f);
        return pixels;
    }

    // Convert Boolean Array to String

    public String booleanToString(boolean[] arr) {

        String result = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                result+= "1";
            } else {
                result+="0";
            }
        }

        return result;
    }

    // Create Button Method

    public void createButton(Button btn, final sound s) {

        final SharedPreferences sharedPref = getContext().getSharedPreferences(getString(R.string.preference_file_key), getContext().MODE_PRIVATE);

        final int thisvowel = vowelCounter;

        btn = (Button) getView().findViewById(s.buttonid);
        btn.setText(s.symbol);
        btn.setSoundEffectsEnabled(false);
        btn.setAlpha(0.0f);
        btn.animate().alpha(1.0f);

        if (!vowelStarred[thisvowel] && !firstStarPress) {
            btn.setBackgroundColor(getResources().getColor(R.color.darkGrey));
        }

        // Adds all Button Id's to btnArray

        vowelArr[vowelCounter] = s.buttonid;

        final int sf = s.soundfile;

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {

                if (allsounds != null) {
                    allsounds.release();
                }

                // Handles Sound Playing

                allsounds = MediaPlayer.create(getActivity(), sf);
                allsounds.start();

                // Handles nav bar creation

                LinearLayout newll = new LinearLayout(getContext());
                newll.setId(R.id.navbarll);

                Button navbtn = new Button(getContext());
                navbtn.setId(R.id.navbarbtn);

                ImageButton starbtn = new ImageButton(getContext());
                starbtn.setId(R.id.starbtn);



                LinearLayout oldll = (LinearLayout) getView().findViewById(R.id.vowelsll); // Used in both statements

                // Takes Out NavBtn

                if (navBarOn) {
                    Button insertedBtn = (Button) getView().findViewById(R.id.navbarbtn);
                    LinearLayout newllid = (LinearLayout) getView().findViewById(R.id.navbarll);
                    ImageButton insertedstar = (ImageButton) getView().findViewById(R.id.starbtn);
                    newllid.removeView(insertedBtn);
                    newllid.removeView(insertedstar);
                    oldll.removeView(newllid);
                    navBarOn = false;
                }

                // Puts in Button

                int insertId = s.row + (s.section + 1);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, pixelsToDps(50));
                params.setMargins(pixelsToDps(8),pixelsToDps(0),pixelsToDps(8),pixelsToDps(8));
                params.gravity = Gravity.CENTER_HORIZONTAL;

                oldll.addView(newll, insertId, params);

                LinearLayout.LayoutParams pracparams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 6);
                LinearLayout.LayoutParams starparams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2);
                LinearLayout newllid = (LinearLayout) getView().findViewById(R.id.navbarll);



                newllid.addView(navbtn, 0, pracparams);
                newllid.addView(starbtn, 1, starparams);

                navBarOn = true;

                // Star Button

                final ImageButton insertedStar = (ImageButton) getView().findViewById(R.id.starbtn);
                insertedStar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                // Checks if the star should be pre-pressed or not

                if (!vowelStarred[thisvowel]) {

                    insertedStar.setImageResource(R.drawable.star_btn1);

                } else {
                    insertedStar.setImageResource(R.drawable.star_btn2);
                }

                insertedStar.setScaleType(ImageView.ScaleType.FIT_CENTER);
                insertedStar.setAlpha(0.0f);
                insertedStar.animate().alpha(1.0f);



                insertedStar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        if (firstStarPress) {

                            for (int i = 0; i < vowelArr.length; i++) {
                                Button toChange = (Button) getView().findViewById(vowelArr[i]);
                                toChange.setBackgroundColor(getResources().getColor(R.color.darkGrey));
                                toChange.setAlpha(0.0f);
                                toChange.animate().alpha(1.0f);
                                vowelStarred[i] = false;
                            }

                            firstStarPress = false;

                        }

                        if (vowelStarred[thisvowel]) {

                            Button toChange = (Button) getView().findViewById(vowelArr[thisvowel]);
                            toChange.setBackgroundColor(getResources().getColor(R.color.darkGrey));
                            toChange.setAlpha(0.0f);
                            toChange.animate().alpha(1.0f);
                            vowelStarred[thisvowel] = false;
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(getString(R.string.importedvowelsstarred), booleanToString(vowelStarred));
                            editor.commit();
                            insertedStar.setImageResource(R.drawable.star_btn);

                        } else {

                            Button toChange = (Button) getView().findViewById(s.buttonid);
                            toChange.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            toChange.setAlpha(0.0f);
                            toChange.animate().alpha(1.0f);
                            vowelStarred[thisvowel] = true;
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(getString(R.string.importedvowelsstarred), booleanToString(vowelStarred));
                            editor.commit();
                            insertedStar.setImageResource(R.drawable.star_btn2);
                        }

                        // Turns all blue again if all off

                        boolean alloff = true;

                        for (int i = 0; i < vowelStarred.length; i++) {
                            if (vowelStarred[i]) {alloff = false;}
                        }

                        if (alloff) {
                            for (int i = 0; i < vowelArr.length; i++) {
                                Button toChange = (Button) getView().findViewById(vowelArr[i]);
                                toChange.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                                toChange.setAlpha(0.0f);
                                toChange.animate().alpha(1.0f);
                            }
                            firstStarPress = true;
                        }

                    }

                });

                // Main Nav Button
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
                insertedBtn.animate().alpha(1.0f);

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

        vowelCounter++; // This has to go here to keep vowelCounter as this button's id.

    }

    // newInstance constructor for creating fragment with arguments
    public static Vowels newInstance() {
        Vowels vowels = new Vowels();
        return vowels;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vowels, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPref = getContext().getSharedPreferences(getString(R.string.preference_file_key), getContext().MODE_PRIVATE);
        importedVowelStarred = sharedPref.getString(getString(R.string.importedvowelsstarred), "00000000000000000000");

        vowelArr = new int[20];
        vowelCounter = 0;

        vowelStarred = new boolean[25];
        firstStarPress = true;

        navBarOn = false;

        for (int i = 0; i < importedVowelStarred.length(); i++) {
            String sub = importedVowelStarred.substring(i,(i+1));
            if (Integer.parseInt(sub) == 0) {
                vowelStarred[i] = false;
            } else {
                vowelStarred[i] = true;
                firstStarPress = false;
            }
        }

        // Short Vowels

        sound shortAhsound = new sound(R.id.vbutton1,"æ",R.raw.ah,"The /æ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_openjaw, R.string.desc_spreadlips, R.string.desc_placementfront}, 1,1,1, new String[]{"attack","cat","stand","cancel","back","add","fashion","lamp","bag","had","matter","bat","balance","national","actual"});
        sound ehSound = new sound(R.id.vbutton2,"e",R.raw.eh,"The /e/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_spreadlips, R.string.desc_placementfront}, 2,1,1, new String[]{"guest","bet","get","friend","lend","mend","pet","many","expensive","very","best","mention","head","bell","extra"});
        sound ihSound = new sound(R.id.vbutton3,"ɪ",R.raw.ih,"The /ɪ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_closedjaw, R.string.desc_neutrallips, R.string.desc_placementfront}, 1,2,1, new String[]{"think","bit","fill","still","hill","city","biscuit","ring","music","kitchen","mist","building","different","simple","listen"});
        sound shortOohSound = new sound(R.id.vbutton4,"ʊ",R.raw.ouh,"The /ʊ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementback}, 1,2,1, new String[]{"book","could","couldn't","foot","full","good","look","pull","put","shook","soot","cook","stood","would","hood"});
        sound ohSound = new sound(R.id.vbutton5,"ɒ",R.raw.oh,"The /ɒ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_openjaw, R.string.desc_roundedlips, R.string.desc_placementback}, 2,2,1, new String[]{"won","off","not","cost","hot","dog","sock","sausage","pot","chocolate","stop","cotton","lost","posh","dock"});
        sound uhSound = new sound(R.id.vbutton6,"ʌ",R.raw.uh,"The /ʌ/ Sound", new int[]{R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementcentral}, 1,3,1, new String[]{"button","just","hut","other","mother","government","blood","bus","chuckle","enough","much","such","rust","brother","rough"});
        sound schwaSound = new sound(R.id.vbutton7,"ə",R.raw.schwa,"The Schwa - /ə/", new int[]{R.string.desc_schwa, R.string.desc_shortvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementcentral}, 2,3,1, new String[]{"comma","better","complete","station","england","doctor","delicate","allow","forgot","local","attack","amount","information","pleasure","open"});

        createButton(button1, shortAhsound);
        createButton(button2, ehSound);
        createButton(button3, ihSound);
        createButton(button4, shortOohSound);
        createButton(button5, ohSound);
        createButton(button6, uhSound);
        createButton(button7, schwaSound);

        // Long Vowels

        sound eeSound = new sound(R.id.vbutton8,"iː",R.raw.ee,"The /iː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_closedjaw, R.string.desc_spreadlips, R.string.desc_placementfront}, 1,4,2, new String[]{"free","keep","mean","clean","speech","need","feed","seen","believe","thirteen","peace","easy","green","please","police"});
        sound ooSound = new sound(R.id.vbutton9,"uː",R.raw.oo,"The /uː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_closedjaw, R.string.desc_roundedlips, R.string.desc_placementback}, 2,4,2, new String[]{"blue","food","new","who","queue","few","group","do","movie","shoe","mood","clue","renew","balloon","due"});
        sound urSound = new sound(R.id.vbutton10,"ɜː",R.raw.ur,"The /ɜː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementcentral}, 3,4,2, new String[]{"hurt","shirt","first","thirteen","work","worse","were","urgent","word","earth","service","third","murder","birth","earn"});
        sound orSound = new sound(R.id.vbutton11,"ɔː",R.raw.or,"The /ɔː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_midjaw, R.string.desc_roundedlips, R.string.desc_placementback}, 1,5,2, new String[]{"tall","more","thought","caution","order","also","short","taught","north","august","awful","alright","dawn","born","torn"});
        sound arSound = new sound(R.id.vbutton12,"ɑː",R.raw.longah,"The /ɑː/ Sound", new int[]{R.string.desc_longvowels, R.string.desc_openjaw, R.string.desc_neutrallips, R.string.desc_placementback}, 2,5,2, new String[]{"fast","car","staff","photograph","past","calm","bath","after","heart","party","sharp","master","graph","chart","nasty"});

        createButton(button8, eeSound);
        createButton(button9, ooSound);
        createButton(button10, urSound);
        createButton(button11, orSound);
        createButton(button12, arSound);

        // Diphthongs

        sound ay = new sound(R.id.vbutton13,"eɪ",R.raw.ay,"The /eɪ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_midjaw, R.string.desc_aylips, R.string.desc_placementfront}, 1,6,3, new String[]{"same","fame","rain","hey","game","brain","amaze","hate","case","aim","plain","pace","daily","maybe","OK"});
        sound igh = new sound(R.id.vbutton14,"aɪ",R.raw.igh,"The /aɪ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_ighjaw, R.string.desc_ighlips, R.string.desc_placementfront}, 2,6,3, new String[]{"fine","line","time","mine","kind","find","sign","die","hi","my","might","arrive","timer","eye","sight"});
        sound ow = new sound(R.id.vbutton15,"aʊ",R.raw.ow,"The /aʊ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_owjaw, R.string.desc_owlips, R.string.desc_owplace}, 3,6,3, new String[]{"out","about","now","how","shower","power","found","loud","proud","without","however","voucher","cloud","towel","sound"});
        sound oh = new sound(R.id.vbutton16,"əʊ",R.raw.o,"The /əʊ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_midjaw, R.string.desc_olips, R.string.desc_oplace}, 1,7,3, new String[]{"home","know","grow","show","flow","OK","open","location","load","cold","boat","although","remote","over","oak"});
        sound ear = new sound(R.id.vbutton17,"ɪə",R.raw.ear,"The /ɪə/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_earplace}, 2,7,3, new String[]{"ear","real","area","beer","dear","hear","nearly","year","weird","really","severe","clear","fear","appear","rear"});
        sound ehuh = new sound(R.id.vbutton18,"eə",R.raw.air,"The /eə/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_midjaw, R.string.desc_airlips, R.string.desc_airplace}, 3,7,3, new String[]{"chair","air","care","area","there","mary","dare","nightmare","rare","share","staircase","fair","bear","aware","pair"});
        sound oy = new sound(R.id.vbutton19,"ɔɪ",R.raw.oy,"The /ɔɪ/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_midjaw, R.string.desc_oylips, R.string.desc_oyplace}, 1,8,3, new String[]{"boy","coin","foil","noise","toy","choice","avoid","join","point","voice","joy","annoyed","coil","appoint","soya"});
        sound ure = new sound(R.id.vbutton20,"ʊə",R.raw.ure,"The /ʊə/ Sound", new int[]{R.string.desc_diphthongs, R.string.desc_midjaw, R.string.desc_neutrallips, R.string.desc_placementcentral}, 2,8,3, new String[]{"pure","cure","endure","jewel","usual","fury","mature","during","secure","curious","furious","alluring","tour","sure","insurance"});

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