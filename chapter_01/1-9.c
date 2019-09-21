/**
 * 1-9.c
 *
 * Solution to exercise 1-9 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * Returns 1 if 's2' is a substring that occurs in 's1', 0 if not.
 */
static int isSubstring(char *s1, char *s2) {

    return strstr(s1, s2) != NULL;
}

/*
 * Returns 1 if the specified string 's1' is a rotation of 's2', 0 if otherwise.
 */
static int is_rotation(char *s1, char *s2) {

    char buffer[4096];

    /* Assert both strings are equal length */
    if (strlen(s1) != strlen(s2))
        return 0;

    /* Copy s1 twice in buffer, will then be s1s1 */
    strcpy(buffer, s1);
    strcat(buffer, s1);

    /* s2 is guaranteed to occur in s1s1 */
    return isSubstring(buffer, s2);
}

int main(int argc, char **argv) {

    if (argc != 3) {
        printf("USAGE: %s str1 str2\n", argv[0]);
        return 0;
    }

    if (is_rotation(argv[1], argv[2]))
        printf("\"%s\" is a rotation of \"%s\"\n", argv[1], argv[2]);
    else
        printf("\"%s\" is NOT a rotation of \"%s\"\n", argv[1], argv[2]);

    return 0;
}

