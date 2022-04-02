import java.util.*;

public class QueueMerge<T> {
  private Queue<T> queue1 = new Queue<T>();
  private Queue<T> queue2 = new Queue<T>();

  // create two separate queues from inputted arrays
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
    Queue<T> queueX = new Queue<T>();
    Queue<T> queueMer = new Queue<T>();
    int value = 0;

    T fir = queueFir.next();
    T sec = queueSec.next();

    //initial iteration of loop without emptying queueX

    //adds smaller value to final merged queue and add larger value to a third queue
    if ((int)fir <= (int)sec) {
      queueMer.add(fir);
      queueX.add(sec);
      QueueIterator<T> queueEx = new QueueIterator<T>(queueX);
      fir = queueFir.next();
      sec = queueEx.next();
    } else {
      queueMer.add(sec);
      queueX.add(fir);
      QueueIterator<T> queueEx = new QueueIterator<T>(queueX);
      fir = queueSec.next();
      sec = queueEx.next();
    }
    //continue to run loop as long as there is another element in the queue
    while (queueFir.hasNext() || queueSec.hasNext()) {
      //adds smaller value to final merged queue and add larger value to a third queue
      if ((int)fir <= (int)sec) {
        queueMer.add(fir);
        queueX.add(sec);
        //remove first element from queueX so that added one is first in the iteration
        queueX.delete();
        QueueIterator<T> queueEx = new QueueIterator<T>(queueX);
        fir = queueFir.next();
        sec = queueEx.next();
      } else {
        queueMer.add(sec);
        queueX.add(fir);
        queueX.delete();
        QueueIterator<T> queueEx = new QueueIterator<T>(queueX);
        fir = queueEx.next();
        sec = queueSec.next();
      }
    }

      //compare last two values left in the three queues and add in order from least to greatest
      if ((int)fir <= (int)sec) {
        queueMer.add(fir);
        queueMer.add(sec);
      } else {
        queueMer.add(sec);
        queueMer.add(fir);
      }
      // return final, merged queue
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
    System.out.println();
    System.out.println("Queue 2: ");
    for (Integer j : listSec) {
      System.out.print(j + " ");
    }

    QueueIterator queueFinal = new QueueIterator(queueM.merged());
    System.out.println();
    System.out.println("Merged Queue: ");

    // print merged queue
    while (queueFinal.hasNext()) {
      System.out.print(queueFinal.next() + " ");
    }
    System.out.println();
  }
}