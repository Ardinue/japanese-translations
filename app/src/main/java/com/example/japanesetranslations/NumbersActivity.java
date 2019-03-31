package com.example.japanesetranslations;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ArrayList<Word> sectionWords = new ArrayList<>();

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            releaseMediaPlayer();

            Integer audioResourceId = ((Word)adapterView.getItemAtPosition(i)).getAudioResourceId();

            if(audioResourceId != null) {
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, audioResourceId);
                mediaPlayer.setOnCompletionListener(onCompletionListener);
                mediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        sectionWords.add(new Word("one","いち (ichi)", R.drawable.number_one));
        sectionWords.add(new Word("two","に (ni)", R.drawable.number_two));
        sectionWords.add(new Word("three","さん (san)", R.drawable.number_three));
        sectionWords.add(new Word("four","し、よん (shi, yon)", R.drawable.number_four));
        sectionWords.add(new Word("five","ご (go)", R.drawable.number_five));
        sectionWords.add(new Word("six","ろく (roku)", R.drawable.number_six));
        sectionWords.add(new Word("seven","しち、なな (shichi, nana)", R.drawable.number_seven));
        sectionWords.add(new Word("eight","はち (hachi)", R.drawable.number_eight));
        sectionWords.add(new Word("nine","く、きゅう (ku, kyuu)", R.drawable.number_nine));
        sectionWords.add(new Word("ten","じゅう (juu)", R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, sectionWords, R.color.category_numbers);

        ListView listView = findViewById(R.id.word_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null) {

            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }
    }
}
