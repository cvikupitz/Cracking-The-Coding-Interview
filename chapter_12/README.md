# C & C++

#### 12.1 - Last K Lines

Write a method to print the last _K_ lines of an input file using C++.

#### 12.2 - Reverse String

Implement a function:

```c
void reverse(char *str)
```

in C or C++ which reverses a null-terminated string.

#### 12.3 - Hash Table vs. STL Map

Compare and contrast a hash table and an STL map. How is a hash table implemented? If the number of inputs is small, which data structure options can be used instead of a hash table?

#### 12.4 - Virtual Functions

How do virtual functions work in C++?

#### 12.5 - Shallow vs. Deep Copy

What is the difference between deep copy and shallow copy? Explain how you would use each.

#### 12.6 - Volatile

What is the significance of the keyword "volatile" in C?

#### 12.7 - Virtual Base Class

Why does a destructor in base class need to be declared virtual?

#### 12.8 - Copy Node

Write a method that takes a pointer to a _Node_ structure as a parameter and returns a complete copy of the passed in data structure. The _Node_ data structure contains two pointers to other nodes.

#### 12.9 - Smart Pointer

Write a smart pointer class. A smart pointer is a data type, usually implemented with templates, that simulates a pointer while also providing automatic garbage collection. It automatically counts the number of references to a _SmartPointer<T*>_ object and frees the object of type _T_ when the reference count hits zero.

#### 12.10 - Malloc

Write an aligned malloc and free function that supports allocating memory such that the memory address returned is divisible by a specific power of two.

_EXAMPLE_

_align_malloc(1000, 128)_ will return a memory address that is a multiple of 128 and that points to memory of size 1000 bytes. _aligned_free()_ will free memory allocated by _align_malloc_.

#### 12.11 - 2D Alloc

Write a function in C called _my2DAlloc()_ which allocates a two-dimensional array. Minimize the number of calls to _malloc_ and make sure that the memory is accessible by the notation _arr[i] [j]_.