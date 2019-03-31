package com.example.japanesetranslations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text_view_numbers).setOnClickListener(numbersOnClickListener());
        findViewById(R.id.text_view_family).setOnClickListener(familyOnClickListener());
        // findViewById(R.id.text_view_colors).setOnClickListener(colorsOnClickListener());
        findViewById(R.id.text_view_phrases).setOnClickListener(phrasesOnClickListener());
    }

    private View.OnClickListener numbersOnClickListener() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), NumbersActivity.class);
                    startActivity(intent);
            }
        };
    }

    private View.OnClickListener familyOnClickListener() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FamilyMembersActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener colorsOnClickListener() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorsActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener phrasesOnClickListener() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhrasesActivity.class);
                startActivity(intent);
            }
        };
    }
}
