[Linear Search](LinearSearch.java)
=============

__Linear search__, also known as sequential search, is a process that checks every element in the list sequentially until the desired element is found.  

> Program to perform search on set of numbers using Linear search technique.

### Example
```
Enter size of the array :: 8
    
Enter elements of the array :: 102 52 7 141 12 56 102 156
    
Enter the number to be searched :: 102

102 is present at location 6.
```

### CODE
```java
public static int search(ArrayList<Integer> arr, int num) {
    for(int i=0; i<arr.size(); i++){
        if(arr.get(i) == num){
            return i;
        }
    }
    return -1;
}
```

:+1: