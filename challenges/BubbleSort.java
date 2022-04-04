public class BubbleSort extends SortData {

    public BubbleSort() {
        //inherit method from SortData
        super();
    }

    public void sort() {
        //repeats sort starting from each index
        for(int i=0; i< sortList.length -1; i++) {
            //go through each index in the list
            for(int j=1; j<sortList.length -1; j++) {
                comparisons++;
                //compare integer to previous integer
                if (sortList[j-1] > sortList[j]) {
                    swaps++;
                    //switch integers if second is greater than first
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
