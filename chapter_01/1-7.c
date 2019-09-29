/**
 * 1-7.c
 *
 * Solution to exercise 1-7 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 10   /* Specifies the dimension of the matrix */

/*
 * Randomizes the values inside the cells of the specified matrix.
 */
static void randomize_matrix(int img[N][N]) {

    int val, i, j;
    /* Use time for random seed */
    srand(time(0));

    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            /* Populate cell with random digit */
            val = ( rand() % 10 );
            img[i][j] = val;
        }
    }
}

/*
 * Prints the image matrix out.
 */
void printImage(int img[N][N]) {

    int i, j;

    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            printf("%d ", img[i][j]);
        }
        puts("");
    }
}


/*
 * Rotates the matrix 'img' 90 degrees clockwise in place.
 */
void rotateImage(int img[N][N]) {

    int i, j, temp, offset;

    offset = 0;
    for (i = 0; i < (N / 2); i++) {
        for (j = 0; j < (N - i - offset - 1); j++) {
            /* Save top left pixel */
            temp = img[i][j + offset];
            /* Set top left pixel as bottom left pixel */
            img[i][j+offset] = img[N-1-(j+offset)][i];
            /* Set bottom left pixel as bottom right pixel */
            img[N-1-(j+offset)][i] = img[N-1-i][N-1-(j+offset)];
            /* Set bottom right pixel as top right pixel */
            img[N -1-i][N-1-(j+offset)] = img[j+offset][N-1-offset];
            /* Set top right pixel as top left pixel */
            img[j+offset][N-1-offset] = temp;
        }
        offset++;
    }
}


int main(void) {

    int img[N][N];

    randomize_matrix(img);
    puts("Image before rotation:");
    printImage(img);

    rotateImage(img);
    printf("\nImage after rotation:\n");
    printImage(img);

    return 0;
}

