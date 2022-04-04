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

## Merge Sort

## Analytics

| **Sort Type** | **Big O Complexity** | **Time** | **# Comparisons** | **# Swaps** |
| ---       | ---              | ---  | ---           | ---     |
| Bubble | O(n^2) | 52735490 | 24985002 | 6159635 |
| Selection | O(n^2) | 29347270 | 12497500 | 4993 |
| Insertion | O(n^2) | 57870 | 4999 | 4995 |
| Merge | O(nlog(n)) | 194455 | 16392 | 125260 |

**the same exact set of 5000 integers was used to get the analytics for all 4 sorts

- for a set of about 5000 integers, the **insertion sort** is the best sorting algorithm
     - it requires the least amount of time to run
     - it conducts the least amount of comparisons as it is always one less than the number of elements in the list
     - although the selection sort required less swaps, the insertion sort still doesn't require much more swaps to sort the list
