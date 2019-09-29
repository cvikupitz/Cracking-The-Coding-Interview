/**
 * 6-7.c
 *
 * Solution to exercise 6-7 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(int argc, char **argv) {

    long i, nfamilies, nboys, ngirls;
    int r;

    /* Assert proper usage */
    if (argc != 2) {
        printf("Usage: %s nfamilies\n", argv[0]);
        return 0;
    }

    /* Initialize variables */
    nfamilies = atol(argv[1]);
    nboys = 0L;
    ngirls = 0L;
    srand(time(NULL));

    for (i = 0L; i < nfamilies; i++) {
        /* Keep having children until they have a girl */
        while ((r = rand() % 2) == 0)
            nboys++;
        ngirls++;
    }

    /* Print gendered ratio of final population */
    printf("Boys: %.02f%%\n", 100 * ((double)nboys / (nboys + ngirls)));
    printf("Girls: %.02f%%\n", 100 * ((double)ngirls / (nboys + ngirls)));

    return 0;
}
