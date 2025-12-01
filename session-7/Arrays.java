public class Arrays {
  public static void print1DWithFor() {
    String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    for (int k=0; k < days.length ;k++) {
        System.out.println(days[k]);
    }
  }

  public static void print1DWithWhile() {
    String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    for (int k=0; k < days.length ;k++) {
        System.out.println(days[k]);
    }
  }

  public static void printMultiD() {
    String[][] address = {{"Florence", "735-1234", "Manila"}, {"Joyce", "983-3333", "Quezon City"}, {"Becca", "456-3322", "Manila"}};
    System.out.println("Buku Alamat saya");
    for (int n = 0; n < address.length ; n++) {
        /*for (int m = 0; address[n].length; m++) {
            System.out.println(address[n][m]+"");
        }*/
        System.out.println("Name: " + address[n][0]);
        System.out.println("Tel.#: " + address[n][1]);
        System.out.println("Address: " + address[n][2]);
        System.out.println();
    }
  }

  public static void main(String[] args) {
    System.out.println("============================");
    System.out.println("Print 1 Dimensi Array menggunakan For-loop");
    System.out.println("============================");
    
    print1DWithFor();
    System.out.println("");

    System.out.println("============================");
    System.out.println("Print 1 Dimensi Array menggunakan Do-while-loop");
    System.out.println("============================");
    
    print1DWithWhile();
    System.out.println("");
    
    System.out.println("============================");
    System.out.println("Print Multi Dimensi Array");
    System.out.println("============================");

    printMultiD();
  }
}
