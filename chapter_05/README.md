# Bit Manipulation

#### 5.1 - Insertion

You are given two 32-bit numbers, _N_ and _M_, and two bit positions, _i_ and _j_. Write a method to insert _M_ into _N_ such that _M_ starts at bit _j_ and ends at bit _i_. You can assume that the bits _j_ through _i_ have enough space to fit all of _M_. That is, if _M_ = 10011, you can assume that there are at least 5 bits between _j_ and _i_. You would not, for example, have _j_ = 3 and _i_ = 2, because _M_ could not fully fit between bit 3 and bit 2.

_EXAMPLE_

Input: N = 10000000000, M = 10011, i = 2, j = 6

Output: N = 10001001100

#### 5.2 - Binary to String

Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation. If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".

#### 5.3 - Flip Bit to Win

You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length of the longest sequence of ls you could create.

_EXAMPLE_

Input: 1775 (or: 11011101111)

Output: 8

#### 5.4 - Next Number

Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits in their binary representation.

#### 5.5 - Debugger

Explain what the following code does:

```c
(( n & ( n - 1 )) == 0)
```

#### 5.6 - Conversion

Write a function to determine the number of bits you would need to flip to convert integer _A_ to integer _B_.

_EXAMPLE_

Input: 29 (or: 11101), 15 (or: 01111)

Output: 2

#### 5.7 - Pairwise Swap

Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

#### 5.8 - Draw Line

A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored in one byte. The screen has width _w_, where _w_ is divisible by 8 (that is, no byte will be split across rows). The height of the screen, of course, can be derived from the length of the array and the width. Implement a function that draws a horizontal line from (_x1_, _y_) to (_x2_, _y_). The method signature should look something like:

```c
drawline(byte[] screen, int width, int xl, int x2, int y)
```
