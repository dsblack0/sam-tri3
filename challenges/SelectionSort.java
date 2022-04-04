public class SelectionSort extends SortData {

    public SelectionSort() {
        super();
    }

    public void sort() {
        //repeat sort with index moved by 1 each time to not touch already sorted integers
        for (int i=0; i < sortList.length -1; i++) {
            int min = i;
            //go through list to compare to "starting" integer
            for (int j=i+1; j < sortList.length; j++) {
                comparisons++;
                //set new minimum value to smallest integer in rest of list
                if (sortList[j] < sortList[min]) {
                    min = j;
                }
            }
            if (sortList[i] != sortList[min]) {
                swaps++;
            }
            //move minimum value to begining of array
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
