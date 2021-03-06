import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortData {
    int[] sortList;
    int comparisons;
    ArrayList<Integer> compare = new ArrayList<>();
    int swaps;
    ArrayList<Integer> swap = new ArrayList<>();
    int time;
    ArrayList<Integer> times = new ArrayList<>();


    public SortData() {
        this.sortList = getUnsorted();
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
        times.remove(Collections.max(times));
        times.remove(Collections.min(times));
        compare.remove(Collections.max(compare));
        compare.remove(Collections.min(compare));
        swap.remove(Collections.max(swap));
        swap.remove(Collections.min(swap));

        for (int i=0; i<times.size(); i++) {
            time += times.get(i);
            comparisons += compare.get(i);
            swaps += swap.get(i);
        }
        time = time/times.size();
        comparisons = comparisons/times.size();
        swaps = swaps/(times.size()+1);
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getTime() {
        return time;
    }

    public void sort() {

    }

    public int[] getUnsorted() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a size of the amount of data you want (an integer) to generate a random list OR a set of data you want to sort (a list of integers separated by commas)");
        String input = sc.nextLine();
        if (input.contains(",")) {
            String[] strList = input.split(",");
            int[] intList = new int[strList.length];
            for (int i=0; i< strList.length; i++) {
                intList[i] = Integer.parseInt(strList[i]);
            }
            return intList;
        } else {
            int in = Integer.parseInt(input);
            int[] intList = new int[in];
            for (int i=0; i < in; i++) {
                intList[i] = (int)(Math.random() * (in+1));
            }
            return intList;
        }
    }

    public String toString() {
        String output = "Sorted Data: ";
        for (int i=0; i < sortList.length; i++) {
            output += sortList[i] + ", ";
        }
        output += "\nComparisons: " + comparisons + "\nSwaps: " + swaps + "\nTime Elapsed: " + time;
        return output;
    }

    public static void main(String args[]){
        System.out.print("For BubbleSort: ");
        BubbleSort bubblesort = new BubbleSort();
        bubblesort.sort();
        System.out.println("Total Time: "+ bubblesort.getTime() + "\nTotal swaps: " + bubblesort.getSwaps() + "\nTotal comparisons: " + bubblesort.getComparisons());

        System.out.print("For SelectionSort: ");
        SelectionSort selection = new SelectionSort();
        selection.sort();
        System.out.println("Total Time: "+ selection.getTime() + "\nTotal swaps: " + selection.getSwaps() + "\nTotal comparisons: " + selection.getComparisons());

        System.out.print("For InsertionSort: ");
        InsertionSort insertion = new InsertionSort();
        insertion.sort();
        System.out.println("Total Time: "+ insertion.getTime() + "\nTotal swaps: " + insertion.getSwaps() + "\nTotal comparisons: " + insertion.getComparisons());

        System.out.print("For MergeSort: ");
        MergeSort merge = new MergeSort();
        merge.sort();
        System.out.println("Total Time: "+ merge.getTime() + "\nTotal swaps: " + merge.getSwaps() + "\nTotal comparisons: " + merge.getComparisons());

        System.out.println(bubblesort);
    }
}
