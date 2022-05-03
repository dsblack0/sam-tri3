package frq20;

public class Q1_Hailstone {
  
  public static int hailstoneLength(int n) {
    //CORRECTION: int length = 1; -> to also include the first term in the sequence length count
    int length = 0;
    while (n > 1) {
      if (n % 2 == 0) {
        n = n/2;
      } else {
        n = 3*n+1;
      }
      length++;
    }
    return length;
  }

  public static boolean isLongSeq (int n) {
    if (n < hailstoneLength(n)) {
      return true;
    }
    return false;
  }

  public static double propLong(int n) {
    int numLong = 0;
    for (int i=1; i <= n; i++) {
      if (isLongSeq(i)) {
        numLong++;
      }
    }
    double prop = (double) numLong / n;
    return prop;
  }

  public static void main(String[] args) {
    System.out.println("Length of hailstone sequence starting at 5: " + hailstoneLength(5));
    System.out.println("Hailstone sequence starting at 5 is long: " + isLongSeq(5));
    System.out.println("Proportion of long hailstone sequences with starting values between 1 & 10: " + propLong(10));
  }
 }