class DoublyNode {
  int data;
  DoublyNode next, prev;

  DoublyNode(int data) {
    this.data = data;
    this.next = this.prev = null;
  }
}

class DoublyLinkedList {
  DoublyNode head;

  void insert(int data) {
    DoublyNode newNode = new DoublyNode(data);
    if (head == null) {
      head = newNode;
    } else {
      DoublyNode temp = head;
      while (temp.next != null) {
      temp = temp.next;
      }
      temp.next = newNode;
      newNode.prev = temp;
    }
  }

  void display() {
    DoublyNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " <-> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  void deleteByValue(int value) {
    if (head == null) {
      System.out.println("Linked List kosong");
      return;
    }

    DoublyNode temp = head;

    // Traverse untuk mencari node dengan nilai tertentu
    while (temp != null && temp.data != value) {
      temp = temp.next;
    }

    if (temp == null) {
      System.out.println("Nilai tidak ditemukan");
      return;
    }

    if (temp.prev != null) {
      temp.prev.next = temp.next;
    } else {
      head = temp.next; // Jika node yang dihapus adalah head
    }

    if (temp.next != null) {
      temp.next.prev = temp.prev;
    }
  }
}

public class DoublyLinkedListExercise {
  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.insert(10);
    dll.insert(20);
    dll.insert(30);
    dll.insert(40);

    dll.display();
    dll.deleteByValue(30);
    dll.display();
  }
}