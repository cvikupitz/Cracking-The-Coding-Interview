CC=gcc
CFLAGS=-W -Wall -g
OBJS=1-1.o 1-2.o 1-3.o 1-4.o
EXECS=1-1 1-2 1-3 1-4

all: 1-1 1-2 1-3

1-1: 1-1.o
	$(CC) $(CFLAGS) 1-1.o -o 1-1

1-2: 1-2.o
	$(CC) $(CFLAGS) 1-2.o -o 1-2

1-3: 1-3.o
	$(CC) $(CFLAGS) 1-3.o -o 1-3

1-4: 1-4.o
	$(CC) $(CFLAGS) 1-4.o -o 1-4

clean:
	rm -f $(OBJS) $(EXECS)

1-1.o: 1-1.c
1-2.o: 1-2.c
1-3.o: 1-3.c

