[Armstrong Number](http://shivajivarma.com/code-base/2014/12/28/armstrong-number/)
===============

An __Armstrong number__ is a number such that the sum of its digits raised to the third power is equal to the number itself.  

For example, 371 is an Armstrong number, since 3^3 + 7^3 + 1^3 = 371.  
Another example, 153. 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153.

> Program to find whether the given number is an Armstrong number or not.

### CODE
```java
public static boolean isArmstrong(int number) {
    int sum = 0, temp = number, digit;

    while (temp != 0) {
        digit = temp % 10;
        sum = sum + (digit * digit * digit);
        temp = temp / 10;
    }
    
    return number == sum;
}
```

:+1:
