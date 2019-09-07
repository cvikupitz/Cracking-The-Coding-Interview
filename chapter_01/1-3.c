#include <stdio.h>

static char *URLify(char[] str) {

    return NULL;
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
        printf("\"%s\" URLify: \"%s\"\n", argv[i], buffer);
    }

    return 0;
}

