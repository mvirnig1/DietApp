package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import android.widget.ArrayAdapter;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonRemove, buttonDetails;
    WeightDataSource weightDataSource;
    ArrayAdapter<Weight> weightAdapter;
    List<Weight> weightList;
    int positionSelected;
    ListView ListViewWeight;
    SharedPreferences sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightDataSource = new WeightDataSource(this);
        weightDataSource.open();

        ListViewWeight = findViewById(R.id.ListViewWeight);
        weightList = weightDataSource.getAllWeight();
        String value = sharedpreference.getString("button_save","");
        weightAdapter = new WeightAdapter(this, android.R.layout.simple_list_item_single_choice, weightList, value);
        ListViewWeight.setAdapter(weightAdapter);
        ListViewWeight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionSelected = position;
                Log.d("MAIN", "Weight selected at position " + positionSelected);
            }
        });


        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent detailActIntent = new Intent(view.getContext(), AddWeightActivity.class);
                finish();
                startActivity(detailActIntent);
            }
        });

        buttonDetails = findViewById(R.id.buttonDetails);
        buttonDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("MAIN", "onClick for Details");
                Intent detailActIntent = new Intent(view.getContext(), EditDetailsActivity.class);
                detailActIntent.putExtra("Weight", weightList.get(positionSelected));
                finish();
                startActivity(detailActIntent);
            }
        });

        buttonRemove = findViewById(R.id.buttonRemove);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("MAIN", "onClick for Remove");
                Log.d("MAIN", "Remove at position " + positionSelected);
                weightDataSource.deleteWeight(weightList.get(positionSelected));
                weightAdapter.remove( weightList.get(positionSelected) );
                weightAdapter.notifyDataSetChanged();
            }
        });
    }

    protected void onResume() {
        weightDataSource.open();
        Log.d("MAIN", "onResume");
        super.onResume();
    }

    protected void onPause() {
        weightDataSource.close();
        Log.d("MAIN", "onPause");
        super.onPause();
    }
}
