package com.example.finalproject;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.Date;

public class MySQLiteHelper extends SQLiteOpenHelper{
    public static final String TABLE_WEIGHT = "Weight";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WEIGHT = "weightLoss";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";

    public static final String DATABASE_NAME = "weight.db";
    private static final int DATABASE_VERSION = 101;

    private static final String DATABASE_CREATE = "create table " + TABLE_WEIGHT +
            "(" + COLUMN_ID + "integer primary key autoincrement, " + COLUMN_WEIGHT +
            " TEXT not null, " + COLUMN_DATE + "TEXT, " + COLUMN_TIME + "TEXT" + ");";

    private static MySQLiteHelper sInstance;
    public static synchronized MySQLiteHelper getInstance(Context context) {
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
