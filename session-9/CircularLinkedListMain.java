class NodeC<T> {
    T value;
    NodeC<T> next;

    NodeC(T value, NodeC<T> next) {
        this.value = value;
        this.next = next;
    }
}

class CircularLinkedList<T> {
  NodeC<T> head;
  NodeC<T> tail;

  void push(T value) {
    NodeC<T> newNode = new NodeC<T>(value, head);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
  }

  void print() {
    NodeC<T> next = head;

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