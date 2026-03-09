CC = gcc
CFLAGS = -Wall -Wextra -g

all: program

program: main.c graph.c layout.c
	$(CC) $(CFLAGS) main.c graph.c layout.c -o program -lm

clean:
	rm -f program


