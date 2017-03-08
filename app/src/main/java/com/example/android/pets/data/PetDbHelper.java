package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;
/**
 * Created by Boss on 27/02/2017.
 */
public class PetDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";


    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_ENTRIES =
                "CREATE TABLE " + PetEntry.TABLE_NAME + "(" +
                        PetEntry._ID + " INTEGER PRIMARY KEY, " +
                        PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                        PetEntry.COLUMN_PET_BREED + " TEXT, "+
                        PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "+
                        PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_PETS_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        String SQL_DELETE_PETS_ENTRIES =
                "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_PETS_ENTRIES);
        onCreate(db);
    }

}
