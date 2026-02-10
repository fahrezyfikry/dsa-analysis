import java.util.Stack;

class Aksi {
  private final String deskripsiAksi;

  public Aksi(String deskripsiAksi) {
    if (deskripsiAksi == null) {
      throw new IllegalArgumentException("deskripsiAksi tidak boleh null");
    }
    this.deskripsiAksi = deskripsiAksi;
  }

  public String getDeskripsiAksi() {
    return deskripsiAksi;
  }

  @Override
  public String toString() {
    return deskripsiAksi;
  }
}

class ManajerUndo {
  private final Stack<Aksi> stack = new Stack<>();

  public void tambahAksi(Aksi aksi) {
    if (aksi == null) {
      throw new IllegalArgumentException("aksi tidak boleh null");
    }
    stack.push(aksi);
  }

  public Aksi batalkanAksi() {
    if (stack.isEmpty()) {
      return null;
    }
    return stack.pop();
  }

  public Aksi lihatAksiTerakhir() {
    if (stack.isEmpty()) {
      return null;
    }
    return stack.peek();
  }

  public boolean apakahKosong() {
    return stack.isEmpty();
  }
}

public class Main {
  public static void main(String[] args) {
    ManajerUndo manager = new ManajerUndo();

    Aksi aksi1 = new Aksi("A");
    manager.tambahAksi(aksi1);
    System.out.println("Memasukkan aksi: " + aksi1);

    Aksi aksi2 = new Aksi("<b>A</b>");
    manager.tambahAksi(aksi2);
    System.out.println("Memasukkan aksi: " + aksi2);

    Aksi aksi3 = new Aksi("<b>A</b>1");
    manager.tambahAksi(aksi3);
    System.out.println("Memasukkan aksi: " + aksi3);

    System.out.println();
    System.out.println("Aksi terakhir: " + manager.lihatAksiTerakhir());

    System.out.println();
    System.out.println("Mulai membatalkan aksi satu per satu:");
    while (!manager.apakahKosong()) {
      System.out.println("Membatalkan: " + manager.batalkanAksi());
    }

    Aksi aksiTerakhir = manager.batalkanAksi();
    System.out.println();
    System.out.println("Mencoba batalkan aksi lagi: "
        + (aksiTerakhir == null ? "Tidak ada aksi yang bisa dibatalkan." : aksiTerakhir));
  }
}
