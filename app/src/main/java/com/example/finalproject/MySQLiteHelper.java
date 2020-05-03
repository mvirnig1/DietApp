package com.example.finalproject;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySQLiteHelper extends SQLiteOpenHelper{
    static final String TABLE_WEIGHT = "Weight";

    static final String COLUMN_ID = "_id";
    static final String COLUMN_WEIGHT = "weightLoss";
    static final String COLUMN_DATE = "date";
    static final String COLUMN_TIME = "time";

    private static final String DATABASE_NAME = "weight.db";
    private static final int DATABASE_VERSION = 101;

    private static final String DATABASE_CREATE = "create table " + TABLE_WEIGHT +
            "(" + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_WEIGHT +
            " TEXT not null, " + COLUMN_DATE + " TEXT, " + COLUMN_TIME + " TEXT" + ");";

    private static MySQLiteHelper sInstance;
    static synchronized MySQLiteHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MySQLiteHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("MySQLiteHelper", "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEIGHT);
        onCreate(db);
    }
}
