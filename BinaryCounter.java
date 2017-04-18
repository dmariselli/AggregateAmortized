// Example of Aggregate Amortized Analysis

public class BinaryCounter {

  int[] counter = new int[8];
  int count = 0;
  int cost = 0;

  public static void main(String[] args) {

    BinaryCounter bc = new BinaryCounter();

    System.out.printf("|%1$-12s|%2$-12s|%3$-12s|\n", "   Counter", "   Binary", " Total Cost");
    for (int i = 0; i < 16; i++) {
      bc.increment();
      System.out.printf("|%1$6s%2$-6s|%3$2s%4$-10s|%5$6s%6$-6s|\n", " ", bc.count, " ", bc.toBinaryString(), " ", bc.cost);  
    }
    System.out.println("Total number of flips in the sequence: " + bc.cost + " < 2n = " + (bc.count * 2));
    System.out.println("The worst-case time for a sequence of n increment operations on an initially zero counter is therefore O(n).");
    System.out.println("The amortized cost per operation is O(n)/n = O(1).");
  }

  public void increment() {
    int i = 0;

    while (i < counter.length && counter[i] == 1) {
      counter[i] = 0;
      i++;
      cost++;
    }

    if (i < counter.length) {
      counter[i] = 1;
      cost++;
    }
    count++;    
  }

  public String toBinaryString() {
    StringBuilder sb = new StringBuilder();
    for (int i = counter.length - 1; i >= 0; i--) {
      sb.append(counter[i]);
    }
    return sb.toString();
  }

}
