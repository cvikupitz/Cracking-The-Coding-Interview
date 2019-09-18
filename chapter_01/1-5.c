/**
 * 1-5.c
 *
 * Solution to exercise 1-5 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <string.h>

/*
 * Returns 1 if 's1' is one character switch away from becoming 's2', 0 if otherwise.
 */
static int oneSwitchAway(char *s1, char *s2) {

    int diff = 1;
    char *c1, *c2;

    for (c1 = s1, c2 = s2; *c1 != '\0'; c1++, c2++)
        if (*c1 != *c2)
            /* Check for difference in characters */
            if (--diff < 0)
                return 0;

    return 1;
}

/*
 * Returns 1 if 's1' is one delete away from becoming 's2', 0 if otherwise.
 */
static int oneDeleteAway(char *s1, char *s2) {

    int offset = 1;
    char *c1, *c2;

    for (c1 = s1, c2 = s2; *c2 != '\0'; c1++, c2++)
        if (*c1 != *c2) {
            /* Check for difference in characters */
            if (--offset < 0)
                return 0;
            /* Skip over the different character */
            c1++;
        }

    return 1;
}

/*
 * Returns 1 if 's1' is one edit away from becoming 's2', 0 if otherwise. The edit
 * can be inserting or deleting a character, or changing one character.
 */
static int oneEditAway(char *s1, char *s2) {

    int x = strlen(s1);
    int y = strlen(s2);

    switch (x - y) {
        /* string length equal, check for one edit away */
        case 0:
            return oneSwitchAway(s1, s2);
        /* string lengths differ by 1, check for insertion/deletion */
        case 1:
            return oneDeleteAway(s1, s2);
        case -1:
            return oneDeleteAway(s2, s1);
        /* string lengths differ by more than 1, cannot be one edit away */
        default:
            return 0;
    }
}

int main(int argc, char **argv) {

    if (argc != 3) {
        printf("USAGE: %s str1 str2\n", argv[0]);
        return 0;
    }

    if (oneEditAway(argv[1], argv[2]))
        printf("\"%s\" is one edit away from \"%s\"\n", argv[1], argv[2]);
    else
        printf("\"%s\" is NOT one edit away from \"%s\"\n", argv[1], argv[2]);

    return 0;
}

