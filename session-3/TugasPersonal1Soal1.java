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
  static int latestInventarisIndex = 0;
  static Barang[] inventaris = new Barang[10];

  public static void main(String[] args) {
    inventaris[latestInventarisIndex++] = new Barang("Pensil", 50, 200);
    inventaris[latestInventarisIndex++] = new Barang("Buku", 30, 15000);
    inventaris[latestInventarisIndex++] = new Barang("Penghapus", 20, 500);

    System.out.println("Inventaris Toko:");
    for (int i = 0; i < latestInventarisIndex; i++) {
      Barang barang = inventaris[i];
      System.out.println(i + 1 + ". Nama: " + barang.nama + ", Jumlah Stok: " + barang.jumlahStok + ", Harga: " + barang.harga);
    }
  }
}
