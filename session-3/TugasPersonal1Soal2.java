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

public class TugasPersonal1Soal2 {
  static int latestInventarisIndex = 0;
  static Barang[] inventaris = new Barang[10];

  static int ambilIndexBarang(String nama) {
    for (int i = 0; i < latestInventarisIndex; i++) {
      if (inventaris[i].nama == nama) {
        return i;
      }
    }

    return -1;
  }

  static void updateStok(String nama, int jumlahStok) {
    System.out.println("Masukkan nama barang yang ingin diupdate: " + nama);

    int indexBarang = ambilIndexBarang(nama);
    if (indexBarang == -1) {
      System.out.println("Barang yang dicari tidak tersedia.");
      return;
    }

    inventaris[indexBarang].jumlahStok = jumlahStok;
    System.out.println("Masukkan jumlah stok baru: " + jumlahStok);
    System.out.println("");
    System.out.println("Inventaris setelah diupdate:");
    for (int i = 0; i < 3; i++) {
      Barang barang = inventaris[i];
      System.out.println(i + 1 + ". Nama: " + barang.nama + ", Jumlah Stok: " + barang.jumlahStok + ", Harga: " + barang.harga);
    }
  }

  static void cariBarang(String nama) {
    System.out.println("Masukkan nama barang yang dicari: " + nama);
    System.out.println("Hasil pencarian:");

    int indexBarang = ambilIndexBarang(nama);
    if (indexBarang == -1) {
      System.out.println("Barang yang dicari tidak tersedia.");
      return;
    }

    Barang barang = inventaris[indexBarang];
    System.out.println("Nama: " + barang.nama + ", Jumlah Stok: " + barang.jumlahStok + ", Harga: " + barang.harga);
  }

  public static void main(String[] args) {
    inventaris[latestInventarisIndex++] = new Barang("Pensil", 50, 200);
    inventaris[latestInventarisIndex++] = new Barang("Buku", 30, 15000);
    inventaris[latestInventarisIndex++] = new Barang("Penghapus", 20, 500);
    updateStok("Pensil", 60);
    System.out.println("");
    cariBarang("Buku");
  }
}
