import java.util.LinkedList;
import java.util.Iterator;

class HashTable {
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

  @SuppressWarnings("unchecked")
  HashTable(int size) {
    this.size = size;
    table = new LinkedList[size];
    for (int i = 0; i < size; i++) {
      table[i] = new LinkedList<>();
    }
  }

  private int hashFunction(int key) {
    return key % size;
  }

  void insert(int key, String value) {
    int index = hashFunction(key);
    table[index].add(new Entry(key, value));
  }

  void display() {
    for (int i = 0; i < size; i++) {
      System.out.print("Index " + i + ": ");
      for (Entry entry : table[i]) {
        System.out.print("(NIM: " + entry.key + ", Nama: " +
            entry.value + ") -> ");
      }
      System.out.println("null");
    }
  }

  void update(int key, String newValue) {
    int index = hashFunction(key);
    for (Entry entry : table[index]) {
      if (entry.key == key) {
        entry.value = newValue;
        return;
      }
    }
    System.out.println("Key " + key + " not found.");
  }

  void delete(int key) {
    int index = hashFunction(key);
    Iterator<Entry> iterator = table[index].iterator();
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      if (entry.key == key) {
        iterator.remove();
        return;
      }
    }
    System.out.println("Key " + key + " not found.");
  }
}

// Program utama
public class HashTableMahasiswa {
  public static void main(String[] args) {
    HashTable hashTable = new HashTable(10);
    hashTable.insert(20231001, "John Doe");
    hashTable.insert(20231002, "Jane Smith");

    System.out.println("Sebelum update dan delete:");
    hashTable.display();

    hashTable.update(20231001, "John Updated");
    hashTable.delete(20231002);

    System.out.println("Setelah update dan delete:");
    hashTable.display();
  }
}
