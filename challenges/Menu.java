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

  //text formatting of menu
  System.out.println("Choose from menu:");
    for (Map.Entry<Integer, Menu> item : menu.entrySet()) {
      System.out.println(item.getKey() + " : " + item.getValue().getTitle());
    }

    //run menu item when user inputs an integer
    int input = sc.nextInt();
    Menu selection = menu.get(input);
    selection.getAction().run();
  }
}