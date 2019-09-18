/**
 * 12-2.c
 *
 * Solution to exercise 12-2 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <string.h>

/*
 * Reverses the specified string 'str' in place.
 */
static void reverse_str(char str[]) {

    char *ch, *tail;
    char temp;

    /* Moves tail pointer to last character in string */
    for (tail = str; *tail != '\0'; tail++);
    tail--;

    for (ch = str; ch < tail; ch++, tail--) {
        /* Swaps the two opposing characters at pointers in place */
        temp = *ch;
        *ch = *tail;
        *tail = temp;
    }

}

int main(int argc, char **argv) {

    int i;
    char buffer[4096];

    if (argc < 2) {
        printf("USAGE: %s str ...\n", argv[0]);
    }

    for (i = 1; i < argc; i++) {
        strcpy(buffer, argv[i]);
        reverse_str(buffer);
        printf("\"%s\" reversed is: \"%s\"\n", argv[i], buffer);
    }

    return 0;
}

