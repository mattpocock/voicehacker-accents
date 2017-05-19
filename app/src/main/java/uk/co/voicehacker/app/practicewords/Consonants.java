package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.Arrays;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Matt on 01-May-17.
 */

public class Consonants extends Fragment {

    // Declares Buttons & Sounds

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25;

    MediaPlayer allsounds;

    // Keeps track of all buttons created

    SharedPreferences sharedPref;

    int[] soundArr = new int[25];
    int soundCounter = 0;

    boolean[] soundStarred = new boolean[25];
    String importedSoundStarred = "";
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

        final int thisSound = soundCounter;

        btn = (Button) getView().findViewById(s.buttonid);
        btn.setText(s.symbol);
        btn.setSoundEffectsEnabled(false);
        btn.setAlpha(0.0f);
        btn.animate().alpha(1.0f);

        if (!soundStarred[thisSound] && !firstStarPress) {
            btn.setBackgroundColor(getResources().getColor(R.color.darkGrey));
        }

        // Adds all Button Id's to btnArray

        soundArr[soundCounter] = s.buttonid;

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



                LinearLayout oldll = (LinearLayout) getView().findViewById(R.id.consonantll); // Used in both statements

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

                // Converts to dp

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

                if (!soundStarred[thisSound]) {

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

                            for (int i = 0; i < soundArr.length; i++) {
                                Button toChange = (Button) getView().findViewById(soundArr[i]);
                                toChange.setBackgroundColor(getResources().getColor(R.color.darkGrey));
                                toChange.setAlpha(0.0f);
                                toChange.animate().alpha(1.0f);
                                soundStarred[i] = false;
                            }

                            firstStarPress = false;

                        }

                        if (soundStarred[thisSound]) {

                            Button toChange = (Button) getView().findViewById(soundArr[thisSound]);
                            toChange.setBackgroundColor(getResources().getColor(R.color.darkGrey));
                            toChange.setAlpha(0.0f);
                            toChange.animate().alpha(1.0f);
                            soundStarred[thisSound] = false;

                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(getString(R.string.importedconsonantsstarred), booleanToString(soundStarred));
                            editor.commit();

                            insertedStar.setImageResource(R.drawable.star_btn1);

                        } else {

                            Button toChange = (Button) getView().findViewById(s.buttonid);
                            toChange.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            toChange.setAlpha(0.0f);
                            toChange.animate().alpha(1.0f);
                            soundStarred[thisSound] = true;
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(getString(R.string.importedconsonantsstarred), booleanToString(soundStarred));
                            editor.commit();
                            insertedStar.setImageResource(R.drawable.star_btn2);
                        }

                        // Turns all blue again if all off

                        boolean alloff = true;

                        for (int i = 0; i < soundStarred.length; i++) {
                            if (soundStarred[i]) {alloff = false;}
                        }

