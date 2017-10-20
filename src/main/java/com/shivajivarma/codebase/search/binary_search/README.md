[Binary Search](BinarySearch.java)
=============

A __Binary search__ locates an item in a sorted array by repeatedly dividing the search interval in half. The initial interval includes the entire array. If the value of the search key is less than the item in the middle of the interval, then the next interval will be the lower half of the current interval. If the value of the search key is greater than the middle item, then the next interval will be the upper half. The search process repeats until the item is found or the search interval is empty.  

Binary Search is an O(log n) algorithm, which is more efficient than a linear search for large arrays.

> Program to perform search on sorted set of numbers using Binary search technique.

### Example
```
Enter size of the array :: 8

Enter elements of the array in ascending order :: 1 5 7 11 12 56 102 156

Enter the number to be searched :: 102

102 is present at location 7.
```

### CODE
```c
public static int search(ArrayList<Integer> arr, int num) {
    int low = 0, high = arr.size(), pos = -1;

    while(low <= high){
        int mid = (low + high)/2;
        if(num == arr.get(mid)){
            pos = mid;
            break;
        } else if(num < arr.get(mid)){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return pos;
}
```

:+1: