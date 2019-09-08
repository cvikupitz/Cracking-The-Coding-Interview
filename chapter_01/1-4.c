/**
 * 1-4.c
 *
 * Solution to exercise 1-4 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <string.h>
#include <ctype.h>

/*
 * Returns 1 if 'str' is a permutation of a palindrome, 0 if otherwise. Is
 * case-insensitive and ignores all whitespace.
 *
 * e.g. "Taco Cat", "tacocat", and "TACO cat" all return 1.
 */
static int isPalindromePermutation(char *str) {

    int i, k, isOdd, spaces = 0;
    int chars[128];
    char *ch;

    memset(chars, 0, sizeof(chars));
    for (ch = str; *ch != '\0'; ch++) {
        /* Skip over all whitespace */
        if (isspace(*ch)) {
            spaces++;
            continue;
        }
        /* Count occurence of each character */
        k = tolower(*ch - '\0');
        chars[k]++;
    }

    /* Account for odd number of character and spaces */
    isOdd = (strlen(str) - spaces) % 2;
    /* Assert that each character has even number of occurences */
    for (i = 0; i < 128; i++) {
        if (chars[i] % 2 != 0)
            if (--isOdd < 0)
                return 0;
    }

    return 1;
}

int main(int argc, char **argv) {

    int i;

    if (argc < 2) {
        printf("USAGE: %s str ...\n", argv[0]);
        return 0;
    }

    for (i = 1; i < argc; i++)
        if (isPalindromePermutation(argv[i]))
            printf("\"%s\" is a permutation of a palindrome.\n", argv[i]);
        else
            printf("\"%s\" is NOT a permutation of a palindrome.\n", argv[i]);

    return 0;
}

