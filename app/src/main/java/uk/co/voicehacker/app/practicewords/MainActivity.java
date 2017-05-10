package uk.co.voicehacker.app.practicewords;



import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    FragmentPagerAdapter adapterViewPager;
    /*
    public void onDataPass(int[] data) {
        //TODO: This is the int array being passed back from the fragment.
    } */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        Intent intent = getIntent();
        if (intent != null) {
            int p = intent.getIntExtra("sentFrom", 0);
            vpPager.setCurrentItem(p);
        }





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

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }


}



