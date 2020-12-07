package com.example.tugasakhr1818011;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_Gundam";
    private static final String tb_gundam = "tb_gundam";
    private static final String tb_gundam_id = "id";
    private static final String tb_gundam_nama = "nama";
    private static final String tb_gundam_merk = "merk";
    private static final String tb_gundam_desc = "deskripsi";
    private static final String CREATE_TABLE_GUNDAM = "CREATE TABLE " +
            tb_gundam + "("
            + tb_gundam_id + " INTEGER PRIMARY KEY ,"
            + tb_gundam_nama + " TEXT,"
            + tb_gundam_merk + " TEXT,"
            + tb_gundam_desc + " TEXT" + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GUNDAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateGundam (Gundam mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_gundam_id, mdNotif.get_id());
        values.put(tb_gundam_nama, mdNotif.get_nama());
        values.put(tb_gundam_merk, mdNotif.get_merk());
        values.put(tb_gundam_desc, mdNotif.get_deskripsi());
        db.insert(tb_gundam, null, values);
        db.close();
    }

    public List<Gundam> ReadGundam() {
        List<Gundam> judulModelList = new ArrayList<Gundam>();
        String selectQuery = "SELECT * FROM " + tb_gundam;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Gundam mdKontak = new Gundam();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_merk(cursor.getString(2));
                mdKontak.set_deskripsi(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateGundam (Gundam mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_gundam_nama, mdNotif.get_nama());
        values.put(tb_gundam_merk, mdNotif.get_merk());
        values.put(tb_gundam_desc, mdNotif.get_deskripsi());
        return db.update(tb_gundam, values, tb_gundam_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteGundam (Gundam mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_gundam, tb_gundam_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
