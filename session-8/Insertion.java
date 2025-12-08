import java.util.Arrays;

public class Insertion {
  public static int[] append(int[] oldArr, int pos, int newValue) {
    // Menyimpan array hasil penyisipan
    int[] newArr = new int[oldArr.length + 1];
    // Menyalin elemen-elemen sebelum posisi penyisipan
    for (int i = 0; i < pos; i++) {
      newArr[i] = oldArr[i];
    }

    // Menyisipkan elemen baru
    newArr[pos] = newValue;

    // Menyalin elemen-elemen setelah posisi penyisipan
    for (int i = pos; i < oldArr.length; i++) {
      newArr[i + 1] = oldArr[i];
    }

    return newArr;
  }

  public static void main(String[] args) {
    int newValue = 25;
    int pos = 2;

    int[] angka = {10, 20, 30, 40, 50};
    System.out.println("Array sebelum penyisipan: " + Arrays.toString(angka));

    angka = append(angka, pos, newValue);
    System.out.println("Array setelah penyisipan: " + Arrays.toString(angka));
  }
}
