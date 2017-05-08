package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Matt on 01-May-17.
 */

public class Consonants extends Fragment {

    // Declares Buttons & Sounds

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25;

    MediaPlayer allsounds;

    // Is there a navbar?

    boolean navBarOn = false;

    // Create Button Method

    public void createButton(Button btn, final sound s) {
        btn = (Button) getView().findViewById(s.buttonid);
        btn.setText(s.symbol);
        btn.setSoundEffectsEnabled(false);

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

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(16,12,16,0);
                params.gravity = Gravity.CENTER_HORIZONTAL;

                Button navbtn = new Button(getContext());
                navbtn.setId(R.id.navbarbtn);



                LinearLayout oldll = (LinearLayout) getView().findViewById(R.id.consonantll); // Used in both statements

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
                        i.putExtra("sentFrom", 0);
                        i.putExtra("moreInfoSections", s.moreinfosections);
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

        //TODO: Add descriptions for each consonant: Bilabial, Dental etc.

        sound unvoicedTHsound = new sound(R.id.button1,"θ",R.raw.unvoicedth,"The Unvoiced TH", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_morecoming}, 1,1,1, new String[]{"think","anything","bath","breath","death","everything","month","mouth","nothing","something"});
        sound voicedTHsound = new sound(R.id.button2,"ð",R.raw.voicedth,"The Voiced TH", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_morecoming}, 2,1,1, new String[]{"this","than","that","the","themselves","mother","brother","these","they","together"});
        sound sSound = new sound(R.id.button3,"s",R.raw.ssound,"The S Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_morecoming}, 3,1,1, new String[]{"accept","against","almost","also","answer","ask","asleep","beside","best","breakfast"});
        sound zSound = new sound(R.id.button4,"z",R.raw.zsound,"The Z Sound", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_morecoming}, 1,2,1, new String[]{"as","busy","always","cause","confuse","does","easy","has","is","jeans"});
        sound fSound = new sound(R.id.button5,"f",R.raw.fsound,"The F Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_morecoming}, 2,2,1, new String[]{"afraid","after","beautiful","before","boyfriend","breakfast","coffee","confuse","definitely","different"});
        sound vSound = new sound(R.id.button6,"v",R.raw.vsound,"The V Sound", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_morecoming}, 3,2,1, new String[]{"voice","above","arrive","avoid","believe","conversation","cover","drive","even","everyone"});
        sound hSound = new sound(R.id.button7,"h",R.raw.hsound,"The H Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_morecoming}, 1,3,1, new String[]{"ahead","behind","had","hair","half","hall","hand","hang","happy","hard"});
        sound shSound = new sound(R.id.button8,"ʃ",R.raw.shsound,"The SH Sound", new int[]{R.string.desc_unvoiced, R.string.desc_fricatve, R.string.desc_morecoming}, 2,3,1, new String[]{"brush","finish","flash","push","relationship","rush","shadow","shake","share","she"});
        sound zhSound = new sound(R.id.button9,"ʒ",R.raw.zhsound,"The /ʒ/ Sound", new int[]{R.string.desc_voiced, R.string.desc_fricatve, R.string.desc_morecoming}, 3,3,1, new String[]{"measure","treasure","pleasure","vision","usual","casual","revision","occasion","division","decision"});

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

        sound pSound = new sound(R.id.button10,"p",R.raw.psound,"The P Sound", new int[]{R.string.desc_unvoiced, R.string.desc_plosive, R.string.desc_morecoming},1,4,2, new String[]{"drop","empty","escape","except","flip","gasp","happen","hope","help","important"});
        sound bSound = new sound(R.id.button11,"b",R.raw.bsound,"The B Sound", new int[]{R.string.desc_voiced, R.string.desc_plosive, R.string.desc_morecoming}, 2,4,2, new String[]{"by","eyebrow","job","maybe","number","possible","probably","problem","remember","table"});
        sound tSound = new sound(R.id.button12,"t",R.raw.tsound,"The T Sound", new int[]{R.string.desc_unvoiced, R.string.desc_plosive, R.string.desc_morecoming}, 3,4,2, new String[]{"foot","forget","front","get","great","hate","heart","hospital","important","jacket"});
        sound dSound = new sound(R.id.button13,"d",R.raw.dsound,"The D Sound", new int[]{R.string.desc_voiced, R.string.desc_plosive, R.string.desc_morecoming}, 1,5,2, new String[]{"admit","already","around","behind","blonde","body","card","cold","consider","dance"});
        sound kSound = new sound(R.id.button14,"k",R.raw.ksound,"The K Sound", new int[]{R.string.desc_unvoiced, R.string.desc_plosive, R.string.desc_morecoming}, 2,5,2, new String[]{"attack","back","breakfast","check","chuckle","dark","jacket","keep","kept","kick"});
        sound gSound = new sound(R.id.button15,"g",R.raw.gsound,"The G Sound", new int[]{R.string.desc_voiced, R.string.desc_plosive, R.string.desc_morecoming}, 3,5,2, new String[]{"again","ago","anger","began","begin","drag","figure","forget","game","gasp"});

        createButton(button10, pSound);
        createButton(button11, bSound);
        createButton(button12, tSound);
        createButton(button13, dSound);
        createButton(button14, kSound);
        createButton(button15, gSound);

        // Affricates

        sound chSound = new sound(R.id.button16,"tʃ",R.raw.chsound,"The CH Sound", new int[]{R.string.desc_unvoiced, R.string.desc_affricate, R.string.desc_morecoming}, 1,6,3, new String[]{"approach","catch","chair","chance","chase","check","chest","child","chuckle","kitchen"});
        sound jSound = new sound(R.id.button17,"dʒ",R.raw.jsound,"The J Sound", new int[]{R.string.desc_voiced, R.string.desc_affricate, R.string.desc_morecoming}, 2,6,3, new String[]{"enjoy","jacket","jeans","join","joke","jump","just","edge","age","college"});
        createButton(button16, chSound);
        createButton(button17, jSound);

        // Nasals

        sound mSound = new sound(R.id.button18,"m",R.raw.msound,"The M Sound", new int[]{R.string.desc_voiced, R.string.desc_nasal, R.string.desc_morecoming}, 1,7,4, new String[]{"admit","almost","amaze","anymore","arm","became","bedroom","bottom","climb","come"});
        sound nSound = new sound(R.id.button19,"n",R.raw.nsound,"The N Sound", new int[]{R.string.desc_voiced, R.string.desc_nasal, R.string.desc_morecoming}, 2,7,4, new String[]{"band","been","began","blonde","boyfriend","chance","change","children","continue","control"});
        sound ngSound = new sound(R.id.button20,"ŋ",R.raw.ngsound,"The NG Sound", new int[]{R.string.desc_voiced, R.string.desc_nasal, R.string.desc_morecoming}, 3,7,4, new String[]{"during","evening","finger","hung","blink","drink","pink","thank","long","morning"});
        createButton(button18, mSound);
        createButton(button19, nSound);
        createButton(button20, ngSound);

        // Approximants

        sound lightLSound = new sound(R.id.button21,"l",R.raw.lightl,"The Light L", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_morecoming}, 1,8,5, new String[]{"believe","blink","climb","flip","life","clean","college","lean","lead","please"});
        sound darkLSound = new sound(R.id.button22,"ɫ",R.raw.darkl,"The Dark L", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_morecoming}, 2,8,5, new String[]{"bottle","still","chuckle","couple","giggle","call","fill","bill","tell","shall"});
        sound rSound = new sound(R.id.button23,"r",R.raw.rsound,"The R Sound", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_morecoming}, 3,8,5, new String[]{"carry","very","cry","dry","every","real","right","ring","round","sorry"});
        sound ySound = new sound(R.id.button24,"j",R.raw.ysound,"The Yod", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_morecoming}, 1,9,5, new String[]{"year","UK","yell","yes","yet","yourself","USA","beautiful","curious","music"});
        sound wSound = new sound(R.id.button25,"w",R.raw.wsound,"The W Sound", new int[]{R.string.desc_voiced, R.string.desc_approximant, R.string.desc_morecoming}, 1,9,5, new String[]{"one","once","what","why","where","forward","however","sweet","quite","quiet"});
        createButton(button21, lightLSound);
        createButton(button22, darkLSound);
        createButton(button23, rSound);
        createButton(button24, ySound);
        createButton(button25, wSound);


    }

}