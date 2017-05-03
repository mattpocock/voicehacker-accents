package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.security.AccessController.getContext;

/**
 * Created by Matt on 03-May-17.
 */

public class ShowWordsPager extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;
    String wordArr[];
    String title;
    int pageSelected;

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

        //TODO Find a better word than 'previous' - people click on that button when they want to go back

        final Button bBtn = (Button) findViewById(R.id.backbtn);
        final Button nBtn = (Button) findViewById(R.id.nextbtn);
        final Button pBtn = (Button) findViewById(R.id.prevbtn);

        nBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pBtn.setPressed(false);
                nBtn.setPressed(true);
                vpPager.setCurrentItem(pageSelected + 1);
            }
        });

        pBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pBtn.setPressed(true);
                nBtn.setPressed(false);
                vpPager.setCurrentItem(pageSelected - 1);
            }
        });

        bBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

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
