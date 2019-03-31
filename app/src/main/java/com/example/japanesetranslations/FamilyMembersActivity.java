package com.example.japanesetranslations;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

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
                mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, audioResourceId);
                mediaPlayer.setOnCompletionListener(onCompletionListener);
                mediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        sectionWords.add(new Word("grandfather","そふ (sofu)", R.drawable.family_grandfather));
        sectionWords.add(new Word("grandmother","そぼ (sobo)", R.drawable.family_grandmother));
        sectionWords.add(new Word("father","ちち (chichi)", R.drawable.family_father));
        sectionWords.add(new Word("mother","はは (haha)", R.drawable.family_mother));
        sectionWords.add(new Word("son","むすこ (musuko)", R.drawable.family_son));
        sectionWords.add(new Word("daughter","むすめ (musume)", R.drawable.family_daughter));
        sectionWords.add(new Word("older brother","あに (ani)", R.drawable.family_older_brother));
        sectionWords.add(new Word("older sister","あね (ane)", R.drawable.family_older_sister));
        sectionWords.add(new Word("younger brother","おとうと (otouto)", R.drawable.family_younger_brother));
        sectionWords.add(new Word("younger sister","いもうと (imouto)", R.drawable.family_younger_sister));

        WordAdapter itemsAdapter = new WordAdapter(this, sectionWords, R.color.category_family);

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
