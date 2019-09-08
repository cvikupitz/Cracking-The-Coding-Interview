/**
 * 1-1.c
 *
 * Solution to exercise 1-1 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <string.h>

/*
 * Returns 1 if the given string 'str' contains all unique characters,
 * or 0 otherwise (the string contains 2 or more occurences of the
 * same character).
 */
static int isUnique(char *str) {

    unsigned int i;
    int chars[128];
    char *ch;

    /* Counts each character occurence in string */
    memset(chars, 0, sizeof(chars));
    for (ch = str; *ch != '\0'; ch++)
        chars[*ch - '\0']++;

    /* Checks if any character has >1 occurence */
    for (i = 0; i < 128; i++){
        if (chars[i] > 1)
            return 0; /* Duplicate characters found */
    }

    /* At this point, no duplicates exist */
    return 1;
}

int main(int argc, char **argv) {

    int i;

    if (argc < 2) {
        printf("Usage: %s str ...\n", argv[0]);
        return 0;
    }

    for (i = 1; i < argc; i++)
        if (isUnique(argv[i]))
            printf("\"%s\" is unique\n", argv[i]);
        else
            printf("\"%s\" is NOT unique\n", argv[i]);

    return 0;
}

