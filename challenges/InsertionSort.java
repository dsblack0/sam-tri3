public class InsertionSort extends SortData {

    public InsertionSort() {
        super();
    }

    public void sort() {
        for (int i=1; i<sortList.length; ++i) {
            int x = sortList[i];
            int j = i-1;

            comparisons++;
            while (j >=0 && sortList[j] > x) {
                sortList[j+1] = sortList[j];
                j--;
            }
            if (sortList[j+1] != x) {
                swaps++;
            }
            sortList[j+1] = x;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertion = new InsertionSort();
        System.out.println(insertion);
    }
}
