{% include navigation.html %}

# Sorts Implementation
## Bubble Sort
```
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
```
- starting from the very first integer in the list, each integer is compared to the integer next to it
     - if the next integer is smaller than that integer, they will switch places
     - this is run through the inside for loop for each of the integers in the list
- the outside 4 loop continues to repeat the same process until the list is fully sorted

## Selection Sort
```
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
```
- the inside for loop goes through the list once and uses an if statement to find the minimum value in the list
     - the minimum is moved to the beginning of the array
- the outside for loop repeats the same process with the starting index being moved by 1 each time so that the sorted elements at the beginning of the array are untouched
     - this repeats until the list is fully sorted

## Insertion Sort
```
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
```
- the second integer in the list is set as the "key" and compared to the previous integer
     - through the while loop, as long as the integer is smaller than the previous one, it is continued to be moved one position up and compared to the previous integers before it
     - the next integer is then set as the new "key"
- this same process is repeated in the for loop for each of the integers in the list, when the list is fully sorted

## Merge Sort
```
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
```
- if the array is only consists of one integer, it is returned as the final array
- otherwise, the midpoint of the array is found and the array is split into two close to equal portions
     - recursion is used to repeat this process until the initial list is continuously split in 2 to reach arrays of 1 integer each
     - the `mergeSort()` method is called to sort each of the split array and then combine them into the final list

```
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
```
- with the first while loop going through pairs of the split arrays, the elements of the arrays are compared and the smaller integer out of each is added to the combined array
     - the second and third while loops go through the two split arrays individually and add any of the remaining elements left after they have been compared against each other
- this is repeated through all of the split arrays until they are combined into one final array that is returned at the end of the sort

## Analytics

| **Sort Type** | **Big O Complexity** | **Time** | **# Comparisons** | **# Swaps** |
| ---       | ---              | ---  | ---           | ---     |
| Bubble | O(n^2)<br>due to nested for loop | 18928470 | 12497500 | 6187738 |
| Selection | O(n^2)<br>due to nested for loop | 18795660 | 12497500 | 4991 |
| Insertion | O(n^2)<br>due to iteration through outside for loop and inside while loop | 501900 | 4999 | 4992 |
| Merge | O(nlog(n))<br>due to the array being split in 2 and number of splits simply being dependent on the number of integers in list | 194455 | 16392 | 0 |

**a random set 5000 was used to get the analytics with the sort being run 12 times and the high + low data being discarded

**Big O Complexity**
![image](https://user-images.githubusercontent.com/70492417/162437081-045e6933-6058-4dfe-8eee-56abfbbdd2af.png)
- The first 3 sorts all had the time complexity of O(n^2) while the merge sort had a time complexity of O(nlog(n)). As the graph of nlog(n) increases much slower than that of the n^2, it takes less time for the merge sort to run than any of the other sorts
- This also makes the merge sort more efficient as it has a better consistency with the slower increase in time

**Time**
- As seen in the table of data, the merge sort took a significantly less time to run than any of the other sorts. Especially when there are very large sets of data being sorted the merge sort takes much less time by using less steps
- Sorts like the insertion sort take more time because in order to put an element in the correct place, everything else in the array may have to be moved as well

**Comparisons & Swaps**
- From the table, the insertion sort had the least amount of comparisons and swaps as it only compares each object to another once while the bubble and selection sorts have to compare them multiple times.
- The merge sort, though, does not require any swaps to be made since the arrays are simply merged in the correct order once fully split. Since the swaps themselves are more complex than comparing two integers, the merge sorts lack of swaps makes it much more efficient

**Conclusion**
Order of Overall Efficiency (from best to worst): Merge, Insertion, Selection, Bubble

- When there set of data to be sorted is very small, insertion sorts would be the most efficient since they are the fastest out of the the 3 sorts with a time complexity of O(n^2), and also require the least amount of comparisons or swaps, but as the set of data gets larger, the merge sort is much more efficient with its use of recursion and spliting + merging of the arrays.
