CC=gcc
CP=g++
CFLAGS=-W -Wall -g
OBJS=12-1.o 12-2.o
EXECS=12-1 12-2

all: $(EXECS)

12-1: 12-1.o
	$(CP) $(CFLAGS) 12-1.o -o 12-1
12-2: 12-2.o
	$(CC) $(CFLAGS) 12-2.o -o 12-2

clean:
	rm -f $(OBJS) $(EXECS)

12-1.o: 12-1.cpp
12-2.o: 12-2.c

