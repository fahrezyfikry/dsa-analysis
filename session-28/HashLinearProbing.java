
public class HashLinearProbing {
	private Integer[] table;
	private final int size;

	public HashLinearProbing(int size) {
		this.size = size;
		this.table = new Integer[size];
	}

	private int hash(int key) {
		return key % size;
	}

	// Insert key using linear probing; returns final index or -1 if full
	public int insert(int key) {
		int h = hash(key);
		int idx = h;
		int steps = 0;
		while (table[idx] != null && steps < size) {
			idx = (idx + 1) % size;
			steps++;
		}
		if (table[idx] == null) {
			table[idx] = key;
			return idx;
		}
		return -1; // table full
	}

	public void printTable() {
		System.out.println("Index : Value");
		for (int i = 0; i < size; i++) {
			System.out.printf("%5d : %s\n", i, (table[i] == null ? "-" : table[i].toString()));
		}
	}

	public static void main(String[] args) {
		int[] keys = {72, 27, 36, 45, 63, 82, 94, 105};
		int m = 8; // table size
		HashLinearProbing htable = new HashLinearProbing(m);

		System.out.println("Hash function: h(k) = k mod 8\n");
		for (int k : keys) {
			int h = htable.hash(k);
			int placed = htable.insert(k);
			if (placed >= 0) {
				System.out.printf("Insert %3d: h=%d -> placed at index %d\n", k, h, placed);
			} else {
				System.out.printf("Insert %3d: h=%d -> table full, cannot insert\n", k, h);
			}
		}

		System.out.println();
		htable.printTable();
	}
}