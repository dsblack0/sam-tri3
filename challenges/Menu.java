import java.util.*;

class Menu {
  String title;
  Runnable action;

  public Menu(String title, Runnable action) {
    this.title = title;
    this.action = action;
  }

  public String getTitle() {
    return this.title;
  }

  public Runnable getAction() {
    return this.action;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //create HashMap
    Map<Integer, Menu> menu = new HashMap<>();
    //add each Menu item with title and Runnable
    menu.put(1, new Menu("IntByReference", () -> IntByReference.main(null) ) );
    menu.put(2, new Menu("Matrix", () -> Matrix.main(null) ) );
    menu.put(3, new Menu("Queue", () -> QueueTester.main(null)));
    menu.put(4, new Menu("Queue to Stack", () -> StackTester.main(null)));
    menu.put(5, new Menu("Merge Queues", () -> QueueMergeTester.main(null)));
    menu.put(6, new Menu("Calculator", () -> Calculator.main(null)));
    menu.put(7, new Menu("Bubble Sort", () -> BubbleSort.main(null)));
    menu.put(8, new Menu("Selection Sort", () -> SelectionSort.main(null)));
    menu.put(9, new Menu("Insertion Sort", () -> InsertionSort.main(null)));
    menu.put(10, new Menu("Merge Sort", () -> MergeSort.main(null)));
    menu.put(11, new Menu("Compare the Sorts", () -> SortData.main(null)));
    menu.put(12, new Menu("2015 FRQ 1 - Diverse Array", () -> frq15.Q1_DiverseArray.main(null)));
    menu.put(13, new Menu("2015 FRQ 2 - Hidden Word", () -> frq15.Q2_HiddenWord.main(null)));
    menu.put(14, new Menu("2015 FRQ 3 - Sparse Array", () -> frq15.Q3_SparseArray.main(null)));
    menu.put(15, new Menu("2015 FRQ 4 - Number Group", () -> frq15.Q4_MultipleGroups.main(null)));
    menu.put(16, new Menu("2020 FRQ 1 - Hailstone Sequences", () -> frq20.Q1_Hailstone.main(null)));
    menu.put(17, new Menu("2020 FRQ 2 - Game Spinner", () -> frq20.Q2_GameSpinner.main(null)));
    menu.put(18, new Menu("2020 FRQ 3 - Review Collector", () -> frq20.Q3_ReviewCollector.main(null)));

  //text formatting of menu
  System.out.println("Choose from menu:");
    for (Map.Entry<Integer, Menu> item : menu.entrySet()) {
      System.out.println(item.getKey() + " : " + item.getValue().getTitle());
    }

    //run menu item when user inputs an integer
      int input = sc.nextInt();
      System.out.println();
      try {
        Menu selection = menu.get(input);
        selection.getAction().run();
      } catch (Exception e) {
                    System.out.println("That is not a valid option.");
        }
    System.out.println();
    main(null);
  }
}