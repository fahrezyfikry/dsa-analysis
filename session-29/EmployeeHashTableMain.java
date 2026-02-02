import java.util.LinkedList;

class EmployeeHashTable {
  private LinkedList<Entry>[] table;
  private int size;

  static class Entry {
    int id;
    String name;

    Entry(int id, String name) {
      this.id = id;
      this.name = name;
    }
  }

  @SuppressWarnings("unchecked")
  EmployeeHashTable(int size) {
    this.size = size;
    table = new LinkedList[size];
    for (int i = 0; i < size; i++) {
      table[i] = new LinkedList<>();
    }
  }

  private int hashFunction(int id) {
    return id % size;
  }

  void insert(int id, String name) {
    int index = hashFunction(id);
    table[index].add(new Entry(id, name));
  }

  void display() {
    for (int i = 0; i < size; i++) {
      System.out.print("Index " + i + ": ");
      for (Entry entry : table[i]) {
        System.out.print("(ID: " + entry.id + ", Nama: " + entry.name
            + ") -> ");
      }
      System.out.println("null");
    }
  }

  int getTotalEmployees() {
    int total = 0;
    for (int i = 0; i < size; i++) {
      total += table[i].size();
    }
    return total;
  }
}

// Program utama
public class EmployeeHashTableMain {
  public static void main(String[] args) {
    EmployeeHashTable employeeTable = new EmployeeHashTable(10);
    employeeTable.insert(101, "Budi Santoso");
    employeeTable.insert(102, "Dewi Lestari");
    System.out.println("Data karyawan:");
    employeeTable.display();

    System.out.println("Total karyawan: " + employeeTable.getTotalEmployees());
  }
}