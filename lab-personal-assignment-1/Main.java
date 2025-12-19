import java.lang.System;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class ArrayOperations {
  int[] arr = new int[0];

  private void printArray() {
    System.out.print("[");
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

  public void pencarian(int target) {
    System.out.print("Pencarian " + target + " dalam Array: ");
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        index = i;
        break;
      }
    }

    if (index != -1) {
      System.out.println("Ditemukan pada indeks " + index);
    } else {
      System.out.println("Tidak ditemukan");
    }
  }

  public void penyisipan(int newValue) {
    System.out.print("Array setelah penyisipan elemen " + newValue + ": ");
    int[] newArr = new int[arr.length + 1];
    System.arraycopy(arr, 0, newArr, 0, arr.length);
    newArr[arr.length] = newValue;
    arr = newArr;
    pengurutan();
    printArray();
  }

  public void penghapusan(int target) {
    if (arr.length == 0) {
      return;
    }

    int[] newArr = new int[arr.length - 1];
    if (newArr.length == 0) {
      arr = new int[0];
      return;
    }

    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != target) {
        newArr[index++] = arr[i];
      }
    }

    arr = newArr;
  }

  public void pengurutan() {
    Arrays.sort(arr);
  }
}

class ArrayListOperations {
  ArrayList<Integer> arr = new ArrayList<Integer>();

  private void printArrayList() {
    System.out.print("[");
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
    int index = arr.indexOf(target);

    if (index != -1) {
      System.out.println("Ditemukan pada indeks " + index);
    } else {
      System.out.println("Tidak ditemukan");
    }
  }

  public void penyisipan(int newValue) {
    System.out.print("ArrayList setelah penyisipan elemen " + newValue + ": ");
    arr.add(newValue);
    pengurutan();
    printArrayList();
  }

  public void penghapusan(int target) {
    arr.remove(Integer.valueOf(target));
  }

  public void pengurutan() {
    Collections.sort(arr);
  }
}

class Comparison {
  ArrayOperations arrayOps = new ArrayOperations();
  ArrayListOperations arrayListOps = new ArrayListOperations();

  Comparison() {
    int[] initialData = {10, 20, 30, 40, 50};
    for (int value : initialData) {
      arrayOps.penyisipan(value);
      arrayListOps.penyisipan(value);
      System.out.println("");
    }
  }

  public void compareTraversal() {
    long startTime = System.nanoTime();
    arrayOps.traverse();
    long endTime = System.nanoTime();
    double durationArray = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi traversal pada Array: " + durationArray + " ms\n");

    startTime = System.nanoTime();
    arrayListOps.traverse();
    endTime = System.nanoTime();
    double durationArrayList = (endTime - startTime) / 1_000_000.0;
    System.out.println("Waktu eksekusi traversal pada ArrayList: " + durationArrayList + " ms");
  }

  public void comparePencarian(int target) {
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
