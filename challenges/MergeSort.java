import java.time.Duration;
import java.time.Instant;
import java.util.Collections;

public class MergeSort extends SortData {

    public MergeSort() {
      //doesn't inherit super class as sort() method has parameters
        for (int i=0; i<12; i++) {
            Instant start = Instant.now();
            sort(sortList, sortList.length);
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

    public void sort(int[] list, int e) {
        //return array if it has only one integer
        if (e < 2) {
            return;
        }
        //find mindpoint of array
        int m = e/2;
        int[] one = new int[m];
        int[] two = new int[e-m];
        //split initial array into two arrays at the midpoint
        for (int i=0; i < one.length; i++) {
            one[i] = list[i];
        }
        for (int i=0; i < two.length; i++) {
            two[i] = list[i+m];
        }
        //continue to split the array until all arrays hold only 1 integer
        sort(one, m);
        sort(two, e-m);
        //sort integers as pairs of arrays are merged into the combined list
        mergeSort(list, one, two, m, e-m);
    }

    public void mergeSort(int[] list, int[] one, int[] two, int o, int t) {
        int i=0, j=0, k=0;
        //loop as long as both separated arrays have integers in them
        while (i < o && j < t) {
            comparisons++;
            //add smaller integer out of the two arrays into the combined array
            if (one[i] <= two[j]) {
                list[k] = one[i];
                i++;
            } else {
                list[k] = two[j];
                j++;
            }
            k++;
        }
        //add any leftover integers from first split array
        while (i < o) {
            list[k] = one[i];
            i++;
            k++;
        }
        //add any leftover integers from second split array
        while (j < t) {
            list[k] = two[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort merge = new MergeSort();
        System.out.println(merge);
    }
}
