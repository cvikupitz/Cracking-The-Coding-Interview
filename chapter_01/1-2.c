/**
 * 1-2.c
 *
 * Solution to exercise 1-2 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <string.h>

/*
 * Returns 1 if 'str1' is a permutation of 'str2', 0 if otherwise. Does NOT
 * ignore punctuation and whitespace, and is case-sensitive.
 */
static int isPermutation(char *s1, char *s2) {

    int i;
    int chars[128];
    char *ch;

    /* Cannot be permutation if lengths are different */
    if (strlen(s1) != strlen(s2))
        return 0;

    /* Increment occurence of each character in str1 */
    memset(chars, 0, sizeof(chars));
    for (ch = s1; *ch != '\0'; ch++)
        chars[*ch - '\0']++;
    /* Decrement occurence of each character in str2 */
    for (ch = s2; *ch != '\0'; ch++)
        chars[*ch - '\0']--;

    /* Assert each character occurence after counting is 0 */
    for (i = 0; i < 128; i++)
        if (chars[i] != 0)
            return 0;

    return 1;
}

int main(int argc, char **argv) {

    if (argc != 3) {
        printf("USAGE: %s str1 str2\n", argv[0]);
        return 0;
    }

    if (isPermutation(argv[1], argv[2]))
        printf("\"%s\" is permutation of \"%s\"\n", argv[1], argv[2]);
    else
        printf("\"%s\" is not a permutation of \"%s\"\n", argv[1], argv[2]);

    return 0;
}

