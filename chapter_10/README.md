# Sorting & Searching

#### 10.1 - Sorted Merge

You are given two sorted arrays, _A_ and _B_, where _A_ has a large enough buffer at the end to hold _B_. Write a method to merge _B_ into _A_ in sorted order.

#### 10.2 - Group Anagrams

Write a method to sort an array of strings so that all the anagrams are next to each other.

#### 10.3 - Search in Rotated Array

Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume that the array was originally sorted in increasing order.

_EXAMPLE_

lnput: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}

Output: 8 (the index of 5 in the array)

#### 10.4 - Sorted Search, No Size

You are given an array-like data structure _Listy_ which lacks a size method. It does, however, have an _elementAt(i)_ method that returns the element at index _i_ in O(1) time. If _i_ is beyond the bounds of the data structure, it returns -1. (For this reason, the data structure only supports positive integers.) Given a _Listy_ which contains sorted, positive integers, find the index at which an element _x_ occurs. If _x_ occurs multiple times, you may return any index.

#### 10.5 - Sparse Search

Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a given string.

_EXAMPLE_

Input: ball, { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" }

Output: 4

#### 10.6 - Sort Big File

Imagine you have a 20 GB file with one string per line. Explain how you would sort the file.

#### 10.7 - Missing Int

Given an input file with four billion non-negative integers, provide an algorithm to generate an integer that is not contained in the file. Assume you have 1 GB of memory available for this task.

_FOLLOW UP_

What if you have only 10 MB of memory? Assume that all the values are distinct and we now have no more than one billion non-negative integers.

#### 10.8 - Find Duplicates

You have an array with all the numbers from 1 to _N_, where _N_ is at most 32,000. The array may have duplicate entries and you do not know what _N_ is. With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?

#### 10.9 - Sorted Matrix Search

Given an _MxN_ matrix in which each row and each column is sorted in ascending order, write a method to find an element.

#### 10.10 - Rank from Stream

Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number _x_ (the number of values less than or equal to _x_). Implement the data structures and algorithms to support these operations. That is, implement the method _track(int x)_, which is called when each number is generated, and the method _getRankOfNumber(int x)_, which returns the number of values less than or equal to _x_ (not including _x_ itself).

_EXAMPLE_

Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3

getRankOfNumber(1) = 0

getRankOfNumber(3) = 1

getRankOfNumber(4) = 3

#### 10.11 - Peaks & Valleys

In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers. For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an array of integers, sort the array into an alternating sequence of peaks and valleys.

_EXAMPLE_

Input: {5, 3, 1, 2, 3}

Output: {5, 1, 3, 2, 3}

