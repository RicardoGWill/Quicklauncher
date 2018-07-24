package com.ricardogwill.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This entire block attempts to launch another Activity WITHIN our own app (= Explicit Intent).
        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                // This line is used only if you choose to use the "value" here to change the TextView in the Second Activity.
                startIntent.putExtra("com.ricardogwill.quicklauncher.SOMETHING", "Hello World!");
                startActivity(startIntent);
            }
        });

        // This entire block attempts to launch another Activity OUTSIDE of our app (= Implicit Intent).
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse(google);

                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToGoogle);
                }
            }
        });

    }

    // Note: This is based on the tutorial by Bill Butterfield here: https://www.youtube.com/watch?v=6ow3L39Wxmg

}
