/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/*
 * Class anak (subclass)
 * Mewarisi class Transaksi
 * Ini adalah contoh INHERITANCE
 */
/**
 *
 * @author ASUS
 */
public class TransaksiPemasukan extends Transaksi {
    
    public TransaksiPemasukan(String tanggal, String keterangan, double nominal){
       setTanggal(tanggal);
       setKeterangan(keterangan);
       setNominal(nominal);
       setKategori("Pemasukan");

    }
    
    // Override method untuk memberi perilaku khusus
    @Override
    public String getKategori(){
        return "Pemasukan";
    }
}
