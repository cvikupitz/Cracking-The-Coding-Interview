# Stacks & Queues

#### 3.1 - Three in One

Describe how you could use a single array to implement three stacks.

#### 3.2 - Stack Min

How would you design a stack which, in addition to _push_ and _pop_, has a function _min_ which returns the minimum element? _Push_, _pop_ and _min_ should all operate in _O(1)_ time.

#### 3.3 - Stack of Plates

Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure _SetOfStacks_ that mimics this. _SetOfStacks_ should be composed of several stacks and should create a new stack once the previous one exceeds capacity. _SetOfStacks.push()_ and _SetOfStacks.pop()_ should behave identically to a single stack (that is, _pop()_ should return the same values as it would if there were just a single stack).

_FOLLOW UP_

Implement a function _popAt(int index)_ which performs a pop operation on a specific sub-stack.

#### 3.4 - Queue via Stacks

Implement a _MyQueue_ class which implements a queue using two stacks.

#### 3.5 - Sort Stack

Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: _push_, _pop_, _peek_, and _isEmpty_.

#### 3.6 - Animal Shelter

An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as _enqueue_, _dequeueAny_, _dequeueDog_, and _dequeueCat_. You may use the built-in linked list data structure.

