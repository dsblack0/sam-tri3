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

  //text formatting of menu
  System.out.println("Choose from menu:");
    for (Map.Entry<Integer, Menu> item : menu.entrySet()) {
      System.out.println(item.getKey() + " : " + item.getValue().getTitle());
    }

    //run menu item when user inputs an integer
      int input = sc.nextInt();
      try {
        Menu selection = menu.get(input);
        selection.getAction().run();
      } catch (Exception e) {
                    System.out.println("That is not a valid option.");
        }
    main(null);
  }
}