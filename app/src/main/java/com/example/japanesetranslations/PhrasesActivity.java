package com.example.japanesetranslations;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, audioResourceId);
                mediaPlayer.setOnCompletionListener(onCompletionListener);
                mediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        sectionWords.add(new Word("Pleased to see you","はじめまして (Hajime mashite)"));
        sectionWords.add(new Word("Good morning","おはよう (Ohayou)"));
        sectionWords.add(new Word("Hello","こんにちは (Konnichiwa)"));
        sectionWords.add(new Word("Hello? (Phone)","もしもし (Moshi moshi)"));
        sectionWords.add(new Word("Good evening","こんばんは (Konbanwa)"));
        sectionWords.add(new Word("Goodnight","おやすみなさい (Oyasumi nasai)"));
        sectionWords.add(new Word("Goodbye","さようなら (Sayōnara)"));
        sectionWords.add(new Word("How’s it going?","おげんきですか (O genki desu ka?)"));
        sectionWords.add(new Word("Are you alright?","だいじょうぶ ですか (Daijōbu desu ka?)"));
        sectionWords.add(new Word("I’m home!","ただいま！ (Tadaima!)"));

        WordAdapter itemsAdapter = new WordAdapter(this, sectionWords, R.color.category_phrases);

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
