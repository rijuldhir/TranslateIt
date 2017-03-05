package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.sax.RootElement;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
  {@link NumberFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumberFragment extends Fragment {

   //private OnFragmentInteractionListener mListener;
    MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener mOncomplete = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){
            if(mp!=null) {
                mp.release();
                mp=null;
                am.abandonAudioFocus(afChangeListener);
            }
        }
    };


    Context mContext;
    AudioManager am;
    AudioManager.OnAudioFocusChangeListener afChangeListener = (new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Permanent loss of audio focus
                // Pause playback immediately
                if(mediaPlayer!=null) {
                    mediaPlayer.release();
                    mediaPlayer=null;
                    am.abandonAudioFocus(afChangeListener);
                }
            }
            else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                // Pause playback
            } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                //setVolumeControlStream(AudioManager.STREAM_MUSIC);
                // Lower the volume, keep playing

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Your app has been granted audio focus again
                // Raise volume to normal, restart playback if necessary
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mOncomplete);
            }
        }
    });

    public NumberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        words.add(new Words("ten",""));
        words.add(new Words("ten","",R.mipmap.ic_launcher));
        words.add(new Words("ten","",R.mipmap.ic_launcher));
        words.add(new Words("ten",""));

        /*for(int i=0;i<2;i++)
            Log.d("Numbers Activity","Words at 0: "+words.get(i));*/

        //LinearLayout rootview = (LinearLayout)findViewById(R.id.activity_numbers);
        /*for(int i=0;i<4;i++)
        {
            TextView word = new TextView(this);
            word.setText(words.get(i));
            rootview.addView(word);
        }*/
        WordAdapter adapter = new WordAdapter(getActivity(), words,R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //Toast.makeText(NumbersActivity.this,"Did something",Toast.LENGTH_SHORT).show();
                if(mediaPlayer!=null) {
                    mediaPlayer.release();
                    mediaPlayer=null;
                    am.abandonAudioFocus(afChangeListener);
                }

                int focus = am.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(focus==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mediaPlayer = MediaPlayer.create(getActivity(), words.get(position).getAudio());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mOncomplete);
                }
            }
        });
        return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
        if(mediaPlayer!=null) {
            mediaPlayer.release();
            mediaPlayer=null;
            am.abandonAudioFocus(afChangeListener);
        }
    }
}
