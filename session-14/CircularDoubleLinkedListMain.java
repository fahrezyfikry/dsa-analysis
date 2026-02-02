class NodeC<T> {
    T value;
    NodeC<T> prev;
    NodeC<T> next;

    NodeC(T value, NodeC<T> prev, NodeC<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

class CircularDoubleLinkedList<T> {
  NodeC<T> head;
  NodeC<T> tail;

  void push(T value) {
    NodeC<T> newNode = new NodeC<T>(value, null, null);
    if (head == null) {
      head = newNode;
      tail = head;
      head.next = head;
      head.prev = head;
    } else {
      newNode.prev = tail;
      newNode.next = head;
      tail.next = newNode;
      head.prev = newNode;
      tail = newNode;
    }
  }

  void printForward() {
    if (head == null) return;
    NodeC<T> current = head;

    do {
      System.out.println("Value: " + current.value);
      current = current.next;
    } while (current != head);
  }

  void printBackward() {
    if (tail == null) return;
    NodeC<T> current = tail;

    do {
      System.out.println("Value: " + current.value);
      current = current.prev;
    } while (current != tail);
  }
}

public class CircularDoubleLinkedListMain {
  public static void main(String[] args) {
    CircularDoubleLinkedList<Integer> list = new CircularDoubleLinkedList<Integer>();
    list.push(1);
    list.push(2);
    list.push(3);

    System.out.println("Forward:");
    list.printForward();

    System.out.println("\nBackward:");
    list.printBackward();
  }
}