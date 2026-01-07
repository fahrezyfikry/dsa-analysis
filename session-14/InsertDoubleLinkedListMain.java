class NodeI<T> {
    T value;
    NodeI<T> next;

    NodeI(T value, NodeI<T> next) {
      this.value = value;
      this.next = next;
    }
}

class SingleLinkedListI<T> {
  NodeI<T> head;
  NodeI<T> tail;
  int length = 0;

  void push(T value) {
    NodeI<T> newNode = new NodeI<T>(value, null);
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
    head = new NodeI<T>(value, head);
    length++;
  }

  void insertAtTail(T value) {
    tail.next = new NodeI<T>(value, null);
    tail = tail.next;
    length++;
  }

  void insertAfterIndex(int index, T value) {
    NodeI<T> next = head;
    int i = 0;
    while (i != index && i < length){
      next = next.next;
      i++;
    }

    if (next == null) {
      push(value);
    } else {
      next.next = new NodeI<T>(value, next.next);
      length++;
    }
  }

  void print() {
    NodeI<T> next = head;

    while (next != null){
      System.out.println("Value: " + next.value);
      next = next.next;
    }
  }
}

public class InsertDoubleLinkedListMain {
  public static void main(String[] args) {
    SingleLinkedListI<Integer> singleLinkedList = new SingleLinkedListI<Integer>();

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
