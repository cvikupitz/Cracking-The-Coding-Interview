/*
 * 12-1.cpp
 * Author: Cole Vikupitz
 *
 * Exercise 12-1 from Cracking the Coding Interview, 6th edition.
 *
 * Prints the last K lines of a given file.
 */

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>

using namespace std;


int main(int argc, char **argv) {

    ifstream file;
    string line;
    int k, i, nlines, offset;

    /* Assert proper usage */
    if (argc != 3) {
        cout << "Usage: " << argv[0] << " num_lines file_name" << endl;
        return 0;
    }

    /* Parse the number of lines specified */
    k = atoi(argv[1]);
    if (k < 1) {
        cout << "ERROR: num_lines must be > 0" << endl;
        return -1;
    }

    /* Open the specified file to read */
    file.open(argv[2]);
    if (!file.is_open()) {
        cout << "ERROR: failed to open " << argv[2] << endl;
        return -1;
    }

    /* Keep list of K strings to store last lines */
    string lastLines[k];
    /* Initialize other values */
    i = 0;
    nlines = 0;
    while (getline(file, line)) {
        /* Adds the line into list, replace older line if needed */
        lastLines[i] = line;
        i = ((i + 1) % k);
        nlines++;
    }
    
    /* List may be out of order, need to find index of Kth last line to print */
    offset = (nlines % k);
    for (i = 0; i < k; i++) {
        /* Prints each line in list out */
        cout << lastLines[offset] << endl;
        offset = ((offset + 1) % k);
    }
    /* Always close file when done */
    file.close();

    return 0;
}

