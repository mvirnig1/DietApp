package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditDetailsActivity extends AppCompatActivity {
    SharedPreferences sharedpreference;
        EditText editTextWeight;
        EditText editTextDate;
        EditText editTextTime;
        Button buttonSave;
    Button buttonReturn;
    WeightDataSource weightDataSource;
        @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_edit_details);

            sharedpreference= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

                Bundle bundle = getIntent().getExtras();
               Weight weight = (Weight)   bundle.getSerializable("Weight");

                editTextWeight = findViewById(R.id.editTextWeight);
                editTextDate = findViewById(R.id.editTextDate);
                editTextTime = findViewById(R.id.editTextTime);

                editTextWeight.setText(weight.getWeightLoss());
                editTextDate.setText(weight.getDate());
                editTextTime.setText(weight.getTime());


                buttonReturn = findViewById(R.id.buttonReturn);
                buttonReturn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                        finish();
                        startActivity(mainActIntent);
                    }
                });

            buttonSave = findViewById(R.id.buttonSave);
            buttonSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    sharedpreference.edit().putString("button_save",buttonSave.getText().toString()).apply();
                    Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                    finish();
                    startActivity(mainActIntent);
                }
            });
            }
        }

