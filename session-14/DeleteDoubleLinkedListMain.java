class NodeD<T> {
    T value;
    NodeD<T> prev;
    NodeD<T> next;

    NodeD(T value, NodeD<T> prev, NodeD<T> next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
}

class DoubleLinkedList<T> {
  NodeD<T> head;
  NodeD<T> tail;
  int length = 0;

  void push(T value) {
    NodeD<T> newNode = new NodeD<T>(value, null, null);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  void removeFirstNode() {
    if (head == null) return;

    if (head == tail) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
    }
    length = Math.max(0, --length);
  }

  void removeLastNode() {
    if (tail == null) return;

    if (head == tail) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
    }
    length = Math.max(0, --length);
  }

  void removeAtIndex(int index) {
    if (index < 0 || index >= length) return;

    if (index == 0) {
      removeFirstNode();
      return;
    } else if (index == length - 1) {
      removeLastNode();
      return;
    }

    NodeD<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    current.prev.next = current.next;
    current.next.prev = current.prev;
    length = Math.max(0, --length);
  }

  void removeAfterNode(NodeD<T> node) {
    if (node == null || node.next == null) return;

    NodeD<T> toRemove = node.next;

    if (toRemove == tail) {
      tail = node;
      node.next = null;
    } else {
      node.next = toRemove.next;
      toRemove.next.prev = node;
    }
    length = Math.max(0, --length);
  }

  void removeBeforeNode(NodeD<T> node) {
    if (node == null || node.prev == null) return;

    NodeD<T> toRemove = node.prev;

    if (toRemove == head) {
      head = node;
      node.prev = null;
    } else {
      toRemove.prev.next = node;
      node.prev = toRemove.prev;
    }
    length = Math.max(0, --length);
  }

  NodeD<T> findNode(T value) {
    NodeD<T> current = head;
    while (current != null) {
      if (current.value.equals(value)) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  void print() {
    NodeD<T> current = head;

    while (current != null) {
      System.out.println("Value: " + current.value);
      current = current.next;
    }
  }
}

public class DeleteDoubleLinkedListMain {
  public static void main(String[] args) {
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

    System.out.println("Init: 1 -> 2 -> 3 -> 4 -> 5 -> 6");
    list.push(1);
    list.push(2);
    list.push(3);
    list.push(4);
    list.push(5);
    list.push(6);
    list.print();

    System.out.println("\n1. Deletion at the Beginning (removeFirstNode)");
    list.removeFirstNode();
    list.print();

    System.out.println("\n5. Deletion at the End (removeLastNode)");
    list.removeLastNode();
    list.print();

    System.out.println("\n4. Deletion at specific position index 1 (removeAtIndex)");
    list.removeAtIndex(1);
    list.print();

    System.out.println("\n--- Re-initialize: 10 -> 20 -> 30 -> 40 -> 50 ---");
    list = new DoubleLinkedList<Integer>();
    list.push(10);
    list.push(20);
    list.push(30);
    list.push(40);
    list.push(50);
    list.print();

    System.out.println("\n2. Deletion after node with value 20 (removeAfterNode)");
    NodeD<Integer> node20 = list.findNode(20);
    list.removeAfterNode(node20);
    list.print();

    System.out.println("\n3. Deletion before node with value 50 (removeBeforeNode)");
    NodeD<Integer> node50 = list.findNode(50);
    list.removeBeforeNode(node50);
    list.print();
  }
}