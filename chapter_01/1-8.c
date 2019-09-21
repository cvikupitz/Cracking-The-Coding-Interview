/**
 * 1-8.c
 *
 * Solution to exercise 1-8 from Cracking the Coding Interview, 6th edition.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define ROWS 15      /* Specifies number of rows in matrix */
#define COLUMNS 25   /* Specifies number of columns in matrix */

/*
 * Inserts a set number of 0s into the specified matrix at random points.
 */
#define NUM_ZEROS 8
static void add_matrix_zeros(int matrix[ROWS][COLUMNS]) {

    int k, row, col;

    /* Use time for random seed */
    srand(time(0));
    for (k = 0; k < NUM_ZEROS; k++) {
        /* Retrieve random row and column, set to zero */
        row = ( rand() % ROWS );
        col = ( rand() % COLUMNS );
        matrix[row][col] = 0;
    }
}

/*
 * Sets all numbers in the matrix's specified row index to zero.
 */
static void nullifyRow(int matrix[ROWS][COLUMNS], int row) {

    int i;
    for (i = 0; i < COLUMNS; i++)
        matrix[row][i] = 0;
}

/*
 * Sets all numbers in the matrix's specified column index to zero.
 */
static void nullifyColumn(int matrix[ROWS][COLUMNS], int column) {

    int i;
    for (i = 0; i < ROWS; i++)
        matrix[i][column] = 0;
}

/*
 * Scans the specified matrix for any occuring zeros, then zeros out all
 * rows and columns in the matrix where the zeros occur.
 */
static void scan_matrix_zeros(int matrix[ROWS][COLUMNS]) {

    int i, j;
    int rowZeros[ROWS];
    int colZeros[COLUMNS];

    /* Reset boolean arrays */
    memset(rowZeros, 0, sizeof(rowZeros));
    memset(colZeros, 0, sizeof(colZeros));

    for (i = 0; i < ROWS; i++) {
        for (j = 0; j < COLUMNS; j++) {
            /* Zero detected, mark row and column to nullify */
            if (matrix[i][j] == 0) {
                rowZeros[i] = 1;
                colZeros[j] = 1;
            }
        }
    }

    /* Nullify all marked rows in matrix */
    for (i = 0; i < ROWS; i++)
        if (rowZeros[i] == 1)
            nullifyRow(matrix, i);
    /* Nullify all marked columns in matrix */
    for (i = 0; i < COLUMNS; i++)
        if (colZeros[i] == 1)
            nullifyColumn(matrix, i);
}

/*
 * Prints out the specified integer matrix 'matrix' to standard output.
 */
static void print_matrix(int matrix[ROWS][COLUMNS]) {

    int i, j;

    for (i = 0; i < ROWS; i++) {
        for (j = 0; j < COLUMNS; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

#define UNUSED __attribute__((unused))
int main(UNUSED int argc, UNUSED char **argv) {

    int i, j;
    int matrix[ROWS][COLUMNS];

    for (i = 0; i < ROWS; i++)
        for (j = 0; j < COLUMNS; j++)
            matrix[i][j] = 1;

    add_matrix_zeros(matrix);
    printf("The matrix before:\n");
    print_matrix(matrix);
    printf("\n");

    scan_matrix_zeros(matrix);
    printf("The matrix after:\n");
    print_matrix(matrix);
    printf("\n");

    return 0;
}

