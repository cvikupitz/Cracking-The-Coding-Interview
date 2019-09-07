#include <stdio.h>
#include <string.h>

static int isPermutation(char *s1, char *s2) {

    int i;
    int chars[128];
    char *ch;

    if (strlen(s1) != strlen(s2))
        return 0;

    memset(chars, 0, sizeof(chars));
    for (ch = s1; *ch != '\0'; ch++)
        chars[*ch - '\0']++;
    for (ch = s2; *ch != '\0'; ch++)
        chars[*ch - '\0']--;

    for (i = 0; i < 128; i++)
        if (chars[i])
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

