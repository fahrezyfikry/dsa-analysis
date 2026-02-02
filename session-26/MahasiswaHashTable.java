import java.util.LinkedList;

public class MahasiswaHashTable {
	private static class Student {
		int id;
		String name;

		Student(int id, String name) {
			this.id = id;
			this.name = name;
		}

    @Override
		public String toString() {
			return "(id: " + id + ", name: " + name + ")";
		}
	}

	private LinkedList<Student>[] table;
	private int size;

	public MahasiswaHashTable(int size) {
		this.size = size;
		table = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<>();
		}
	}

	private int hashFunction(int id) {
		return Math.abs(id) % size;
	}

	public void insert(int id, String name) {
		int idx = hashFunction(id);
		for (Student s : table[idx]) {
			if (s.id == id) {
				System.out.println("ID " + id + " already exists. Use update() to change the name.");
				return;
			}
		}
		table[idx].add(new Student(id, name));
	}

	public void update(int id, String newName) {
		int idx = hashFunction(id);
		for (Student s : table[idx]) {
			if (s.id == id) {
				s.name = newName;
				return;
			}
		}
		System.out.println("ID " + id + " not found for update.");
	}

	public void delete(int id) {
		int idx = hashFunction(id);
		boolean removed = table[idx].removeIf(s -> s.id == id);
		if (!removed) {
			System.out.println("ID " + id + " not found for delete.");
		}
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print("Index " + i + ": ");
			for (Student s : table[i]) {
				System.out.print(s + " -> ");
			}
			System.out.println("null");
		}
	}

public static void main(String[] args) {
		MahasiswaHashTable ht = new MahasiswaHashTable(10);

		ht.insert(1, "A");
		ht.insert(2, "B");
		ht.insert(12, "C"); // collision with 2

		System.out.println("Initial table:");
		ht.show();

		ht.update(2, "B Update");
		System.out.println("\nAfter update:");
		ht.show();

		ht.delete(2);
		System.out.println("\nAfter delete:");
		ht.show();
	}
}
