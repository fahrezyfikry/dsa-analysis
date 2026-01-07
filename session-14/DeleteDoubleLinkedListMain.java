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

  void removeFirstNode() {
    Node<T> currentHead = head;
    head = head.next;
    currentHead.next = null;
    length = Math.max(0, --length);
  }

  void removeLastNode() {
    Node <T> next = head;
    Node <T> prev = next;

    while (next.next != null){
      prev = next;
      next = next.next;
    }

    prev.next = null;
    length = Math.max(0, --length);
  }

  void removeAtIndex(int index) {
    if (index == 0) {
      removeFirstNode();
      return;
    } else if (index == length - 1) {
      removeLastNode();
      return;
    }

    Node<T> next = head;
    Node <T> prev = next;

    int i = 0;
    while (i != index && i < length){
      prev = next;
      next = next.next;
      i++;
    }
    
    if (prev != null && prev.next != null) {
      prev.next = prev.next.next;
      length = Math.max(0, --length);
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

public class DeleteDoubleLinkedListMain {
  public static void main(String[] args) {
    SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();

    System.out.println("Init");
    singleLinkedList.push(1);
    singleLinkedList.push(2);
    singleLinkedList.push(3);
    singleLinkedList.push(4);
    singleLinkedList.push(5);
    singleLinkedList.push(6);
    singleLinkedList.print();

    System.out.println("");
    System.out.println("After remove first node");
    singleLinkedList.removeFirstNode();
    singleLinkedList.print();
    
    System.out.println("");
    System.out.println("Remove last node");
    singleLinkedList.removeLastNode();
    singleLinkedList.print();

    System.out.println("");
    System.out.println("Remove node at 1");
    singleLinkedList.removeAtIndex(1);
    singleLinkedList.print();

    System.out.println("");
    System.out.println("Remove node at 1 again");
    singleLinkedList.removeAtIndex(1);
    singleLinkedList.print();

    System.out.println("");
    System.out.println("rmove node at 0");
    singleLinkedList.removeAtIndex(0);
    singleLinkedList.print();
  }
}