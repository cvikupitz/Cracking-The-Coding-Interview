/**
 * 1-7.c
 *
 * Solution to exercise 1-7 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>

#define N 6             /* Specifies the dimension of the matrix */
#define ROTATIONS 1     /* Number of rotations to make */


/*
 * Prints the image matrix out.
 */
void printImage(int img[N][N]) {

    int i, j;

    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            printf("%02d ", img[i][j]);
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
    int i, j, val;

    /* Initialize the image matrix */
    val = 1;
    for (i = 0; i < N; i++)
        for (j = 0; j < N; j++)
            img[i][j] = val++;

    /* Print image before rotation(s) */
    puts("Image before rotation:");
    printImage(img);

    /* Rotate image N times, print modified image */
    for (i = 0; i < ROTATIONS; i++)
        rotateImage(img);
    printf("\nImage after %d rotation(s):\n", ROTATIONS);
    printImage(img);

    return 0;
}

