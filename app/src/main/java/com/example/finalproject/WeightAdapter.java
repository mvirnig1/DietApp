package com.example.finalproject;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class WeightAdapter extends ArrayAdapter<Weight> {
    private List<Weight> weightList;
    private Context context;
private String value;
    SharedPreferences sharedpreference;

    WeightAdapter(Context context, int resource, List<Weight> weightList, String value){
        super(context, resource, weightList);
        this.context = context;
        this.weightList = weightList;
this.value = sharedpreference.getString("button_save","");
     }
     public View getView(int position, View convertView, ViewGroup parent){
        Weight weight = weightList.get(position);
        View view;
         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
         view = inflater.inflate(R.layout.weight_list_layout, null);


         TextView tvWeight = view.findViewById(R.id.textViewWeight);
         TextView tvDate = view.findViewById(R.id.textViewDate);
         TextView tvTime = view.findViewById(R.id.textViewTime);
         tvWeight.setText(weight.getWeightLoss());
         tvDate.setText(weight.getDate());
         tvTime.setText(weight.getTime());

         return(view);
     }
}
