package uk.co.voicehacker.app.practicewords;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Matt on 03-May-17.
 */

public class ShowWordsFragment extends Fragment {

    // Store instance variables
    private String title;
    private String[] wordArr = {};
    private int pos;


    // newInstance constructor for creating fragment with arguments
    public static ShowWordsFragment newInstance(String title, String[] wordArr, int position) {
        ShowWordsFragment showWordsFragment = new ShowWordsFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putStringArray("wordArr", wordArr);
        args.putInt("pos", position);
        showWordsFragment.setArguments(args);
        return showWordsFragment;
    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
        wordArr = getArguments().getStringArray("wordArr");
        pos = getArguments().getInt("pos");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_words_fragment, container, false);

        TextView showWordsText = (TextView) view.findViewById(R.id.showWordsText);
        String str = wordArr[pos];
        showWordsText.setText(str.substring(0, 1).toUpperCase() + str.substring(1));



        return view;
    }
}
