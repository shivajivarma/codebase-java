Display Patterns
===============

Programs to display patterns like 
    a. right angled triangle (Orientation Right).
    b. right angled triangle (Orientation Left).
    c. Given 'n', print the symbol 'Z' spanning n rows using '*' symbol. Value of n>2 and n<=20.

### RIGHT ANGLED TRIANGLE (ORIENTATION RIGHT)
```java
public static void rightAngledTriangleRightOrientated(int size, char printChar) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j <= size - i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j <= i; j++) {
            System.out.print(printChar);
        }
        System.out.println();
    }
}
```

### RESULT
```
Enter the number of rows in triangle :: 6
Enter a character to be printed :: a
     a
    aa
   aaa
  aaaa
 aaaaa
aaaaaa
```

### RIGHT ANGLED TRIANGLE (ORIENTATION LEFT)
```java
public static void rightAngledTriangleLeftOrientated(int size, char printChar) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j <= i; j++) {
            System.out.print(printChar);
        }
        System.out.println();
    }
}
```

### RESULT
```
Enter the number of rows in triangle :: 6
Enter a character to be printed :: a
a
aa
aaa
aaaa
aaaaa
aaaaaa
```


### Print Z
```java
public static void printZ(int size) {
    for (int i = 0; i < size; i++) {
        System.out.print("*");
    }
    System.out.print("\n");
    for (int i = 0; i < size - 2; i++) {
        for (int j = 0; j < size - i - 2; j++) {
            System.out.print(" ");
        }
        System.out.print("*\n");
    }
    for (int i = 0; i < size; i++) {
        System.out.print("*");
    }
}
```

### RESULT
```
Enter size of 'Z' :: :: 6
******
    *
   *
  *
 *
******  
```

:+1: