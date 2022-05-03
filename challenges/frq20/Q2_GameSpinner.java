package frq20;

public class Q2_GameSpinner {
  //CORRECTION: private static int sectors; -> sectors must also be a static variable if spin is one
  private static int sectors;
  //CORRECTION: private static int runLength = 1; -> so that the run starts at a length of 1 
  private static int runLength = 0;
  private static int spin;

  public Q2_GameSpinner(int sectors) {
    this.sectors = sectors;
  }

  public static int spin() {
    int lastSpin = spin;
    spin = 1 + (int) (Math.random() * sectors);
    if (lastSpin == spin) {
      runLength++;
    } else {
      runLength = 1;
    }
    return spin;
  }

  public static int currentRun() {
    return runLength;
  }

  public static void main(String[] args) {
    Q2_GameSpinner g = new Q2_GameSpinner(4);
    System.out.println("Current Run: " + g.currentRun());
    System.out.println("Spin: " + g.spin());
    System.out.println("Current Run: " + g.currentRun());
    System.out.println("Spin: " + g.spin());
    System.out.println("Current Run: " + g.currentRun());
    System.out.println("Spin: " + g.spin());
     System.out.println("Current Run: " + g.currentRun());
    System.out.println("Spin: " + g.spin());
    System.out.println("Current Run: " + g.currentRun());
  }
}