                        if (alloff) {
                            for (int i = 0; i < soundArr.length; i++) {
                                Button toChange = (Button) getView().findViewById(soundArr[i]);
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
                        i.putExtra("sentFrom", 0);
                        i.putExtra("moreInfoSections", s.moreinfosections);
                        if (allsounds != null) {
                            allsounds.release();
                        }
                        startActivity(i);

                    }
                });
            }
        });

        soundCounter++; // This has to go here to keep soundCounter as this button's id.

    }

    // newInstance constructor for creating fragment with arguments
    public static Consonants newInstance() {
        Consonants consonants = new Consonants();
        return consonants;
    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}



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

        // Check Preferences

            SharedPreferences sharedPref = getContext().getSharedPreferences(getString(R.string.preference_file_key), getContext().MODE_PRIVATE);
            importedSoundStarred = sharedPref.getString(getString(R.string.importedconsonantsstarred), "0000000000000000000000000");

            soundArr = new int[25];
            soundCounter = 0;

            soundStarred = new boolean[25];
            firstStarPress = true;

            navBarOn = false;

            for (int i = 0; i < importedSoundStarred.length(); i++) {
                String sub = importedSoundStarred.substring(i,(i+1));
                if (Integer.parseInt(sub) == 0) {
                    soundStarred[i] = false;
                } else {
                    soundStarred[i] = true;
                    firstStarPress = false;
                }
            }



        // Creates Buttons

        sound unvoicedTHsound = new sound(R.id.button1,"θ",R.raw.unvoicedth,"The Unvoiced TH - /θ/", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_thsound}, 1,1,1, new String[]{"think","anything","bath","breath","death","everything","month","mouth","nothing","something","thumb","thistle", "path", "moth","worth"});
        sound voicedTHsound = new sound(R.id.button2,"ð",R.raw.voicedth,"The Voiced TH - /ð/", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_thsound}, 2,1,1, new String[]{"this","than","that","the","themselves","mother","brother","these","they","together","those","them","with","bathe","father"});
        sound sSound = new sound(R.id.button3,"s",R.raw.ssound,"The /s/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_szsounds}, 3,1,1, new String[]{"accept","against","almost","also","answer","ask","asleep","beside","best","breakfast","simple","cast","mast","feast","mess"});
        sound zSound = new sound(R.id.button4,"z",R.raw.zsound,"The /z/ Sound", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_szsounds}, 1,2,1, new String[]{"as","busy","always","cause","confuse","does","easy","has","is","jeans","feels","rails","wands","was","rose"});
        sound fSound = new sound(R.id.button5,"f",R.raw.fsound,"The /f/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_fvsounds}, 2,2,1, new String[]{"afraid","after","beautiful","before","boyfriend","breakfast","coffee","confuse","definitely","different","fight","fell","feel","finish","found"});
        sound vSound = new sound(R.id.button6,"v",R.raw.vsound,"The /v/ Sound", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_fvsounds}, 3,2,1, new String[]{"voice","above","arrive","avoid","believe","conversation","cover","drive","even","everyone","very","save","veil","never","however"});
        sound hSound = new sound(R.id.button7,"h",R.raw.hsound,"The /h/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_hsound}, 1,3,1, new String[]{"ahead","behind","had","hair","half","hall","hand","hang","happy","hard","who","help","whose","perhaps","hot"});
        sound shSound = new sound(R.id.button8,"ʃ",R.raw.shsound,"The /ʃ/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_shzhsounds}, 2,3,1, new String[]{"brush","finish","flash","push","relationship","rush","shadow","shake","share","she","shame","shape","shine","leash","fish"});
        sound zhSound = new sound(R.id.button9,"ʒ",R.raw.zhsound,"The /ʒ/ Sound", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_shzhsounds}, 3,3,1, new String[]{"measure","treasure","pleasure","vision","usual","casual","revision","occasion","division","decision","asia","closure","version","explosion","conclusion"});

        createButton(button1, unvoicedTHsound);
        createButton(button2, voicedTHsound);
        createButton(button3, sSound);
        createButton(button4, zSound);
        createButton(button5, fSound);
        createButton(button6, vSound);
        createButton(button7, hSound);
        createButton(button8, shSound);
        createButton(button9, zhSound);

        // Plosives

        sound pSound = new sound(R.id.button10,"p",R.raw.psound,"The /p/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_plosive, R.string.desc_pbsounds},1,4,2, new String[]{"drop","empty","escape","except","flip","gasp","happen","hope","help","important","possess","prize","pet","cape","mop"});
        sound bSound = new sound(R.id.button11,"b",R.raw.bsound,"The /b/ Sound", new int[]{R.string.desc_voiced, R.string.desc_plosive, R.string.desc_pbsounds}, 2,4,2, new String[]{"by","eyebrow","job","maybe","number","possible","probably","problem","remember","table","rub","pub","cable","bomb","boss"});
        sound tSound = new sound(R.id.button12,"t",R.raw.tsound,"The /t/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_plosive, R.string.desc_tdsounds}, 3,4,2, new String[]{"foot","forget","front","get","great","hate","heart","hospital","important","jacket","time","toast","top","coat","feast"});
        sound dSound = new sound(R.id.button13,"d",R.raw.dsound,"The /d/ Sound", new int[]{R.string.desc_voiced, R.string.desc_plosive, R.string.desc_tdsounds}, 1,5,2, new String[]{"admit","already","around","behind","blonde","body","card","cold","consider","dance","find","don't","different","breed","load"});
        sound kSound = new sound(R.id.button14,"k",R.raw.ksound,"The /k/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_plosive, R.string.desc_kgsounds}, 2,5,2, new String[]{"attack","back","breakfast","check","chuckle","dark","jacket","keep","kept","kick","socks","creek","can't","coast","kitchen"});
        sound gSound = new sound(R.id.button15,"g",R.raw.gsound,"The /g/ Sound", new int[]{R.string.desc_voiced, R.string.desc_plosive, R.string.desc_kgsounds}, 3,5,2, new String[]{"again","ago","anger","began","begin","drag","figure","forget","game","gasp","grant","beg","fog","bug","agree"});

        createButton(button10, pSound);
        createButton(button11, bSound);
        createButton(button12, tSound);
        createButton(button13, dSound);
        createButton(button14, kSound);
        createButton(button15, gSound);

        // Affricates

        sound chSound = new sound(R.id.button16,"tʃ",R.raw.chsound,"The /tʃ/ Sound", new int[]{R.string.desc_unvoiced, R.string.desc_affricate, R.string.desc_shzhsounds}, 1,6,3, new String[]{"approach","catch","chair","chance","chase","check","chest","child","chuckle","kitchen","match","inches","picture","lunch","touch"});
        sound jSound = new sound(R.id.button17,"dʒ",R.raw.jsound,"The /dʒ/ Sound", new int[]{R.string.desc_voiced, R.string.desc_affricate, R.string.desc_shzhsounds}, 2,6,3, new String[]{"enjoy","jacket","jeans","join","joke","jump","just","edge","age","college","agent","object","project","bridge","damage"});
        createButton(button16, chSound);
        createButton(button17, jSound);

        // Nasals

        sound mSound = new sound(R.id.button18,"m",R.raw.msound,"The /m/ Sound", new int[]{R.string.desc_voiced, R.string.desc_nasal, R.string.desc_msounds}, 1,7,4, new String[]{"admit","almost","amaze","anymore","arm","became","bedroom","bottom","climb","come","tomato","number","animal","famous","stream"});
        sound nSound = new sound(R.id.button19,"n",R.raw.nsound,"The /n/ Sound", new int[]{R.string.desc_voiced, R.string.desc_nasal, R.string.desc_nsounds}, 2,7,4, new String[]{"band","been","began","blonde","boyfriend","chance","change","children","continue","control","pony","frown","moon","nine","noise"});
        sound ngSound = new sound(R.id.button20,"ŋ",R.raw.ngsound,"The /ŋ/ Sound", new int[]{R.string.desc_voiced, R.string.desc_nasal, R.string.desc_ngsounds}, 3,7,4, new String[]{"during","evening","finger","hung","blink","drink","pink","thank","long","morning","bring","sing","spring","king","swing"});
        createButton(button18, mSound);
        createButton(button19, nSound);
        createButton(button20, ngSound);

        // Approximants

        sound lightLSound = new sound(R.id.button21,"l",R.raw.lightl,"The Light L - /l/", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_lsounds}, 1,8,5, new String[]{"believe","blink","climb","flip","life","clean","college","lean","lead","please","belly","sailing","alarm","police","family"});
        sound darkLSound = new sound(R.id.button22,"ɫ",R.raw.darkl,"The Dark L - /ɫ/", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_lsounds, R.string.desc_darkl}, 2,8,5, new String[]{"table","still","chuckle","couple","giggle","call","fill","bill","tell","shall","wallpaper","elbow","pencil","owl","muscle"});
        sound rSound = new sound(R.id.button23,"r",R.raw.rsound,"The /r/ Sound", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_rsound}, 3,8,5, new String[]{"carry","very","cry","dry","every","real","right","ring","round","sorry","carrot","giraffe","pirate","camera","syrup"});
        sound ySound = new sound(R.id.button24,"j",R.raw.ysound,"The /j/ Sound", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_ysound}, 1,9,5, new String[]{"year","UK","yell","yes","yet","yourself","USA","beautiful","curious","music","union","useful","yesterday","yoghurt","unique"});
        sound wSound = new sound(R.id.button25,"w",R.raw.wsound,"The /w/ Sound", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_wsound}, 1,9,5, new String[]{"one","once","what","why","where","forward","however","sweet","quite","quiet","always","award","homework","reward","microwave"});
        createButton(button21, lightLSound);
        createButton(button22, darkLSound);
        createButton(button23, rSound);
        createButton(button24, ySound);
        createButton(button25, wSound);


    }

}