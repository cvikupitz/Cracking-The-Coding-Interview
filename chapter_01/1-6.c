/**
 * 1-6.c
 *
 * Solution to exercise 1-6 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * Compresses the string 'str'. Returns the compressed version only if it's strictly shorter
 * than 'str', otherwise 'str' is returned back.
 *
 * Compression works as the following:
 *     "aaabcccccaaa" returns "a3b1c5a3"
 *     "aaaaaaaa" returns "a8"
 *     "test" returns "test" (compressed version is longer than original)
 */
static char *str_compress(char *str) {

    char buffer[4096], tmp[2], num[12];
    char *ch;
    int count = 0;

    /* Initialize all arrays */
    memset(buffer, '\0', sizeof(buffer));
    memset(tmp, '\0', sizeof(tmp));
    for (ch = str, tmp[0] = *ch; *ch != '\0'; ch++) {
        /* Counts each consecutive similar character */
        if (tmp[0] == *ch) {
            count++;
        } else {
            /* Appends each character and count to compressed buffer */
            strcat(buffer, tmp);
            sprintf(num, "%d", count);
            strcat(buffer, num);
            /* Reset counter, assign new temp character */
            tmp[0] = *ch;
            count = 1;
        }
    }

    /* Need to append last character to compressed buffer */
    strcat(buffer, tmp);
    sprintf(num, "%d", count);
    strcat(buffer, num);

    /* Return compressed string only if length is strictly less than the original */
    return (strlen(buffer) < strlen(str)) ? buffer : str;
}

int main(int argc, char **argv) {

    int i;

    if (argc < 2) {
        printf("USAGE: %s str ...\n", argv[0]);
        return 0;
    }

    for (i = 1; i < argc; i++)
        printf("\"%s\" compressed: \"%s\"\n", argv[i], str_compress(argv[i]));

    return 0;
}

