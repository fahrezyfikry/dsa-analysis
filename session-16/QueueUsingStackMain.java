import java.util.Stack;

class QueueUsingStack {
  Stack<Integer> stack1 = new Stack<>();
  Stack<Integer> stack2 = new Stack<>();

  void enqueue(int data) {
    stack1.push(data);
  }

  int dequeue() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    if (stack2.isEmpty()) {
      throw new IllegalStateException("Queue kosong");
    }
    return stack2.pop();
  }
}

public class QueueUsingStackMain {
  public static void main(String[] args) {
    QueueUsingStack queue = new QueueUsingStack();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    System.out.println("Elemen yang di-dequeue: " + queue.dequeue());
  }
}
