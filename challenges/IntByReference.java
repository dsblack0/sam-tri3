public class IntByReference {
  private int value;
  private static IntByReference a;
  private static IntByReference b;

  public IntByReference(int num) {
    value = num;
  }

  // Hack: create IntByReference, swapToLowHighOrder and toString methods

  // static method that enables me to see numbers swapped by reference (before,
  // after)
  public static void swapper(int n0, int n1) {
    a = new IntByReference(n0);
    b = new IntByReference(n1);
    System.out.println("Before: " + a + " " + b);
    a.swapToLowHighOrder(b); // conditionally build swap method to change values of a, b
    System.out.println("After: " + a + " " + b);
    System.out.println();
  }

  // method to swap the two numbers if the second is smaller than the first
  public static void swapToLowHighOrder(IntByReference num2) {
    b = num2;
    //check conditions if second number is less than first number
    if (b.value < a.value) {
      //switch two numbers
      b = a;
      a = num2;
    }
  }
  //toString method to return the value of the number
  public String toString() {
    return String.valueOf(value);
  }
  // static main method that provides some simple test cases
  public static void main(String[] ags) {
    IntByReference.swapper(21, 16);
    IntByReference.swapper(16, 21);
    IntByReference.swapper(16, -1);
  }
}