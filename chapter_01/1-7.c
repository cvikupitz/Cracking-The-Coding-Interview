/**
 * 1-7.c
 *
 * Solution to exercise 1-7 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define DIMENSION 12  /* Specifies the matrix dimension (NxN) */

/*
 * Assigns all cells inside the specified matrix 'matrix' with random integers.
 */
static void randomize_matrix(int matrix[DIMENSION][DIMENSION]) {

    int i, j;

    /* Use time for random seed */
    srand(time(0));
    for (i = 0; i < DIMENSION; i++) {
        for (j = 0; j < DIMENSION; j++) {
            /* Assigns the pixel a random integer */
            matrix[i][j] = ( rand() % 10 );
        }
    }
}

/*
 * Rotates the specified matrix 'matrix' to the right in place.
 */
static void rotate_matrix(int matrix[DIMENSION][DIMENSION]) {

    //FIXME
}

/*
 * Prints out the specified integer matrix 'matrix' to standard output.
 */
static void print_matrix(int matrix[DIMENSION][DIMENSION]) {

    int i, j;
    for (i = 0; i < DIMENSION; i++) {
        for (j = 0; j < DIMENSION; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

#define UNUSED __attribute__((unused))
int main(UNUSED int argc, UNUSED char **argv) {

    int matrix[DIMENSION][DIMENSION];

    randomize_matrix(matrix);
    printf("The original matrix:\n");
    print_matrix(matrix);
    printf("\n");

    rotate_matrix(matrix);
    printf("The matrix rotated to the right:\n");
    print_matrix(matrix);
    printf("\n");

    return 0;
}

