{% include navigation.html %}

# Code Review

## Replit Embedded
<iframe frameborder="0" width="100%" height="800px" src="https://replit.com/@dsblack0/pagesjava?lite=true#src/Menu.java">

## Week 0
### Challenge 1
- used HashMap to add each element to the menu
  ```
  Map<Integer, Menu> menu = new HashMap<>();
  //add each Menu item with title and Runnable
  menu.put(1, new Menu("IntByReference", () -> IntByReference.main(null) ) );
  menu.put(2, new Menu("Matrix", () -> Matrix.main(null) ) );
  ```

- used try and catch to give error message when invalid value is inputted
  ```
  int input = sc.nextInt();
  try {
    Menu selection = menu.get(input);
    selection.getAction().run();
    } catch (Exception e) {
      System.out.println("That is not a valid option.");
    }
   main(null);
  ```

### Challenge 2
- used if statement and referencing variables to switch order if num2 is less than num1
  ```
  public static void swapToLowHighOrder(IntByReference num2) {
    b = num2;
    //check conditions if second number is less than first number
    if (b.value < a.value) {
      //switch two numbers
      b = a;
      a = num2;
    }
  }
  ```
- used toString to output values or `a` and `b`
    ```
    public String toString() {
      return String.valueOf(value);
    }
    ```

### Challenge 3
- used StringBuilder and nested for loops to output and format the matrices
  ```
      public String toString() {
      StringBuilder matrixBuild = new StringBuilder("");
      //traverse forwards through 2D array
      for (int row=0; row < matrix.length; row++) {
        StringBuilder rowBuild = new StringBuilder("");
        for (int col=0; col < matrix[row].length; col++) {
          //to disinclude the "-1" or any other nonpositive integer
          if (matrix[row][col] < 0) {
            rowBuild.append("  ");
          } else {
            //convert the integers to hex and add value to line
           rowBuild.append(Integer.toHexString(matrix[row][col]) + " "); 
          }
        }
        //add each row as separate line
        matrixBuild.append(rowBuild + "\n");
      }
      //traverse backwards through 2D array
     for (int row=matrix.length-1; row >=0 ; row--) {
        StringBuilder rowBuild = new StringBuilder("");
        for (int col=matrix[row].length-1; col >= 0; col--) {
          //to disinclude the "-1" or any other nonpositive integer
          if (matrix[row][col] < 0) {
            rowBuild.append("  ");
          } else {
            //convert the integers to hex and add value to line
           rowBuild.append(Integer.toHexString(matrix[row][col]) + " "); 
          }
        }
       //add each row as separate line
        matrixBuild.append("\n" + rowBuild);
      }
      
      return matrixBuild.toString();
    }
    ```
