class MinStack {
	private int[] arr;
	private int top;
	private int min; // Menyimpan nilai minimum saat ini

	MinStack(int size) {
		arr = new int[size];
		top = -1;
		min = Integer.MAX_VALUE;
	}

	void push(int x) {
		if (top == arr.length - 1) {
			throw new IllegalStateException("Stack penuh");
		}
		if (top == -1) {
			arr[++top] = x;
			min = x;
			return;
		}
		if (x < min) {
			arr[++top] = 2 * x - min;
			min = x;
		} else {
			arr[++top] = x;
		}
	}

	int pop() {
		if (top == -1) {
			throw new IllegalStateException("Stack kosong");
		}
		int value = arr[top--];
		int result;
		if (value < min) {
			result = min;
			min = 2 * min - value;
		} else {
			result = value;
		}
		if (top == -1) {
			min = Integer.MAX_VALUE;
		}
		return result;
	}

	int getMin() {
		return min;
	}
}

public class MinStackMain {
	public static void main(String[] args) {
		MinStack stack = new MinStack(5);
		stack.push(10);
		stack.push(20);
		stack.push(5);
		stack.push(30);
		System.out.println("Nilai minimum dalam stack: " + stack.getMin());
	}
}