#Proyek UTS Pemrograman Berbasis Objek 2

Proyek ini adalah contoh aplikasi sederhana untuk mencatat pemasukan dan pengeluaran menggunakan Java GUI (Swing). Aplikasi ini dibuat sebagai tugas UTS mata kuliah Pemrograman Berorientasi Objek.

#Deskripsi

Aplikasi Keuangan Pribadi digunakan untuk mengelola data transaksi keuangan seperti pemasukan dan pengeluaran. apikasi bwrfungsi  untuk :
Menginput pemasukan dan pengeluaran 

Menyimpan data transaksi

Mengedit dan menghapus data

Menghitung saldo otomatis

Menampilkan transaksi dalam tabel

Mengekspor data ke file TXT dan JSON

Menggunakan konsep OOP lengkap, termasuk Inheritance & Polymorphism.

Aplikasi ini menerapkan seluruh konsep penting OOP.
Aplikasi di buat menggunakan:
Java JDK, NetBeans, Java Swing(GUI) dan FileWriter untuk Export

# Fitur Aplikasi
Tabel Transaksi, Tambah Data, Ubah Data, Hapus Data, Total Saldo, Export TXT, dan Export JSON

#Struktur Project
-Model : Transaksi.java, TransaksiPemasukan.java & TransaksiPengeluaran.java 
-service : TransaksiService.java
-view : KeuanganFrame.java

#Penjelasan Kode
berikut Penjelasan konsep OOP yang diterapkan dalam aplikasi ini:

