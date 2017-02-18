package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

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


        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.activity_colors);

        listView.setAdapter(adapter);
    }
}
