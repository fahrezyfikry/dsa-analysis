import java.util.LinkedList;

public class KaryawanHashTable {
	private static class Employee {
		String empId;
		String name;

		Employee(String empId, String name) {
			this.empId = empId;
			this.name = name;
		}

		@Override
		public String toString() {
			return "(empId: " + empId + ", name: " + name + ")";
		}
	}

	private LinkedList<Employee>[] table;
	private int size;

	public KaryawanHashTable(int size) {
		this.size = size;
		table = (LinkedList<Employee>[]) new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<>();
		}
	}

	private int hashFunction(String empId) {
		return Math.abs(empId.hashCode()) % size;
	}

	public void insert(String empId, String name) {
		int idx = hashFunction(empId);
		for (Employee e : table[idx]) {
			if (e.empId.equals(empId)) {
				System.out.println("Employee ID " + empId + " already exists. Use update() to change the name.");
				return;
			}
		}
		table[idx].add(new Employee(empId, name));
	}

	public void update(String empId, String newName) {
		int idx = hashFunction(empId);
		for (Employee e : table[idx]) {
			if (e.empId.equals(empId)) {
				e.name = newName;
				return;
			}
		}
		System.out.println("Employee ID " + empId + " not found for update.");
	}

	public void delete(String empId) {
		int idx = hashFunction(empId);
		boolean removed = table[idx].removeIf(e -> e.empId.equals(empId));
		if (!removed) {
			System.out.println("Employee ID " + empId + " not found for delete.");
		}
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print("Index " + i + ": ");
			for (Employee e : table[i]) {
				System.out.print(e + " -> ");
			}
			System.out.println("null");
		}
	}

	// return total number of employees stored in the table
	public int getTotalEmployees() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += table[i].size();
		}
		return total;
	}

	public static void main(String[] args) {
		KaryawanHashTable ht = new KaryawanHashTable(10);

		ht.insert("EMP001", "A");
		ht.insert("EMP002", "B");
		ht.insert("EMP012", "C"); // likely collision with EMP002 depending on hash

		System.out.println("Initial table:");
		ht.show();

		ht.update("EMP002", "B Update");
		System.out.println("\nAfter update:");
		ht.show();

		ht.delete("EMP002");
		System.out.println("\nAfter delete:");
		ht.show();

    System.out.println("\nTotal employees: " + ht.getTotalEmployees());
	}
}
