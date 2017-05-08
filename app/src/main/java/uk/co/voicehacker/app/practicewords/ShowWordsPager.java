package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;

/**
 * Created by Matt on 03-May-17.
 */

public class ShowWordsPager extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;
    String wordArr[];
    String title;
    int sentFrom;
    int moreInfoSections[];
    int pageSelected;

    public String getTitlefromDesc(int desc) {

        String t;

        switch (desc) {
            case R.string.desc_morecoming: t = "More Coming Soon";
                break;
            case R.string.desc_closedjaw: t = "Jaw: Closed";
                break;
            case R.string.desc_midjaw: t = "Jaw: Semi-Open";
                break;
            case R.string.desc_openjaw: t = "Jaw: Open";
                break;
            case R.string.desc_longvowels: t = "Long Vowel";
                break;
            case R.string.desc_shortvowels: t = "Short Vowel";
                break;
            case R.string.desc_diphthongs: t = "Diphthong";
                break;
            case R.string.desc_roundedlips: t = "Lips: Rounded";
                break;
            case R.string.desc_neutrallips: t = "Lips: Neutral";
                break;
            case R.string.desc_spreadlips: t = "Lips: Spread";
                break;
            case R.string.desc_placementback: t = "Placement: Back";
                break;
            case R.string.desc_placementcentral: t = "Placement: Central";
                break;
            case R.string.desc_placementfront: t = "Placement: Front";
                break;
            case R.string.desc_fricatve: t = "Fricative";
                break;
            case R.string.desc_plosive: t = "Plosive";
                break;
            case R.string.desc_affricate: t = "Affricate";
                break;
            case R.string.desc_nasal: t = "Nasal";
                break;
            case R.string.desc_approximant: t = "Approximant";
                break;
            case R.string.desc_voiced: t = "Voiced";
                break;
            case R.string.desc_unvoiced: t = "Unvoiced";
                break;
            default: t = "Unknown Title";
                break;
        }

        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_words_pager);
        final ViewPager vpPager = (ViewPager) findViewById(R.id.showwordsvpager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        // Get Intent Stuff

        Intent intent = getIntent();
        wordArr = intent.getStringArrayExtra("wordArr");
        title = intent.getStringExtra("title");
        sentFrom = intent.getIntExtra("sentFrom", 0);
        moreInfoSections = intent.getIntArrayExtra("moreInfoSections");

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                pageSelected = position;
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

        final Button bBtn = (Button) findViewById(R.id.backbtn);
        final ImageButton nBtn = (ImageButton) findViewById(R.id.nextbtn);
        final ImageButton pBtn = (ImageButton) findViewById(R.id.prevbtn);

        nBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vpPager.setCurrentItem(pageSelected + 1);
            }
        });

        pBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vpPager.setCurrentItem(pageSelected - 1);
            }
        });

        bBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("sentFrom", sentFrom);
                startActivity(i);
            }
        });

        LinearLayout moreinfoll = (LinearLayout) findViewById(R.id.moreinfo);

        TextView titleview = (TextView) findViewById(R.id.moreinfotitle);
        titleview.setText(title);

        int insertID = 0; // 1 Because of title, 0 if none

        for (int i = 0; i < moreInfoSections.length; i++) {

            // Subtitle

            TextView subtitle = new TextView(getApplicationContext());
            subtitle.setId(i);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i == 0) {
                params.topMargin = 24;
            }
            params.bottomMargin = 24;
            moreinfoll.addView(subtitle, insertID, params);
            TextView insertedSub = (TextView) findViewById(i);
            insertedSub.setText(getTitlefromDesc(moreInfoSections[i]));
            insertedSub.setTextAppearance(this, R.style.MoreInfoSub);
            // insertedSub.setGravity(Gravity.CENTER);
            insertID++;

            //TODO: Create Buttons instead of Body

            // Body

            TextView body = new TextView(getApplicationContext());
            body.setId(i + 1000);
            body.setVisibility(View.GONE);
            LinearLayout.LayoutParams bodyparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            bodyparams.bottomMargin = 24;
            moreinfoll.addView(body, insertID, bodyparams);
            TextView insertedBody = (TextView) findViewById(i + 1000);
            insertedBody.setText(moreInfoSections[i]);
            insertedBody.setTextAppearance(this, R.style.MoreInfoBody);
            insertID++;

            Button moreinfobtn = new Button(getApplicationContext(), null, R.drawable.moreinfobtn);
            moreinfobtn.setId(i + 2000);
            moreinfobtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.moreinfobtn));
            LinearLayout.LayoutParams btnparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btnparams.bottomMargin = 24;
            moreinfoll.addView(moreinfobtn, insertID, btnparams);
            Button insertedBtn = (Button) findViewById(i + 2000);
            insertedBtn.setTextSize(16);
            insertedBtn.setText("MORE INFO");
            insertedBtn.setTextColor(getResources().getColor(R.color.colorPrimary));

            final int listenerID = i;
            insertedBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Button btn = (Button) findViewById(listenerID + 2000);
                    btn.setVisibility(View.GONE);
                    TextView body = (TextView) findViewById(listenerID + 1000);
                    body.setVisibility(View.VISIBLE);
                }
            });
            insertID++;

        }

    }

    // ...

    public class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            Intent intent = getIntent();
            wordArr = intent.getStringArrayExtra("wordArr");
            return wordArr.length;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            return ShowWordsFragment.newInstance(title, wordArr, position);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

}
