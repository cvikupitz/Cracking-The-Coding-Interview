/**
 * 1-3.c
 *
 * Solution to exercise 1-3 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <string.h>

/*
 * Modifies 'str' in place by replacing each space with '%20'.
 */
static char *URLify(char str[]) {

    int i, len, spaces = 0;
    char *ch;

    /* Counts each occurence of blank in string */
    for (ch = str; *ch != '\0'; ch++)
        if (*ch == ' ')
            spaces++;

    /* Compute length of new URLified string */
    i = strlen(str);
    len = i + (spaces * 2);
    str[len] = '\0';

    while (i >= 0) {
        if (str[i] == ' ') {
            /* Replace each space with '%20' */
            str[len] = '0';
            str[len - 1] = '2';
            str[len - 2] = '%';
            len -= 3;
        } else {
            str[len] = str[i];
            len--;
        }
        i--;
    }

    return str;
}

int main(int argc, char **argv) {

    int i;
    char buffer[4096];

    if (argc < 2) {
        printf("USAGE: %s str ...\n", argv[0]);
        return 0;
    }

    for (i = 1; i < argc; i++) {
        strcpy(buffer, argv[i]);
        URLify(buffer);
        printf("\"%s\" URLify: \"%s\"\n", argv[i], buffer);
    }

    return 0;
}

