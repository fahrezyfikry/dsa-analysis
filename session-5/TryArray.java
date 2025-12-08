import java.util.ArrayList;

class ArrayHandler {
  private ArrayList<Integer> numbers;

  public ArrayHandler() {
    numbers = new ArrayList<>(10);
    for (int i = 0; i < 12; i++) {
      numbers.add(i);
    }
  }

  public void tampilkanArray() {
    // Menampilkan elemen array
    for (int num : numbers) {
    System.out.println(num);
    }
  }

  public void cariNumber(int target) {
    int i;
    for (i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) == target) {
        System.out.println("Elem " + target + " ditemukan di index " + i);
        return;
      }
    }
  }

  public void deleteNumber(int target) {
    numbers.remove(Integer.valueOf(target));
    System.out.println("Array setelah dihapus:\n");
    tampilkanArray();
  }

  public void addMemory() {
    numbers.ensureCapacity(20);
    System.out.println("Array sudah ditambahkan menjadi 20 elemen");
  }

  public void trimArr() {
    numbers.trimToSize();
    System.out.println("Array sudah menyesuaikan kapasitas dengan jumlah elemen yang ada");
  }

  public void cekKapasitas() {
    System.out.println("Kapasitas internal saat ini " + numbers.size());
  }
}

public class TryArray {
  public static void main(String[] args) {
    ArrayHandler handler = new ArrayHandler();
    handler.tampilkanArray();
    handler.cariNumber(3);
    handler.deleteNumber(3);
    handler.addMemory();
    handler.trimArr();
    handler.cekKapasitas();
  }
}

// class ArrayExample {
//   int[] numbers = {10, 20, 30, 40, 50};

//   public void tampilkanArray() {
//     // Menampilkan elemen array
//     for (int num : numbers) {
//     System.out.println(num);
//     }
//   }
// }

// public class TryArray {
//   public static void main(String[] args) {
//     ArrayExample arrayExample = new ArrayExample();
//     arrayExample.tampilkanArray();
//   }
// }
