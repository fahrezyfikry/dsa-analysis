class NodeI<T> {
    T value;
    NodeI<T> prev;
    NodeI<T> next;

    NodeI(T value, NodeI<T> prev, NodeI<T> next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
}

class DoubleLinkedListI<T> {
  NodeI<T> head;
  NodeI<T> tail;
  int length = 0;

  void push(T value) {
    NodeI<T> newNode = new NodeI<T>(value, null, null);
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

  void insertAtHead(T value) {
    NodeI<T> newNode = new NodeI<T>(value, null, head);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      head.prev = newNode;
      head = newNode;
    }
    length++;
  }

  void insertAtTail(T value) {
    NodeI<T> newNode = new NodeI<T>(value, tail, null);
    if (tail == null) {
      head = newNode;
      tail = head;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  void insertAtIndex(int index, T value) {
    if (index <= 0) {
      insertAtHead(value);
      return;
    }
    if (index >= length) {
      insertAtTail(value);
      return;
    }

    NodeI<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    NodeI<T> newNode = new NodeI<T>(value, current.prev, current);
    current.prev.next = newNode;
    current.prev = newNode;
    length++;
  }

  void insertAfterNode(NodeI<T> node, T value) {
    if (node == null) return;

    if (node == tail) {
      insertAtTail(value);
    } else {
      NodeI<T> newNode = new NodeI<T>(value, node, node.next);
      node.next.prev = newNode;
      node.next = newNode;
      length++;
    }
  }

  void insertBeforeNode(NodeI<T> node, T value) {
    if (node == null) return;

    if (node == head) {
      insertAtHead(value);
    } else {
      NodeI<T> newNode = new NodeI<T>(value, node.prev, node);
      node.prev.next = newNode;
      node.prev = newNode;
      length++;
    }
  }

  NodeI<T> findNode(T value) {
    NodeI<T> current = head;
    while (current != null) {
      if (current.value.equals(value)) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  void print() {
    NodeI<T> current = head;

    while (current != null) {
      System.out.println("Value: " + current.value);
      current = current.next;
    }
  }
}

public class InsertDoubleLinkedListMain {
  public static void main(String[] args) {
    DoubleLinkedListI<Integer> list = new DoubleLinkedListI<Integer>();

    System.out.println("Init: 10 -> 20 -> 30");
    list.push(10);
    list.push(20);
    list.push(30);
    list.print();

    System.out.println("\n1. Insert at Front/Beginning (insertAtHead 5)");
    list.insertAtHead(5);
    list.print();

    System.out.println("\n5. Insertion at the End (insertAtTail 40)");
    list.insertAtTail(40);
    list.print();

    System.out.println("\n4. Insertion at specific position index 2 (insertAtIndex 15)");
    list.insertAtIndex(2, 15);
    list.print();

    System.out.println("\n--- Re-initialize: 100 -> 200 -> 300 -> 400 ---");
    list = new DoubleLinkedListI<Integer>();
    list.push(100);
    list.push(200);
    list.push(300);
    list.push(400);
    list.print();

    System.out.println("\n2. Insertion after node with value 200 (insertAfterNode 250)");
    NodeI<Integer> node200 = list.findNode(200);
    list.insertAfterNode(node200, 250);
    list.print();

    System.out.println("\n3. Insertion before node with value 400 (insertBeforeNode 350)");
    NodeI<Integer> node400 = list.findNode(400);
    list.insertBeforeNode(node400, 350);
    list.print();
  }
}
