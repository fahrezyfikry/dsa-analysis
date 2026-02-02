class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
	Node head;

	void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	void findMax() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		int max = head.data;
		Node temp = head.next;
		while (temp != null) {
			if (temp.data > max) {
				max = temp.data;
			}
			temp = temp.next;
		}

		System.out.println("Max value: " + max);
	}
}

public class SingleLinkedListExercise {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(15);
		list.insert(30);
		list.display();
		list.findMax();
	}
}