class Barang {
  public String nama;
  public int jumlahStok;
  public double harga;

  public Barang(String nama, int jumlahStok, double harga) {
    this.nama = nama;
    this.jumlahStok = jumlahStok;
    this.harga = harga;
  }
}

public class TugasPersonal1Soal1 {
  public static void main(String[] args) {
    Barang[] inventaris = new Barang[10];
    inventaris[0] = new Barang("Pensil", 50, 200);
    inventaris[1] = new Barang("Buku", 30, 15000);
    inventaris[2] = new Barang("Penghapus", 20, 500);

    System.out.println("Inventaris Toko:");
    for (int i = 0; i < 3; i++) {
      Barang barang = inventaris[i];
      System.out.println(i + 1 + ". Nama: " + barang.nama + ", Jumlah Stok: " + barang.jumlahStok + ", Harga: " + barang.harga);
    }
  }
}
