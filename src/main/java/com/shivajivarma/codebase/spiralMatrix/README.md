[Spiral Matrix](README.md)
===============

For given matrix size, print number is __Spiral__ form.


### CODE
```c
int isAnagram(char *a, char *b) {

    int result = 1; // here '1' represents true and '0' represents false

    /* Make a copy string 'b', so that actual 'b' value is not modified while computations. */
    char *bCopy = NULL;
    bCopy = (char *) malloc(strlen(b) * sizeof(char));
    strcpy(bCopy, b);

    /* First compare lengths, if not equal then they are not anagrams. */
    if (strlen(a) == strlen(bCopy)) {

        int flag, i, j;
        /* Loop through string 'a' and find match for each character in string 'bCopy' */
        for (i = 0, flag = 0; i < strlen(a); i++) {

            for (j = 0; j < strlen(bCopy); j++) {
                if (a[i] == bCopy[j]) {
                    flag = 1; // If matching character is found, update the flag to true(1)

                    /* Delete the matching character in bCopy, so that next time we don't repeat search on it. */
                    memmove(bCopy + j, bCopy + j + 1, strlen(bCopy) - j);
                    break;
                }
            }

            if (flag == 0) {
                result = 0;
                break;
            }
        }

    } else {
        result = 0;
    }

    return result;

}
```

### Example
```
Enter N*N Matrix order :: 10

1	36	35	34	33	32	31	30	29	28	
2	37	64	63	62	61	60	59	58	27	
3	38	65	84	83	82	81	80	57	26	
4	39	66	85	96	95	94	79	56	25	
5	40	67	86	97	100	93	78	55	24	
6	41	68	87	98	99	92	77	54	23	
7	42	69	88	89	90	91	76	53	22	
8	43	70	71	72	73	74	75	52	21	
9	44	45	46	47	48	49	50	51	20	
10	11	12	13	14	15	16	17	18	19	
```

:+1:
