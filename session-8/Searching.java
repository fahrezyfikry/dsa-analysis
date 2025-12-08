import java.util.Arrays;

public class Searching {
  public static int findLinear(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }

    return -1;
  }

  public static void bubbleSort(int[] arr) {
    // Bubble sort
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length - 1; j++) {
        int a = arr[j];
        int b = arr[j+1];
        if (a > b) {
          arr[j+1] = a;
          arr[j] = b;
        }
      }
    }
  }

  public static int findBinary(int[] arr, int target) {
    if (arr.length == 0) {
      return -1;
    }

    int low = 0;
    int height = arr.length - 1;
    while (low <= height) {
      int mid = ((height - low) / 2) + low;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else if (arr[mid] > target) {
        height = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] angka = {3, 8, 12, 5, 7};
    int target = 8;

    int linearIndex = findLinear(angka, target);
    System.out.println("Elemen " + target + " ditemukan pada indeks " + linearIndex);

    int[] sortedAngka = {3, 8, 12, 5, 7};
    bubbleSort(sortedAngka);
    System.out.println("Array setelah diurutkan: " + Arrays.toString(sortedAngka));

    int linearBinary = findBinary(sortedAngka, target);
    System.out.println("Elemen " + target + " ditemukan pada indeks " + linearBinary);
  }
}
