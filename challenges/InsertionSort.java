public class InsertionSort extends SortData {

    public InsertionSort() {
        super();
    }

    public void sort() {
      //repear sort from each integer in list
        for (int i=1; i<sortList.length; ++i) {
            //set starting "key"
            int x = sortList[i];
            int j = i-1;

            comparisons++;
            //loop as long as integer is smaller than previous one
            while (j >=0 && sortList[j] > x) {
                //move integer back one index if smaller than that previous index
                sortList[j+1] = sortList[j];
                j--;
            }
            if (sortList[j+1] != x) {
                swaps++;
            }
            //set next integer as new key
            sortList[j+1] = x;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertion = new InsertionSort();
        System.out.println(insertion);
    }
}
