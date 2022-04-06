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
### Challenge 1 - Dequeue
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

### Challenge 2 - Merge Queues
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
        queueMer.add(sec);
      } else {
        queueMer.add(sec);
        queueMer.add(fir);
      }
    }
    return queueMer;
  }
```
#### Errors/Issues
**Initial Issue**
- Although the merged queue is outputted correctly for this scenario, it will only function properly if the two initially seperate queues are formatted with this or a similar alternating pattern. I still need to work on finding a solution where the merged queue will have a correct numerically ascending order regardless of how the two intial queues are formatted

![image](https://user-images.githubusercontent.com/70492417/159313743-e1f3503f-1bad-4d4e-830c-5e68f1da30a0.png)

**Issue Update 1**
- I was able to go back and fix this issue by creating a third queue where the compared elements are passed into during the merge process, in order to ensure that all of the integers in the queue are compared to each other as they are sorted into the merged queue
     - this allowed for the two initial queues to be merged correctly even when the starting order was slightly different from the current testing data


**Issue Update 2**
- Although I was able to fix the merge method to work for other starting combinations of integer arrays, my approach was still inefficient with a lot of code that could be condensed with a different method of implementation.
     - my crossover partner, Rachel, worked on this to create a solution that is less complex and more efficient in merging any two given queues

### Challenge 3 - Reverse Queue
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

## Week 2
### Challenge 1 - Calculator
- for loop to iterate through each token in the reserve polished notation
```
// for loop to process RPN
for (String token: reverse_polish) {
```
- if statement to check if the token is a number or an operator
     - if a number: pushed into numbers stack
     - if an operator: first two numbers from the stack of numbers are poped for the calculation to be performed
```
if (!isOperator(token)){
        // Push number to stack
        Double number = Double.parseDouble(token);
        calculation.push(number);
      } else {
        // Pop the two top entries
        Double num1 = (Double)calculation.pop();
        Double num2 = (Double)calculation.pop();
        Double res = 0.0;
```
- calculation is perfomed based on the operator
```
if (token.equals("*")) {
  res = num2 * num1;
}
if (token.equals("/")) {
  res = num2 / num1;
}
if (token.equals("%")) {
  res = num2 % num1;
}
if (token.equals("+")) {
  res = num2 + num1;
}
if (token.equals("-")) {
  res = num2 - num1;
}
if (token.equals("^")) {
  res = Math.pow(num2, num1);
}
```
- resulting number from calculation is pushed to the stack of numbers
```
calculation.push(res);
```
- final result is popped from the stack when all of the tokens from the reverse polish notation have been iterated through
```
result = (Double)calculation.pop();
```
- `toString()` method prints all of the notations and the final result as strings

### Challenge 2 - Power Calculator
- power (^) set to have highest precedence out of all the operators
```
private final Map<String, Integer> OPERATORS = new HashMap<>();
  {
    // Map<"token", precedence>
    OPERATORS.put("^", 2);
    OPERATORS.put("*", 3);
    OPERATORS.put("/", 3);
    OPERATORS.put("%", 3);
    OPERATORS.put("+", 4);
    OPERATORS.put("-", 4);
  }
```
- add ^ to the tokens for reverse polish notation
```
case "+":
case "-":
case "*":
case "/":
case "%":
case "^":
```
- add if statement with calculation for ^ operator in `rpnToResult()` method
```
if (token.equals("^")) {
  res = Math.pow(num2, num1);
}
```

## Week 3
### Sorts Implementation + Results
- [Implementation](https://dsblack0.github.io/sam-tri3/sortsImplementation)

### Deriving Sorts' Analytics
- used for loop to run the sort 12 times and collect analytics of time, # of comparisons, and # swaps
     - found the `Duration` between the start and end of the sort and converted it to nano seconds
     - created array lists with all 12 of the times, all 12 # of comparisons, and all 12 # of swaps
     ```
     for (int i=0; i<12; i++) {
      Instant start = Instant.now();
      sort();
      Instant end = Instant.now();
      this.time = Duration.between(start, end).getNano();
      times.add(this.time);
      compare.add(this.comparisons);
      swap.add(this.swaps);
      comparisons = 0;
     }
     ```
     - used Collections to find the max and min values in the array lists and remove them
     ```
     times.remove(Collections.max(times));
     times.remove(Collections.min(times));
     ```
     - found the average of all the values within the array list to get final analytics
