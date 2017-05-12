package uk.co.voicehacker.app.practicewords;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.support.constraint.ConstraintSet.BOTTOM;
import static android.support.constraint.ConstraintSet.LEFT;
import static android.support.constraint.ConstraintSet.RIGHT;
import static android.support.constraint.ConstraintSet.TOP;
import static android.support.constraint.R.id.parent;

/**
 * Created by Matt on 12-May-17.
 */

public class Tutorial extends Fragment {

    public static Tutorial newInstance(String firstPara, String secondPara, String thirdPara, String btnText) {

        Bundle args = new Bundle();
        args.putString("firstPara", firstPara);
        args.putString("secondPara", secondPara);
        args.putString("thirdPara", thirdPara);
        args.putString("btnText", btnText);

        Tutorial tutorial = new Tutorial();
        tutorial.setArguments(args);
        return tutorial;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tutorial_fragment, container, false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        String firstPara = bundle.getString("firstPara");
        String secondPara = bundle.getString("secondPara");
        String thirdPara = bundle.getString("thirdPara");
        String buttontext = bundle.getString("btnText");

        TextView firstParaTV = (TextView) getView().findViewById(R.id.firsttxtview);
        firstParaTV.setText(firstPara);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        // firstParaTV.setLayoutParams(params);
        firstParaTV.setGravity(Gravity.CENTER_HORIZONTAL);

        // Create Slightly See-through backdrop

        LinearLayout tutcons = (LinearLayout) getView().findViewById(R.id.tutcl);

        if (secondPara != null) {

            TextView secondParaTV = new TextView(getContext());
            secondParaTV.setId(R.id.tutsecondpara);
            tutcons.addView(secondParaTV, 1, R.style.tuttext);

            secondParaTV = (TextView) getView().findViewById(R.id.tutsecondpara);
            secondParaTV.setText(secondPara);
            secondParaTV.setTextAppearance(R.style.tuttext);
            secondParaTV.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL);

            // params.weight = 1;
            params.setMargins(50,40,50,40);
            //params.gravity = Gravity.CENTER_HORIZONTAL;
            secondParaTV.setLayoutParams(params);

        }

        if (thirdPara != null) {
            TextView thirdParaTV = new TextView(getContext());
            thirdParaTV.setId(R.id.tutthirdpara);
            tutcons.addView(thirdParaTV, 2, R.style.tuttext);

            thirdParaTV = (TextView) getView().findViewById(R.id.tutthirdpara);
            thirdParaTV.setText(thirdPara);
            thirdParaTV.setTextAppearance(R.style.tuttext);
            thirdParaTV.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL);
            //params.gravity = Gravity.CENTER_HORIZONTAL;
            thirdParaTV.setLayoutParams(params);
        }

        if (buttontext != null) {
            Button btn = new Button(getContext());
            btn.setId(R.id.tutbutton);
            tutcons.addView(btn, 2);

            btn = (Button) getView().findViewById(R.id.tutbutton);
            btn.setText(buttontext);
            params.width = LinearLayout.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.CENTER;
            btn.setLayoutParams(params);
            btn.setAllCaps(false);
            btn.setTextColor(getResources().getColor(R.color.white));
            btn.setTextSize(30);
            // btn.setGravity(Gravity.CENTER);

            if (buttontext == "æ") {
                btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btn.setSoundEffectsEnabled(false);
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        MediaPlayer sound;
                            sound = MediaPlayer.create(getActivity(), R.raw.ah);
                            sound.start();
                    }
                });
            }
        }
    }

}
