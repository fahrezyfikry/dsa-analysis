class Node<T> {
    T value;
    Node<T> next;

    Node(T value, Node<T> next) {
      this.value = value;
      this.next = next;
    }
}

class SingleLinkedList<T> {
  Node<T> head;
  Node<T> tail;
  int length = 0;

  void push(T value) {
    Node<T> newNode = new Node<T>(value, null);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
    length++;
  }

  void insertAtHead(T value) {
    head = new Node<T>(value, head);
    length++;
  }

  void insertAtTail(T value) {
    tail.next = new Node<T>(value, null);
    tail = tail.next;
    length++;
  }

  void insertAfterIndex(int index, T value) {
    Node <T> next = head;
    int i = 0;
    while (i != index && i < length){
      next = next.next;
      i++;
    }

    if (next == null) {
      push(value);
    } else {
      next.next = new Node<T>(value, next.next);
      length++;
    }
  }

  void print() {
    Node <T> next = head;

    while (next != null){
      System.out.println("Value: " + next.value);
      next = next.next;
    }
  }
}

public class InsertSingleLinkedListMain {
  public static void main(String[] args) {
    SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();

    System.out.println("Init");
    singleLinkedList.push(1);
    singleLinkedList.push(2);
    singleLinkedList.push(3);
    singleLinkedList.print();

    System.out.println("");
    System.out.println("After insert head 0, tail 4, and index 1 -> 12");
    singleLinkedList.insertAtHead(0);
    singleLinkedList.insertAtTail(4);
    singleLinkedList.insertAfterIndex(1, 12);
    singleLinkedList.print();
  }
}
