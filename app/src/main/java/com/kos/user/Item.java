package com.kos.user;

/**
 * Created by ACER on 8/29/2016.
 */
public class Item {
    String id_pemilik;
    String nama_pemilik, alamat, fasilitas,harga,kategori,foto,no_hp,jumlah_kamar;

    public Item(String nama_pemilik, String alamat,String fasilitas,String kategori, String id_pemilik, String harga,String foto,String no_hp,String jumlah_kamar){
        this.nama_pemilik = nama_pemilik;
        this.alamat = alamat;
        this.fasilitas = fasilitas;
        this.id_pemilik = id_pemilik;
        this.harga = harga;
        this.kategori = kategori;
        this.foto = foto;
        this.jumlah_kamar = jumlah_kamar;
        this.no_hp = no_hp;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public String getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(String id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getJumlah_kamar() {
        return jumlah_kamar;
    }

    public void setJumlah_kamar(String jumlah_kamar) {
        this.jumlah_kamar = jumlah_kamar;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Item(){
    }
}
