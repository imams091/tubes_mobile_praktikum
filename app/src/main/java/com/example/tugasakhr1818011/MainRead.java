package com.example.tugasakhr1818011;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Gundam> ListGundam = new ArrayList<Gundam>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListGundam );
        mListView = (ListView) findViewById(R.id.list_gundam);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListGundam.clear();
        List<Gundam> contacts = db.ReadGundam();
        for (Gundam cn : contacts) {
            Gundam judulModel = new Gundam();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_deskripsi(cn.get_deskripsi());
            ListGundam  .add(judulModel);
            if ((ListGundam.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Gundam obj_itemDetails = (Gundam) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Smerk = obj_itemDetails.get_merk();
        String Sharga = obj_itemDetails.get_deskripsi();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Iharga",Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListGundam.clear();
        mListView.setAdapter(adapter_off);
        List<Gundam> contacts = db.ReadGundam();
        for (Gundam cn : contacts) {
            Gundam judulModel = new Gundam();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_deskripsi(cn.get_deskripsi());
            ListGundam.add(judulModel);
            if ((ListGundam.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

