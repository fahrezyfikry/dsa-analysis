class Node<T> {
    T value;
    Node<T> next;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}

class CircularLinkedList<T> {
  Node<T> head;
  Node<T> tail;

  void push(T value) {
    Node<T> newNode = new Node<T>(value, head);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
  }

  void print() {
    Node <T> next = head;

    do {
      System.out.println("Value: " + next.value);
      next = next.next;
    } while (next != head);
  }
}

public class CircularLinkedListMain {
  public static void main(String[] args) {
    CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<Integer>();
    circularLinkedList.push(1);
    circularLinkedList.push(2);
    circularLinkedList.push(3);
    circularLinkedList.print();
  }
}
