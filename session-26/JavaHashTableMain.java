import java.util.HashMap;

public class JavaHashTableMain {
  public static void main(String[] args) {
    HashMap<Integer, String> hashTable = new HashMap<>(10);

    hashTable.put(1, "Apple");
    hashTable.put(2, "Banana");
    hashTable.put(12, "Orange"); // Collision with key 2
  
    // show
    System.err.println(hashTable);

    // delete
    hashTable.remove(2);
    System.err.println(hashTable);

    // search
    String searchResult = hashTable.get(12);
    if (searchResult != null) {
      System.out.println("Found key 12: " + searchResult);
    } else {
      System.out.println("Key 12 not found.");
    }
  }
}
