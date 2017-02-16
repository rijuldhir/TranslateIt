package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("one", "lutti",R.drawable.number_one));
        words.add(new Words("two", "otiiko",R.drawable.number_two));
        words.add(new Words("three", "tolookosu",R.drawable.number_three));
        words.add(new Words("four", "oyyisa",R.drawable.number_four));
        words.add(new Words("five", "massokka",R.drawable.number_five));
        words.add(new Words("six", "temmokka",R.drawable.number_six));
        words.add(new Words("seven", "kenekaku",R.drawable.number_seven));
        words.add(new Words("eight", "kawinta",R.drawable.number_eight));
        words.add(new Words("nine", "wo’e",R.drawable.number_nine));
        words.add(new Words("ten", "na’aacha",R.drawable.number_ten));
        words.add(new Words("ten",""));
        words.add(new Words("ten","",R.mipmap.ic_launcher));
        words.add(new Words("ten","",R.mipmap.ic_launcher));
        words.add(new Words("ten",""));

        for(int i=0;i<2;i++)
        Log.d("Numbers Activity","Words at 0: "+words.get(i));
        //LinearLayout rootview = (LinearLayout)findViewById(R.id.activity_numbers);
        /*for(int i=0;i<4;i++)
        {
            TextView word = new TextView(this);
            word.setText(words.get(i));
            rootview.addView(word);
        }*/
        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
