package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditDetailsActivity extends AppCompatActivity {

        EditText editTextWeight;
        EditText editTextDate;
        EditText editTextTime;
        Button buttonReturn;
        WeightDataSource weightDataSource;
        @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_edit_details);

                Bundle bundle = getIntent().getExtras();
               Weight weight = (Weight)   bundle.getSerializable("Weight");

                editTextWeight = (EditText) findViewById(R.id.editTextWeight);
                editTextDate = (EditText) findViewById(R.id.editTextDate);
                editTextTime = (EditText) findViewById(R.id.editTextTime);

                editTextWeight.setText(weight.getWeightLoss());
                editTextDate.setText(weight.getDate());
                editTextTime.setText(weight.getTime());


                buttonReturn = (Button) findViewById(R.id.buttonReturn);
                buttonReturn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                        finish();
                        startActivity(mainActIntent);
                    }
                });

            }
        }

