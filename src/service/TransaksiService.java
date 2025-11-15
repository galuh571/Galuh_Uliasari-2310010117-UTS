/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import model.Transaksi;

//class ini berfungsi sebagai tempat menyimpan dan mengolah data transaksi
public class TransaksiService {
    
    //Menampung semua transaksi dalam bentuk list (array dinamis)
    private ArrayList<Transaksi> list = new ArrayList<>();
    
    //menambah transaksi baru ke list
    public void tambah(Transaksi t){
        list.add(t);
    }
    
    //mengubah data pada posisi tertentu
    public void ubah(int index, Transaksi t){
        list.set(index, t);
    }
    
    //menghapus data transaksi berdasarkan index baris
     public void hapus(int index){
         list.remove(index);
     }
     
     //mengambil semua data untuk di tampilkan di tabel
     public ArrayList<Transaksi> getAll(){
         return list;
   }
     
     //menghitung total saldo berdasarkan pemasukan dan pengeluaran
     public double getTotalSaldo(){
         double total = 0;
         
         
         for (Transaksi t : list){
             //jika pemasukan(tambah saldo)
             if (t.getKategori().equals("Pemasukan")) total += t.getNominal();
             
             else
                 total -= t.getNominal();// jika pengurangi(kurangi saldo)
         }
         
         return  total;
     }
}
