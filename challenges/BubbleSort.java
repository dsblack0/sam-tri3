public class BubbleSort extends SortData {

    public BubbleSort() {
        super();
    }

    public void sort() {
        for(int i=0; i< sortList.length -1; i++) {
            for(int j=1; j<sortList.length -1; j++) {
                comparisons++;
                if (sortList[j-1] > sortList[j]) {
                    swaps++;
                    int x = sortList[j];
                    sortList[j] = sortList[j-1];
                    sortList[j-1] = x;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();
        System.out.println(bubble);
    }

}
