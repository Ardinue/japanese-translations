package com.example.japanesetranslations;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int textLayoutColorResourceId;

    public WordAdapter(Context c, ArrayList<Word> wordArrayList) {

        super(c, 0, wordArrayList);
        this.textLayoutColorResourceId = R.color.tan_background;
    }

    public WordAdapter(Context c, ArrayList<Word> wordArrayList, int textLayoutColorResourceId) {

        super(c, 0, wordArrayList);
        this.textLayoutColorResourceId = textLayoutColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        Integer imageId = currentWord.getImageResourceId();
        ImageView japaneseImageView = listItemView.findViewById(R.id.image);

        if(imageId != null) {
            japaneseImageView.setImageResource(imageId);
            japaneseImageView.setVisibility(View.VISIBLE);
        }
        else {
            japaneseImageView.setVisibility(View.GONE);
        }

        LinearLayout textLinearLayout = listItemView.findViewById(R.id.text_layout);
        int textLayoutColor = ContextCompat.getColor(getContext(),textLayoutColorResourceId);
        textLinearLayout.setBackgroundColor(textLayoutColor);

        TextView japaneseTextView = listItemView.findViewById(R.id.japanese_text_view);
        japaneseTextView.setText(currentWord.getJapaneseWord());

        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultWord());

        return listItemView;
    }
}
