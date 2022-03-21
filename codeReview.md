{% include navigation.html %}

# Code Review

Code running on [Replit tab](https://dsblack0.github.io/sam-tri3/code)

## Table of Contents
* TOC
{:toc}

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
    
 ## Week 1
 ### Challenge 1
- used `getNext()` and `setPrevNode()` to set the head of the queue to the next node and move the tail node up
- used if statement to check if the head is already empty to avoid errors
```
public void delete() {
    if (head == null) {
      System.out.println("The queue is empty. Add some data first");
    } else {
      this.head = head.getNext();
      this.head.setPrevNode(tail);
    }
  }
```

### Challenge 2
- first, created the queue from an array of objects
- used `push()` to input the data from the queue/array into the stack
- used `pop()` to extract the data from the stack and print the full stack
```
class StackTester {
  public static void main(String[] args) {
    Object[] queue = new Integer[] {1, 2, 3};
    Object[] stack = new Integer[] {};

    System.out.println("Build Initial Queue:");
    QueueManager q = new QueueManager("Integers", queue);

    Stack s = new Stack();
    for (int i = 0; i < queue.length; i++) {
      s.push(queue[i]);
    }
    System.out.println("Build Stack from Queue:");
    for (int i = 0; i < queue.length; i++) {
      System.out.print(s.pop() + " ");
    }
    System.out.println();
  }
}
```

### Challenge 3
- used while loop to add data from the fist and second queues into the third merged queue
```
public Queue<T> merged() {
    QueueIterator<T> queueFir = new QueueIterator<T>(queue1);
    QueueIterator<T> queueSec = new QueueIterator<T>(queue2);
    Queue<T> queueMer = new Queue<T>();
    while (queueFir.hasNext() && queueSec.hasNext()) {
      T fir = queueFir.next();
      T sec = queueSec.next();

      if ((int)fir <= (int)sec) {
        queueMer.add(fir);
      } else {
        queueMer.add(sec);
      }
    }
    return queueMer;
  }
```
#### Errors
- had errors in the above code section because when the while loop compares `fir` and `sec`, it adds the smaller one to `queueMer` but the larger one is never added to `queueMer`
![image](https://user-images.githubusercontent.com/70492417/159307290-6f32aefb-0348-4059-9b4c-40d6ad2527a2.png)
