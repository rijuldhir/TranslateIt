package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("one", "lutti"));
        words.add(new Words("two", "otiiko"));
        words.add(new Words("three", "tolookosu"));
        words.add(new Words("four", "oyyisa"));
        words.add(new Words("five", "massokka"));
        words.add(new Words("six", "temmokka"));
        words.add(new Words("seven", "kenekaku"));
        words.add(new Words("eight", "kawinta"));
        words.add(new Words("nine", "wo’e"));
        words.add(new Words("ten", "na’aacha"));
        words.add(new Words("ten",""));
        words.add(new Words("ten",""));
        words.add(new Words("ten",""));
        words.add(new Words("ten",""));


        WordAdapter adapter = new WordAdapter(getActivity(), words,R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);


        return rootView;
    }

}
