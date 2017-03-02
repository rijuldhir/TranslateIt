package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Rijul on 1/10/2017.
 */

public class WordAdapter extends ArrayAdapter<Words> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int color;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Words w = getItem(position);
        TextView DefaultTextView = (TextView) listItemView.findViewById(R.id.textView);
        DefaultTextView.setText(w.getDefaultTranslation());
        TextView MiwokTextView = (TextView) listItemView.findViewById(R.id.textView2);
        MiwokTextView.setText(w.getMiwokTranslation());
        ImageView MiwokImageView = (ImageView) listItemView.findViewById(R.id.image1);
        if(w.hasImage()) {
            MiwokImageView.setImageResource(w.getImage());
            MiwokImageView.setVisibility(View.VISIBLE);
        }
        else
        MiwokImageView.setVisibility(View.GONE);

        View textcont = listItemView.findViewById(R.id.textcontainer);
        View play = listItemView.findViewById(R.id.play);
        int Color = ContextCompat.getColor(getContext(),color);
        textcont.setBackgroundColor(Color);
        play.setBackgroundColor(Color);
        return listItemView;
    }

    public WordAdapter(Activity context, ArrayList<Words> z, int color)
    {
        super(context, 0, z);
        this.color=color;
    }

}
