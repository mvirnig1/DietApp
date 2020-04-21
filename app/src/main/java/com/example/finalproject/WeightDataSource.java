package com.example.finalproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class WeightDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public WeightDataSource(Context context) {
        dbHelper = MySQLiteHelper.getInstance(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Weight createWeight(String weightLoss, String date, String time) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_WEIGHT, weightLoss);
        values.put(MySQLiteHelper.COLUMN_DATE, date);
        values.put(MySQLiteHelper.COLUMN_TIME, time);

        long insertId = database.insert(MySQLiteHelper.TABLE_WEIGHT, null, values);
        Weight newWeight = new Weight(insertId, weightLoss, date, time);
        return newWeight;
    }

    public void deleteWeight(Weight weight) {
        long id = weight.getId();
        System.out.println("Weight deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_WEIGHT, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Weight> getAllWeight() {
        List<Weight> weightList = new ArrayList<Weight>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_WEIGHT,       //Modified to return all database fields
                null, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Weight weight = cursorToWeight(cursor);
            weightList.add(weight);
            cursor.moveToNext();
        }
        return weightList;
    }

    private Weight cursorToWeight(Cursor cursor) {
       Weight weight = new Weight();
        weight.setId(cursor.getLong(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID)));
        weight.setWeightLoss(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_WEIGHT)));
        weight.setDate(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DATE)));
        weight.setTime(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_TIME)));

        return weight;
    }
}

