package challenges;

import java.util.*;

class Menu {
  String title;
  Runnable action;

  public Menu(String t, Runnable act) {
    this.title = t;
    this.action = act;
  }

  public String getTitle() {
    return this.title;
  }

  public Runnable getAction() {
    return this.action;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Menu> menu = new HashMap<>();
    menu.put(1, new Menu("IntByReference", () -> IntByReference.main(null)));
    menu.put(2, new Menu("Matrix", () -> IntByReference.main(null)));

  
  System.out.println("Choose from menu:");
    for (Map.Entry<Integer, Menu> item : menu.entrySet()) {
      System.out.println(item.getKey() + " : " + item.getValue().getTitle());
    }

    
    int input = sc.nextInt();
    Menu selection = menu.get(input);
    selection.getAction().run();
  }
}