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
        words.add(new Words("ten",""));
        words.add(new Words("ten",""));
        words.add(new Words("ten",""));
        words.add(new Words("ten",""));


        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.activity_colors);

        listView.setAdapter(adapter);
    }
}
