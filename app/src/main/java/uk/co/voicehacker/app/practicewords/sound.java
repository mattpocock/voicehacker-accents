package uk.co.voicehacker.app.practicewords;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Matt on 21-Apr-17.
 */

public class sound {
    int buttonid;
    String[] words = {};
    int[] moreinfosections = {};
    String symbol;
    int soundfile;
    String title;
    int row;
    int column;
    int section;

    public sound(int id, String sym, int file, String tit, int[] mIS, int col, int ro, int sec, String[] wordArr) {
        buttonid = id;
        words = wordArr;
        symbol = sym;
        soundfile = file;
        moreinfosections = mIS;
        title = tit;
        row = ro;
        column = col;
        section = sec;

    }
}
