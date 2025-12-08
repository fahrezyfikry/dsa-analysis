import java.util.Arrays;

public class Deletion {
  public static int[] delete(int[] oldArr, int pos) {
    // Array hasil setelah penghapusan
    int[] newArr = new int[oldArr.length - 1];

    // Menyalin elemen-elemen sebelum posisi penghapusan
    for (int i = 0; i < pos; i++) {
      newArr[i] = oldArr[i];
    }

    // Menyalin elemen-elemen setelah posisi penghapusan
    for (int i = pos; i < oldArr.length - 1; i++) {
      newArr[i] = oldArr[i + 1];
    }

    return newArr;
  }

  public static void main(String[] args) {
    int pos = 2; // Menghapus elemen pada indeks ke-2

    int[] angka = {10, 20, 30, 40, 50};
    System.out.println("Array sebelum penghapusan: " + Arrays.toString(angka));

    int[] hasil = delete(angka, pos);
    System.out.println("Array setelah penghapusan: " + Arrays.toString(hasil));
  }
}
