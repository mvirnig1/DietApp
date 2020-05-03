package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class AddWeightActivity extends AppCompatActivity {

    Button buttonSave;
    EditText editTextWeight;
    EditText editTextDate;
    EditText editTextTime;
    WeightDataSource weightDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weight);

        weightDataSource = new WeightDataSource(this);
        weightDataSource.open();

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);

        buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String weight = editTextWeight.getText().toString();
                String date= editTextDate.getText().toString();
                String time = editTextTime.getText().toString();
                weightDataSource.createWeight(weight, date, time);
                Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });


    }
}
