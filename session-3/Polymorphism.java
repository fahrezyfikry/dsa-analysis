class Calculator {
  double c;
  public void add(int a, int b) {
    c = (double) a + (double) b;
    System.out.println("Sum int:" + c);
  }

  public void add(double a, double b) {
    c = a + b;
    System.out.println("Sum double:" + c);
  }

  public void substract(int a, int b) {
    c = (double) a - (double) b;
    System.out.println("Subsctraction int:" + c);
  }

  public void substract(double a, double b) {
    c = a - b;
    System.out.println("Subsctraction double:" + c);
  }
}

class AdvanceCalculator extends Calculator {
  public void multiplication(int a, int b) {
    c = (double) a * (double) b;
    System.out.println("Multiplication: " + c);
  }

  public void division(int a, int b) {
    c = (double) a / (double) b;
    System.out.println("division: " + c);
  }

  @Override
  public void add(double a, double b) {
    c = a + b;
    System.out.println("Sum double from advance:" + c);
  }
}

public class Polymorphism {
    public static void main(String[] args) {
      int a = 5, b = 4;
      AdvanceCalculator cal = new AdvanceCalculator();
      cal.add((double) a,(double)  b);
      cal.substract(a, b);
      cal.substract((double) a, (double) b);
      cal.multiplication(a, b);
      cal.division(a, b);
    }
}