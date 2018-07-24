package com.ricardogwill.quicklauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // This changes the specified TextView of the SecondActivity to the text as written in the MainActivity.
        if (getIntent().hasExtra("com.ricardogwill.quicklauncher.SOMETHING")) {
            TextView tv = (TextView) findViewById(R.id.textViewThatChanges);
            String text = getIntent().getExtras().getString("com.ricardogwill.quicklauncher.SOMETHING");
            tv.setText(text);
        }

    }
}
