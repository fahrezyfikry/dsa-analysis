import java.lang.System;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class ArrayOperations {
  // Deklarasi array dengan ukuran awal 0
  int[] arr = new int[0];

  private void printArray() {
    System.out.print("[");
    // Loop untuk menampilkan setiap elemen array
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i != arr.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public void traverse() {
    System.out.print("Array Traversal: ");
    printArray();
  }

  // Method untuk mencari elemen dalam array
  public void pencarian(int target) {
    System.out.print("Pencarian " + target + " dalam Array: ");
    int index = -1; // Inisialisasi index dengan -1 untuk menunjukkan elemen tidak ditemukan
    // Loop linear search untuk mencari target
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        index = i;
        break;
      }
    }

    // Cek apakah elemen ditemukan atau tidak
    if (index != -1) {
      System.out.println("Ditemukan pada indeks " + index);
    } else {
      System.out.println("Tidak ditemukan");
    }
  }

  // Method untuk menyisipkan elemen baru ke array
  public void penyisipan(int newValue) {
    System.out.print("Array setelah penyisipan elemen " + newValue + ": ");
    // Buat array baru dengan ukuran lebih besar 1
    int[] newArr = new int[arr.length + 1];
    // Copy semua elemen dari array lama ke array baru
    System.arraycopy(arr, 0, newArr, 0, arr.length);
    // Tambahkan elemen baru di akhir
    newArr[arr.length] = newValue;
    arr = newArr;
    pengurutan(); // Urutkan array setelah penyisipan
    printArray();
  }

  // Method untuk menghapus elemen dari array
  public void penghapusan(int target) {
    // Jika array kosong, tidak ada yang perlu dihapus
    if (arr.length == 0) {
      return;
    }

    // Buat array baru dengan ukuran lebih kecil 1
    int[] newArr = new int[arr.length - 1];
    if (newArr.length == 0) {
      arr = new int[0];
      return;
    }

    int index = 0;
    // Copy semua elemen kecuali yang akan dihapus
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != target) {
        newArr[index++] = arr[i];
      }
    }

    arr = newArr;
  }

  // Method untuk mengurutkan array secara ascending
  public void pengurutan() {
    Arrays.sort(arr); // Menggunakan built-in sort dari Java
  }
}

class ArrayListOperations {
  // Deklarasi ArrayList untuk menyimpan Integer
  ArrayList<Integer> arr = new ArrayList<Integer>();

  private void printArrayList() {
    System.out.print("[");
    // Loop untuk menampilkan setiap elemen ArrayList
    for (int i = 0; i < arr.size(); i++) {
      System.out.print(arr.get(i));
      if (i != arr.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public void traverse() {
    System.out.print("ArrayList Traversal: ");
    printArrayList();
  }

  public void pencarian(int target) {
    System.out.print("Pencarian " + target + " dalam ArrayList: ");
    // Menggunakan method indexOf untuk mencari elemen
    int index = arr.indexOf(target);

    if (index != -1) {
      System.out.println("Ditemukan pada indeks " + index);
    } else {
      System.out.println("Tidak ditemukan");
    }
  }

  // Method untuk menyisipkan elemen baru ke ArrayList
  public void penyisipan(int newValue) {
    System.out.print("ArrayList setelah penyisipan elemen " + newValue + ": ");
    // Menambahkan elemen baru
    arr.add(newValue);
    pengurutan(); // Urutkan ArrayList setelah penyisipan
    printArrayList();
  }

  // Method untuk menghapus elemen dari ArrayList
  public void penghapusan(int target) {
    // Menghapus elemen berdasarkan nilai
    arr.remove(Integer.valueOf(target));
  }

  // Method untuk mengurutkan ArrayList secara ascending
  public void pengurutan() {
    Collections.sort(arr); // Menggunakan Collections.sort untuk ArrayList
  }
}

class Comparison {
  ArrayOperations arrayOps = new ArrayOperations();
  ArrayListOperations arrayListOps = new ArrayListOperations();

  Comparison() {
    // Data awal yang akan dimasukkan ke Array dan ArrayList
    int[] initialData = {10, 20, 30, 40, 50};
    // Loop untuk memasukkan data ke kedua struktur data
    for (int value : initialData) {
      arrayOps.penyisipan(value);
      arrayListOps.penyisipan(value);
      System.out.println("");
    }
  }

  public void compareTraversal() {
    // Ukur waktu eksekusi untuk Array
    long startTime = System.nanoTime();
    arrayOps.traverse();
    long endTime = System.nanoTime();
    // Konversi dari nanosecond ke millisecond
    double durationArray = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi traversal pada Array: " + durationArray + " ms\n");

    // Ukur waktu eksekusi untuk ArrayList
    startTime = System.nanoTime();
    arrayListOps.traverse();
    endTime = System.nanoTime();
    double durationArrayList = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi traversal pada ArrayList: " + durationArrayList + " ms");
  }

  public void comparePencarian(int target) {
    // Ukur waktu pencarian untuk Array
    long startTime = System.nanoTime();
    arrayOps.pencarian(target);
    long endTime = System.nanoTime();
    double durationArray = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi pencarian pada Array: " + durationArray + " ms\n");

    startTime = System.nanoTime();
    arrayListOps.pencarian(target);
    endTime = System.nanoTime();
    double durationArrayList = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi pencarian pada ArrayList: " + durationArrayList + " ms");
  }

  public void comparePenyisipan(int newValue) {
    // Ukur waktu penyisipan untuk Array
    long startTime = System.nanoTime();
    arrayOps.penyisipan(newValue);
    long endTime = System.nanoTime();
    double durationArray = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi penyisipan pada Array: " + durationArray + " ms\n");

    startTime = System.nanoTime();
    arrayListOps.penyisipan(newValue);
    endTime = System.nanoTime();
    double durationArrayList = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi penyisipan pada ArrayList: " + durationArrayList + " ms");
  }

  public void comparePenghapusan(int target) {
    // Ukur waktu penghapusan untuk Array
    long startTime = System.nanoTime();
    arrayOps.penghapusan(target);
    long endTime = System.nanoTime();
    double durationArray = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi penghapusan pada Array: " + durationArray + " ms\n");

    startTime = System.nanoTime();
    arrayListOps.penghapusan(target);
    endTime = System.nanoTime();
    double durationArrayList = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi penghapusan pada ArrayList: " + durationArrayList + " ms");
  }

  public void comparePengurutan() {
    // Ukur waktu pengurutan untuk Array
    long startTime = System.nanoTime();
    arrayOps.pengurutan();
    long endTime = System.nanoTime();
    double durationArray = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi pengurutan pada Array: " + durationArray + " ms\n");

    startTime = System.nanoTime();
    arrayListOps.pengurutan();
    endTime = System.nanoTime();
    double durationArrayList = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi pengurutan pada ArrayList: " + durationArrayList + " ms");
  }
}

public class Main {
  public static void main(String[] args) {
    Comparison comparison = new Comparison();

    // Melakukan perbandingan berbagai operasi
    comparison.compareTraversal();
    System.out.println("");
    comparison.comparePencarian(30);
    System.out.println("");
    comparison.comparePenyisipan(25);
    System.out.println("");
    comparison.comparePenghapusan(30);
    System.out.println("");
    comparison.comparePengurutan();
  }
}
