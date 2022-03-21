import java.util.*;

public class QueueMerge<T> {
  private Queue<T> queue1 = new Queue<T>();
  private Queue<T> queue2 = new Queue<T>();

  public QueueMerge(T[] list1, T[] list2) {
    for (T data : list1) {
      queue1.add(data);
    }
    for (T data : list2) {
      queue2.add(data);
    }
  }

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
  
}

class QueueMergeTester {
  public static void main(String args[]) {
    Integer[] listFir = new Integer[] {1, 4, 5, 8};
    Integer[] listSec = new Integer[] {2, 3, 6, 7};

    QueueMerge queueM = new QueueMerge(listFir, listSec);
    // print list 1 and list 2
    System.out.println("Queue 1: ");
    for (Integer i : listFir) {
      System.out.print(i + " ");
    }
    System.out.println("Queue 2: ");
    for (Integer j : listSec) {
      System.out.print(j + " ");
    }

    // print merged queue
    QueueIterator queueFinal = new QueueIterator(queueM.merged());
    System.out.println();
    System.out.println("Merged Queue: ");
    
    while (queueFinal.hasNext()) {
      System.out.print(queueFinal.next() + " ");
    }
    System.out.println();
  }   
}