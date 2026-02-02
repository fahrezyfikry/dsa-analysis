import java.util.LinkedList;

class HashTableX {
  private LinkedList<Entry>[] table;
  private int size;

  static class Entry {
    int key;
    String value;

    Entry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  HashTableX(int size) {
    this.size = size;
    table = new LinkedList[size];

    for (int i = 0; i < size; i++) { // inisiasi index
      table[i] = new LinkedList<>();
    }
  }

  // hashFunction
  private int hashFunction(int key) {
    return key % size;
  }

  private int hashFunction2(int key) {
    return 7 - (key % 7);
  }

  // operasi utama hash table
  // 1. insert
  public void insert(int key, String value) {
    int index = hashFunction(key); // hitung index beradasarkan key inputan user
    // Collision handling
    while (table[index] != null) {
      index = (index + 1) % size; // linear probing
    }
    table[index] = new LinkedList<>();
    table[index].add(new Entry(key, value)); // add entry LL
  }

  public void insertDoubleHashing(int key, String value) {
    int index = hashFunction(key);
    int stepSize = hashFunction2(key);

    // Collision handling with double hashing
    while (table[index] != null) {
      index = (index + stepSize) % size;
    }
    table[index] = new LinkedList<>();
    table[index].add(new Entry(key, value)); // add entry LL
  }

  // 2. display
  public void display() {
    for (int i = 0; i < size; i++) {
      System.out.print("Index " + i + ": ");
      for (Entry entry : table[i]) {
        System.out.print("(Key: " + entry.key + ", Value: " + entry.value + ") -> ");
      }
      System.out.println("null");
    }
  }

  // 3. search
  public String search(int key) {
    int index = hashFunction(key);
    for (Entry entry : table[index]) {
      if (entry.key == key) {
        return entry.value;
      }
    }

    return null; // not found
  }

  // 4. delete
  public void delete(int key) {
    int index = hashFunction(key);
    table[index].removeIf(entry -> entry.key == key);
  }

  // 5. update
  public void update(int key, String newValue) {
    int index = hashFunction(key);
    for (Entry entry : table[index]) {
      if (entry.key == key) {
        entry.value = newValue;
        return;
      }
    }

    System.out.println("Key " + key + " not found for update.");
  }
}

public class HashTableMain {
  public static void main(String[] args) {
    HashTableX hashTable = new HashTableX(10);

    hashTable.insert(1, "Apple");
    hashTable.insert(2, "Banana");
    hashTable.insert(12, "Orange"); // Collision with key 2
    hashTable.insert(22, "Grapes"); // Collision with key 2 and 12

    hashTable.display();
    System.out.println();

    String searchResult = hashTable.search(12);
    if (searchResult != null) {
      System.out.println("Found key 12: " + searchResult);
    } else {
      System.out.println("Key 12 not found.");
    }

    hashTable.update(2, "Mango");
    System.out.println("\nAfter updating key 2:");
    hashTable.display();

    hashTable.delete(2);

    System.out.println("\nAfter deleting key 2:");
    hashTable.display();
  }
}