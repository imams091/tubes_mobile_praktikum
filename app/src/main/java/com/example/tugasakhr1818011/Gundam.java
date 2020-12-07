package com.example.tugasakhr1818011;

public class Gundam {
    private String _id, _nama, _merk, _deskripsi;
    public Gundam(String id, String nama, String merk, String deskripsi) {
        this._id = id;
        this._nama = nama;
        this._merk = merk;
        this._deskripsi=deskripsi;
    }
    public Gundam() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_merk() {
        return _merk;
    }
    public void set_merk(String _merk) {
        this._merk = _merk;
    }

    public String get_deskripsi() {
        return _deskripsi;
    }
    public void set_deskripsi(String _harga) {
        this._deskripsi = _harga;
    }
}

