class Calculator {
  int c;
  public void add(int a, int b) {
    c = a + b;
    System.out.println("Sum:" + c);
  }

  public void substract(int a, int b) {
    c = a - b;
    System.out.println("Subsctraction:" + c);
  }
}

class AdvanceCalculator extends Calculator {
  public void multiplication(int a, int b) {
    c = a * b;
    System.out.println("Multiplication: " + c);
  }

  public void division(int a, int b) {
    c = a / b;
    System.out.println("division: " + c);
  }
}

public class Inheritance {
    public static void main(String[] args) {
      int a = 5, b = 4;
      AdvanceCalculator cal = new AdvanceCalculator();
      cal.add(a, b);
      cal.substract(a, b);
      cal.multiplication(a, b);
      cal.division(a, b);
    }
}