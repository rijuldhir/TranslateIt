package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    MediaPlayer mediaPlayer;
    AudioManager am;
    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        am = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("one", "lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Words("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Words("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Words("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Words("five", "massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Words("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Words("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Words("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Words("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Words("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));
        words.add(new Words("ten","",R.mipmap.ic_launcher));


        WordAdapter adapter = new WordAdapter(getActivity(), words,R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}
