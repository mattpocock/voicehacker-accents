package uk.co.voicehacker.app.practicewords;



import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    FragmentPagerAdapter adapterViewPager;
    FragmentPagerAdapter tutadapterViewPager;
    /*
    public void onDataPass(int[] data) {
        //TODO: This is the int array being passed back from the fragment.
    } */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tutorial ViewPager

        final ViewPager tutPager = (ViewPager) findViewById(R.id.tutViewPager);
        tutadapterViewPager = new tutPagerAdapter(getSupportFragmentManager());
        tutPager.setAdapter(tutadapterViewPager);

        // Main ViewPager

        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        // Top Reset Button

        ImageButton resetBtn = (ImageButton) findViewById(R.id.resetbtn);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), getApplicationContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                int cur = vpPager.getCurrentItem();

                if (0 == cur) {
                    editor.putString(getString(R.string.importedconsonantsstarred), "0000000000000000000000000");
                } else {
                    editor.putString(getString(R.string.importedvowelsstarred), "00000000000000000000");
                }
                editor.commit();
                vpPager.setAdapter(adapterViewPager);
                vpPager.setCurrentItem(cur);
            }
        });

        // Checks Main Vpager if it was sent back from the show words fragment

        Intent intent = getIntent();
        if (intent != null) {
            int p = intent.getIntExtra("sentFrom", 0);
            vpPager.setCurrentItem(p);
        }

        // Main vPager handling

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
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

        // TutPager Handling

        tutPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
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

        // Navigator Buttons

        final Button vBtn = (Button) findViewById(R.id.vowelbtn);
        final Button cBtn = (Button) findViewById(R.id.consbtn);
        vBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vpPager.setCurrentItem(1);
            }
        });
        cBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vpPager.setCurrentItem(0);
            }
        });

        //

        final LinearLayout tutview = (LinearLayout) findViewById(R.id.tutframe);
        tutview.setVisibility(View.INVISIBLE);
        tutview.animate().translationY(tutview.getHeight());
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), getApplicationContext().MODE_PRIVATE);
        boolean tutorialviewed = sharedPref.getBoolean(getString(R.string.tutorialviewed), false);

        if (!tutorialviewed) {
            tutview.setVisibility(View.VISIBLE);
            tutview.animate().translationY(0);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(getString(R.string.tutorialviewed), true);
            editor.commit();
        }

        final ImageButton tutagainbtn = (ImageButton) findViewById(R.id.toptutbtn);

        tutagainbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tutPager.setCurrentItem(0);
                tutview.setAlpha(0);
                tutview.setVisibility(View.VISIBLE);
                tutview.animate().alpha(1).translationY(0);
            }
        });

        Button tutnextbtn = (Button) findViewById(R.id.tut_nextbtn);
        tutnextbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tutPager.setCurrentItem(tutPager.getCurrentItem() + 1);
            }
        });

        Button tutskipbtn = (Button) findViewById(R.id.tut_skipbtn);
        tutskipbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tutview.animate().translationY(tutview.getHeight());
            }
        });

    }

    // ...

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        public static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Consonants.newInstance();
                case 1:
                    return Vowels.newInstance();
                default:
                    return null;
            }
        }

    }

    // More Tutorial Stuff - PagerAdapter

    public static class tutPagerAdapter extends FragmentPagerAdapter {
        public static int NUM_ITEMS = 6;

        public tutPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Tutorial.newInstance("Welcome to VoiceHacker Accents!", "You can use our app to learn phonetics, improve your English pronunciation, or master a new accent.", "Press the 'Next' Button to Continue.", null);
                case 1:
                    return Tutorial.newInstance("Every accent is composed of different sounds, and each of those sounds is represented by a letter.", "This is called the 'International Phonetic Alphabet', or 'IPA' for short.", "To hear the sound the letter represents, press it.", "æ");
                case 2:
                    return Tutorial.newInstance("Your accent might be very different from the way you want it.", "The way you change it is by practicing and changing each sound individually.","Try listening to each of the sounds to see if you can make it. If you can't, you might need to work on it.",null);
                case 3:
                    return Tutorial.newInstance("You can press 'practice' to listen to a list of words that contain the sound you need to work on.", "When you practice, trying mimicking the words as best you can.", "You'll even be able to read detailed descriptions of how the word should sound.", null);
                case 4:
                    return Tutorial.newInstance("If you find a sound you know you need to work on, you can 'star' it for later.", "If you ever want to reset which sounds you've starred, you can press the 'reset' button in the top right corner.", null, null);
                case 5:
                    return Tutorial.newInstance("And if you ever want to see this tutorial again, press the '!' button in the top right corner of the screen.", "Happy Accent Learning!", "- Matt Pocock, Accent Coach and App Maker", null);
                default:
                    return null;
            }
        }

    }


}



