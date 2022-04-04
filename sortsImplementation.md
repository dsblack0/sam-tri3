{% include navigation.html %}

# Sorts Implementation
## Bubble Sort

## Selection Sort

## Insertion Sort

## Merge Sort

## Analytics

| Sort Type | Big O Complexity | Time | # Comparisons | # Swaps |
| ---       | ---              | ---  | ---           | ---     |
| Bubble | O(n^2) | 52735490 | 24985002 | 6159635 |
| Selection | O(n^2) | 29347270 | 12497500 | 4993 |
| Insertion | O(n^2) | 57870 | 4999 | 4995 |
| Merge | O(nlog(n)) | 194455 | 16392 | 125260 |
* the same exact set of 5000 integers was used to get the analytics for all 4 sorts

- for a set of about 5000 integers, the **insertion sort** is the best sorting algorithm
     - it requires the least amount of time to run
     - it conducts the least amount of comparisons as it is always one less than the number of elements in the list
     - although the selection sort required less swaps, the insertion sort still doesn't require much more swaps to sort the list
