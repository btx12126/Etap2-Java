#include <stdio.h>
#include <stdlib.h>
#include "graph.h"

int read_graph(const char *filename, Edge **edges)
{
    FILE *f = fopen(filename, "r");
    if (!f) return -1;

    int capacity = 10;
    int count = 0;

    Edge *e = malloc(capacity * sizeof(Edge));

    while (fscanf(f, "%d %d", &e[count].u, &e[count].v) == 2)
    {
        count++;

        if (count >= capacity)
        {
            capacity *= 2;
            e = realloc(e, capacity * sizeof(Edge));
        }
    }

    fclose(f);
    *edges = e;
    return count;
}

