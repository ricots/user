package com.kos.user;

/**
 * Created by ACER on 2016-02-27.
 */
public class config {
    //String URL_CARI = config.PAKET + detail_temp.getText().toString() +"&harga="+harga.getText.toString();
    //http://kosserver.16mb.com/cari_kos.php?harga=400000&kategori=perempuan&fasilitas=kasur+almari+tv
    public static final String LIST_KOST = "http://kosserver.16mb.com/list_kos.php";
    public static final String CARI_KOST = "http://kosserver.16mb.com/cari_kos.php?harga=";
    public static final String TAG_id = "id_pemilik";
    public static final String KEY_nama_pemilik = "nama_pemilik";
    public static final String KEY_alamat = "alamat";
    public static final String KEY_harga = "harga";
    public static final String KEY_fasilitas = "fasilitas";
    public static final String KEY_kategori = "kategori";
    public static final String KEY_GAMBAR = "foto";
    public static final String KEY_NO_HP = "no_hp";
    public static final String KEY_jml_kamar = "jumlah_kamar";


    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "npm";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}

