/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/*
 * Class anak kedua
 * Ini juga mewarisi class Transaksi
 */

/**
 *
 * @author ASUS
 */

public class TransaksiPengeluaran extends Transaksi {
    
    public TransaksiPengeluaran(String tanggal, String keterangan, double nominal) {
        setTanggal(tanggal);
        setKeterangan(keterangan);
        setNominal(nominal);
        setKategori("Pengeluaran");
        
    }
    @Override
    public String getKategori(){
        return "Pengeluaran";
    }
}
