public class SelectionSort extends SortData {

    public SelectionSort() {
        super();
    }

    public void sort() {
        for (int i=0; i < sortList.length -1; i++) {
            int min = i;
            for (int j=i+1; j < sortList.length; j++) {
                comparisons++;
                if (sortList[j] < sortList[min]) {
                    min = j;
                }
            }
            if (sortList[i] != sortList[min]) {
                swaps++;
            }
            int x = sortList[i];
            sortList[i] = sortList[min];
            sortList[min] = x;
        }
    }

    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();
        System.out.println(selection);
    }
}
