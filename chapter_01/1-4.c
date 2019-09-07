#include <stdio.h>
#include <string.h>

static int isPalindromePermutation(char *str) {

    int i;
    int chars[128];
    char *ch;

    int isOdd = strlen(str) % 2;
    memset(chars, 0, sizeof(chars));
    for (ch = str; *ch != '\0'; ch++)
        chars[*ch - '\0']++;

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
            printf("\"%s\" is not a permutation of a palindrome.\n", argv[i]);

    return 0;
}

