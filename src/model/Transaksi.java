/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
//Class ini digunakan untuk menyimpan data 1 transaksi
//setiap transaksi memiliki tanggal,keterangan,nominal dan kategori
public class Transaksi {
    private String tanggal; // Menyimpan tanggal transaksi
    private String keterangan; // penjelasan transaksi(contoh:gaji,beli makan dll)
    private double nominal; // jumlah nominal uang
    private String kategori; // kategori: Pemasukan/Pengeluaran
    
    
    // constructor default WAJIB untuk subclass
    public Transaksi() {}
    
    
    //construktor untuk membuat transaksi baru
    public Transaksi(String tanggal, String keterangan, double nominal, String kategori) {
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.nominal = nominal;
        this.kategori = kategori;
        
        
    }
    
    // getter digunakan untuk mengambil nilai variabel
    
    public String getTanggal() { return tanggal; }
    public String getKeterangan() { return keterangan; }
    public double getNominal() { return nominal; }
    public String getKategori() { return kategori; }
    
    // setter digunakan untuk mengubah nilai variabel
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
    public void setNominal(double nominal) { this.nominal = nominal; }
    public void setKategori(String kategori) { this.kategori = kategori; }
}
