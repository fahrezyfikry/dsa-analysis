class Node<T> {
    T value;
    Node<T> next;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    void print() {
      Node <T> next = this;

      do {
        System.out.println("Value: " + next.value);
        next = next.next;
      } while (next != this);
    }
}

public class CircularLinkedList {

  public static void main(String[] args) {
    Node<Integer> thirdNode = new Node<Integer>(3, null);
    Node<Integer> secondNode = new Node<Integer>(2, thirdNode);
    Node<Integer> firstNode = new Node<Integer>(1, secondNode);
    thirdNode.next = firstNode;

    firstNode.print();
  }
}
