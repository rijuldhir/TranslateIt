/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.miwok.R.id.numbers;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        TextView number = (TextView) findViewById(R.id.numbers);

        number.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Hi Rijul",Toast.LENGTH_LONG);
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });
    }

    public void OpenFamily(View view) {
        Intent intent = new Intent(getApplicationContext(), FamilyActivity.class);
        //intent.putExtra("Variable name", "Value you want to pass");
        startActivity(intent);
    }

    public void OpenColors(View view) {
        Intent intent = new Intent(getApplicationContext(), ColorsActivity.class);
        //intent.putExtra("Variable name", "Value you want to pass");
        startActivity(intent);
    }
    public void OpenPhrases(View view) {
        Intent intent = new Intent(getApplicationContext(), PhrasesActivity.class);
        //intent.putExtra("Variable name", "Value you want to pass");
        startActivity(intent);
    }

}
