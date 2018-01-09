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

public class Advanced extends Fragment {

    // Declares Buttons & Sounds

    Button button1, button2, button3, button4, button5, button6;

    MediaPlayer allsounds;

    SharedPreferences sharedPref;

    int[] vowelArr = new int[6]; //TODO: Count Sounds
    int vowelCounter = 0;

    boolean[] vowelStarred = new boolean[6];
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

                LinearLayout oldll = (LinearLayout) getView().findViewById(R.id.advancedll); // Used in both statements

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
                            editor.putString(getString(R.string.importedpremstarred), booleanToString(vowelStarred));
                            editor.commit();
                            insertedStar.setImageResource(R.drawable.star_btn);

                        } else {

                            Button toChange = (Button) getView().findViewById(s.buttonid);
                            toChange.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            toChange.setAlpha(0.0f);
                            toChange.animate().alpha(1.0f);
                            vowelStarred[thisvowel] = true;
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(getString(R.string.importedpremstarred), booleanToString(vowelStarred));
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
                insertedBtn.setText("PRACTICE");
                insertedBtn.setAllCaps(false);
                insertedBtn.setTextSize(16);
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
                        i.putExtra("sentFrom", 2);
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
    public static Advanced newInstance() {
        Advanced advanced = new Advanced();
        return advanced;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.advanced, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPref = getContext().getSharedPreferences(getString(R.string.preference_file_key), getContext().MODE_PRIVATE);
        importedVowelStarred = sharedPref.getString(getString(R.string.importedpremstarred), "000000");

        vowelArr = new int[6];
        vowelCounter = 0;

        vowelStarred = new boolean[6];
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

        // Short Vowels //TODO: Give each sound a main recording

        sound unstressedee = new sound(R.id.button1,"Unstressed /i/",R.raw.family,"The Unstressed /i/", new int[]{R.string.desc_unstressedee, R.string.desc_closedjaw, R.string.desc_spreadlips, R.string.desc_placementfront}, 1,1,1, new String[]{"family","totally","usually","city","pretty","many","very","only","funny","really"});
        sound nonRhoticR = new sound(R.id.button2,"Non-Rhotic /r/",R.raw.air,"The Non-Rhotic /r/", new int[]{R.string.desc_nonrhoticr}, 1,2,2, new String[]{"before","hair","conversation","measure","pleasure","treasure","cover","share","number","remember","card","dark","anger","forget","figure","chair","picture","anymore","arm","finger","morning","alarm","wallpaper","yourself","year","where","forward","homework","government","doctor","better","information","thirteen","hurt","shirt","first","work","worse","were","urgent","word","earth","service","third","murder","birth","earn","ear","beer","hear","nearly","weird","severe","clear","fear","appear","air","care","there","dare","nightmare","staircase","fair","bear","aware","pair","pure","cure","endure","mature","secure","tour","sure"});
        sound tn = new sound(R.id.button3,"/tn/",R.raw.button,"The Unvoiced Nasal Plosion", new int[]{R.string.desc_unvoiced, R.string.desc_nasalplosions}, 1,3,3, new String[]{"button","cotton","rotten","bitten","written","brighten","eaten"});
        sound dn = new sound(R.id.button4,"/dn/",R.raw.hidden,"The Voiced Nasal Plosion", new int[]{R.string.desc_voiced, R.string.desc_nasalplosions}, 2,3,3, new String[]{"hidden","sudden","shouldn't","wouldn't","hadn't","couldn't","didn't"});
        sound tl = new sound(R.id.button5,"/tɫ/",R.raw.rattle,"The Unvoiced Lateral Plosion", new int[]{R.string.desc_unvoiced, R.string.desc_lateralplosions}, 1,4,3, new String[]{"rattle","battle","settle","cattle","kettle","subtle","nettle"});
        sound dl = new sound(R.id.button6,"/dɫ/",R.raw.middle,"The Voiced Lateral Plosion", new int[]{R.string.desc_voiced, R.string.desc_lateralplosions}, 2,4,3, new String[]{"middle","saddle","cuddle","riddle","fiddle","modal","paddle"});

        createButton(button1, unstressedee);
        createButton(button2, nonRhoticR);
        createButton(button3, tn);
        createButton(button4, dn);
        createButton(button5, tl);
        createButton(button6, dl);

    }

}