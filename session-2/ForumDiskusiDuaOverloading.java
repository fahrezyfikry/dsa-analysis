class Kalkulator {
    // Method pertama: menjumlahkan dua angka int
    int tambah(int a, int b) {
      return a + b;
    }

    // Method kedua: menjumlahkan tiga angka int
    int tambah(int a, int b, int c) {
      return a + b + c;
    }

    // Method ketiga: menjumlahkan dua angka double
    double tambah(double a, double b) {
      return a + b;
    }
}

public class ForumDiskusiDuaOverloading {
    public static void main(String[] args) {
      Kalkulator calc = new Kalkulator();

      // Memanggil method dengan dua parameter int
      System.out.println("Hasil (int): " + calc.tambah(5, 3));

      // Memanggil method dengan tiga parameter int
      System.out.println("Hasil (3 parameter int): " + calc.tambah(5, 3, 2));

      // Memanggil method dengan dua parameter double
      System.out.println("Hasil (double): " + calc.tambah(5.5, 3.2));
    }
}