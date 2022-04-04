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
| Bubble | O(n^2) | 52735490 | 24985002 | 6159635 |
| Selection | O(n^2) | 29347270 | 12497500 | 4993 |
| Insertion | O(n^2) | 57870 | 4999 | 4995 |
| Merge | O(nlog(n)) | 194455 | 16392 | 0 |

**the same exact set of 5000 integers was used to get the analytics for all 4 sorts

- for a set of about 5000 integers, the **insertion sort** is the best sorting algorithm
     - it requires the least amount of time to run
     - it conducts the least amount of comparisons as it is always one less than the number of elements in the list
     - although the selection sort required less swaps, the insertion sort still doesn't require much more swaps to sort the list
- when there is a much large set of integers, though, the **merge sort** is the best algorithm because the insertion will require a much larger amount of comparisons and swaps while the merge sort doesn't require any swaps
