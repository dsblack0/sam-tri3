import java.time.Duration;
import java.time.Instant;

public class MergeSort extends SortData {

    public MergeSort() {
        Instant start = Instant.now();
        sort(sortList, sortList.length);
        Instant end = Instant.now();
        time = Duration.between(start, end).getNano();
    }

    public void sort(int[] list, int e) {
        if (e < 2) {
            return;
        }
        int m = e/2;
        int[] one = new int[m];
        int[] two = new int[e-m];

        for (int i=0; i < one.length; i++) {
            one[i] = list[i];
        }
        for (int i=0; i < two.length; i++) {
            two[i] = list[i+m];
        }

        sort(one, m);
        sort(two, e-m);
        mergeSort(list, one, two, m, e-m);
    }

    public void mergeSort(int[] list, int[] one, int[] two, int o, int t) {
        int i=0, j=0, k=0;
        while (i < o && j < t) {
            comparisons++;
            if (one[i] <= two[j]) {
                list[k] = one[i];
                i++;
            } else {
                list[k] = two[j];
                j++;
            }
            k++;
            swaps++;
        }

        while (i < o) {
            list[k] = one[i];
            i++;
            k++;
        }

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
