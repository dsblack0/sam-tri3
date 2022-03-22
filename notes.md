{% include navigation.html %}

# Notes

## Week 2
### Tech Talk 2: Calculator using Stacks, ArrayLists
- convert strings into Reverse Polish Notation with Shunting-yard algorithm
     - 3 + 4 becomes 3 4 +
- Key Calculator Parts
     - driver for testing with multiple conditions
     - define Data Structures to define operators
     - define symbols that split terms to support tokens
     - test functions for these operators and separators
     - class to manage calculator object
          - constructor can recieve expression and establish sequence for result
     - **Term tokenizer** > changes String expression into series of tokens with distinct elements of expression
     - methods to support calculation, capture attributes, and establish `toString`

### Tech Talk Plan
- Challenge
     - must be able to support decimals as well
     - must build in "power of" (^) operator

## Week 1
### Tech Talk 1: Linked Lists
- **Linked Lists** are ways of keeping and managing a list of Objects
![image](https://user-images.githubusercontent.com/70492417/158393952-bafa9d52-733d-4cbc-abb8-62c9947483c3.png)
     - ABCD -> have Data + Next pointer
     - E -> shows inserting a new Object
     - tmp -> shows accessing Data from D Object
- foundation for Stacks & Queues
     - **Queues** = first in, first out (fifo)
          - keep track of First In (dequeue extraction), Back (enqueue entry), Current node (iteration)
          - "Head" is the first, "Tail" is the last
     - **Stacks** = last in, first out (lifo)
          - keep track of Last Item inserted (Push entry + Pop extraction) 
     - A queue has a linked list
- Iterable interface
     - enhanced `for` loop
- Generic T
     - so that you can reuse your one stack or queue for different data types
     - used because you don't need to know the exact type when pushing in the data -> don't have to uncast/cast Object afterwards
     - enables application to any types of objects

### Tech Talk Questions/Plans
- How does Generic T work and how is using it helpful?
     - so that you can reuse your one stack or queue for different data types
     - used because you don't need to know the exact type when pushing in the data -> don't have to uncast/cast Object afterwards
     - enables application to any types of objects

## Week 0
### Tech Talk 0: Data Structures
- **Data structures** are methods of organizing data
     - variables, arrays, hashmaps,  tables, databases
#### Programming Paradigms
- an approach to be folowed for writing software applications
- **Imperative Paradigm** = programming paradigm that uses statements that change program state
     - focus on the "how"
     - Procedural Programming = when program is built form one or more procedures
- **Object Oriented Paradigm** = relies on concept of classes and objects
     - to structure program into simple & reusable code pieces

### Notes on linking Replit and Github Repo
hacks.sh file
- javac *.java
- java hacks/Menu
- rm hacks/*.class

.replit file
- run = "bash hacks.sh"

### Tech Talk Plans
- Challenge 1:
     - Use HashMap to create the Menu
- Challenge 3:
     - Use StringBuilder and "\n" to format the matrices with each row as a separate line
     - Convert the integers to hex values to ouput letters a-f instead of integers 10-15