1.*Class* adalah template obeject atau cetakan pada blueprint.
pada project ini terdapat 3 class Utama:
```bash
public class Transaksi {
   ...
}

public class TransaksiPemasukan{
 ...
}

public class TransaksiPengeluaran{
 ...
}

public class TransaksiService{
  ...
}

public class KeuanganFrame{
 ...
}

2.*Object*adalah instance dari class.

``bash
Transaksi t = new TransaksiPemasukan(tanggal, keterangan, nominal, kategori);

3.*Atribut* adalah variable di dalam class.

``bash

private String tanggal;
private String keterangan;
private double nominal;
private String kategori;

4.*Constructor* adalah di panggil otomatis saat object dibuat.

``bash
public Transaksi(){}

public Transaksi(String tanggal, String keterangan, double nominal, String kategori) {
   this.tanggal = tanggal;
   this.keterangan = keterangan;
   this.nominal = nominal;
   this.kategori = kategori;
}

7.*Method* adalah fungsi/prosedur didalam class.
``bash

public void setTanggal(String tanggal) {
    this.tanggal = tanggal;
}

8.*Encapsulation* adalah Menyembunyikan data menggunakan private lalu membuka akses lewat setter/getter.
``bash

private double nominal;

public double getNominal() { return nominal; }
public void setNominal(double nominal) { this.nominal = nominal;
 }

9.*Inheritance* adalah class anak mewarisi semua artibut & method dari class induk.
``bash
public class TransaksiPemasukan extends Transaksi {

TransaksiPemasukan otomatis punya:tanggal, keterangan, nominal, kategori, dan getter/setter.

10.*Polymorphism*adalah satu variable bis menyimpan berbagai bentuk objek.
``bash
Transaksi t;

if (kategori.equals("Pemasukan")) {
    t = new TransaksiPemasukan(...);
} else {
    t = new TransaksiPengeluaran(...);
}

Transaksi bisa menyimpan objek anak yang berbeda.

@Override
public String getKategori() {
    return "Pemasukan";
}

11.*Abstraction* adalah menyembunyikan kompleksitas dan menampilkan bagian penting saja.
dalam aplikasi ini : Pengguna hanya mengisi input → tanggal, keterangan, nominal, kategori dan Detail cara penyimpanan (ArrayList), cara perhitungan saldo, tidak ditunjukkan ke user.
Class Transaksi berperan sebagai konsep abstraksi dari transaksi apa pun.

12.*Seleksi* digunakan memilih logika tertentu.
``bash
if (kategori.equals("Pemasukan")) {
    ...
} else {
    ...
}

12.*Perulangan* adalah menampilkan semua transaksi di table.
``bash
for (Transaksi t : service.getAll()) {
    model.addRow(...);
}

13.*ArrayList* digunakan untuk menyimpan seluruh Transaksi.
``bash
private ArrayList<Transaksi> list = new ArrayList<>();

14.*Error handling* adalah untuk mengangi kesalahan input.
``bash
try {
    double nominal = Double.parseDouble(txtNominal.getText());
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Nominal harus angka!");
}

15. *Top-Level Container*
adalah komponen GUI terluar : JFrame ,Keuangan Frame.

16.**Intermediate Container
adalah komponen penampung Layout : Jpanel, JscrollPane, GruopLayout.

17.*Atomic Component* 
adalah komponen GUI paling kecil: JtextField, JLabel, JTabel,JButton, JComboBox

#*Implementasi class & Inheritance*
-class induk-Transaksi.java

``bash
public class Transaksi {

    private String tanggal;
    private String keterangan;
    private double nominal;
    private String kategori;

    public Transaksi() {}

    public Transaksi(String tanggal, String keterangan, double nominal, String kategori) {
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.nominal = nominal;
        this.kategori = kategori;
    }

    // getter & setter...
}

-class anak-TransaksiPengeluaran
``bash
public class TransaksiPengeluaran extends Transaksi {

    public TransaksiPengeluaran(String tanggal, String ket, double nominal) {
        setTanggal(tanggal);
        setKeterangan(ket);
        setNominal(nominal);
        setKategori("Pengeluaran");
    }

    @Override
    public String getKategori() {
        return "Pengeluaran";
    }
}

#*TransaksiService-Penyimpanan & Logika Bisnis*
``bash
public class TransaksiService {

    private ArrayList<Transaksi> list = new ArrayList<>();

    public void tambah(Transaksi t) { list.add(t); }

    public void ubah(int index, Transaksi t) { list.set(index, t); }

    public void hapus(int index) { list.remove(index); }

    public ArrayList<Transaksi> getAll() { return list; }

    public double getTotalSaldo() {
        double total = 0;

        for (Transaksi t : list) {
            if (t.getKategori().equals("Pemasukan"))
                total += t.getNominal();
            else
                total -= t.getNominal();
        }

        return total;
    }
}


#*GUI-n KeuanganFrame(Tombol TAMBAH/UBAH/HAPUS)*
-tombol tambah menggunakan inheritance + polymorphism

``bash
private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {

    String tanggal = txtTanggal.getText();
    String ket = txtKeterangan.getText();
    double nominal = Double.parseDouble(txtNominal.getText());
    String kategori = comboKategori.getSelectedItem().toString();

    Transaksi transaksi;

    if (kategori.equals("Pemasukan"))
        transaksi = new TransaksiPemasukan(tanggal, ket, nominal);
    else
        transaksi = new TransaksiPengeluaran(tanggal, ket, nominal);

    service.tambah(transaksi);

    tampilData();
    tampilSaldo();
}

-Tombol Ubah
``bash
private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {
    int row = tabel.getSelectedRow();
    if (row == -1) return;

    String tanggal = txtTanggal.getText();
    String ket = txtKeterangan.getText();
    double nominal = Double.parseDouble(txtNominal.getText());
    String kategori = comboKategori.getSelectedItem().toString();

    Transaksi transaksi;

    if (kategori.equals("Pemasukan"))
        transaksi = new TransaksiPemasukan(tanggal, ket, nominal);
    else
        transaksi = new TransaksiPengeluaran(tanggal, ket, nominal);

    service.ubah(row, transaksi);

    tampilData();
    tampilSaldo();
}

-Tombol hapus
``bash
private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
    int row = tabel.getSelectedRow();
    if (row == -1) return;

    service.hapus(row);

    tampilData();
    tampilSaldo();
}

#*Fitur Export TXT dan JSON* Fitur ini berguna untuk membuat laporan atau backup data keuangan.
Export ke TXt
``bash
private void btnExportTxtActionPerformed(java.awt.event.ActionEvent evt) {                                             
       try{
           
           //membuat file txt baru
           FileWriter fw = new FileWriter("data_keuangan.txt");
           
           //menulis setiap transaksi ke dalam file
           for (Transaksi t : service.getAll()){
               fw.write(
                        t.getTanggal() + " | " +
                                t.getKeterangan() + " | " +
                                t.getNominal() + " | " +
                                t.getKategori() + "\n" );
           }
           //menutup file
           fw.close();
           JOptionPane.showMessageDialog(this, "Export TXT berhasil!");
       }catch (Exception e){
           JOptionPane.showMessageDialog(this, "Gagal export TXT");
       }
    }                                
export ke JSON
``bash
 private void btnExportJsonActionPerformed(java.awt.event.ActionEvent evt) {                                              
       try{
           //membuat file json baru
           FileWriter fw = new FileWriter("data_keuangan.json");
           fw.write("[\n");
           
           int i = 0;
           
           //loop setiap transaksi
           for (Transaksi t : service.getAll()){
               
               //menulis objek json
               fw.write("  {\n");
               fw.write("    \"tanggal\": \"" + t.getTanggal() + "\",\n");
               fw.write("    \"keterangan\": \"" + t.getKeterangan() + "\",\n");
               fw.write("    \"nominal\": \"" + t.getNominal() + "\",\n");
               fw.write("    \"kategori\": \"" + t.getKategori() + "\"\n");
               fw.write("  }");
               
               //tambahkan koma kecuali di item terakhir
               if (i < service.getAll().size() - 1) fw.write(",");
               fw.write("\n");
               i++;
           }
           
           fw.write("]");
           fw.close();
           
           JOptionPane.showMessageDialog(this, "Export JSON berhasil!");
       }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Gagal export JSON");
       }

    }                          

## Pembuat

Nama : Galuh Uliasari
NPM : 2310010117
