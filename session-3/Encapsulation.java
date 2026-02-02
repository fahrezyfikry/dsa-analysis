class Calculator {
  private double c;
  public void add(double a, double b) {
    c = a + b;
    sideEffect();
  }

  private void sideEffect() {
    System.out.println("Sum int:" + c);
  }

  public double getResult() {
    return c;
  }
}

public class Encapsulation {
    public static void main(String[] args) {
      double a = 5, b = 4;
      Calculator cal = new Calculator();
      cal.add(a, b);
      System.out.println("Add result:" + cal.getResult());
    }
}