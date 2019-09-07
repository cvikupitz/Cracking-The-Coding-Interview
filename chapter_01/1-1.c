#include <stdio.h>
#include <string.h>

static int isUnique(char *str) {

    unsigned int i;
    int chars[128];
    char *ch;

    memset(chars, 0, sizeof(chars));
    for (ch = str; *ch != '\0'; ch++)
        chars[*ch - '\0']++;

    for (i = 0; i < 128; i++){
        if (chars[i] > 1)
            return 0;
    }

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
            printf("\"%s\" is not unique\n", argv[i]);

    return 0;
}

