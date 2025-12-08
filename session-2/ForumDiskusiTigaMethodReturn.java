class BangunRuang {
    static int luasPersegi(int sisi){
      return sisi * sisi;
    }

    static int luasKubus(int sisi){
      return 6 * luasPersegi(sisi);
    }
}

public class ForumDiskusiTigaMethodReturn {
  static void Cetak(){
    System.out.print("I ");
  }

  public static void main(String[] args) {
    Cetak();
    System.out.println("JAVA ");
    System.out.println("Luas Persegi dengan panjang sisi 5 adalah " + BangunRuang.luasPersegi(5));
    System.out.println("Luas Kubus dengan panjang sisi 12 adalah " + BangunRuang.luasKubus(12));
  }
}