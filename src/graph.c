#include <stdio.h>
#include <stdlib.h>
#include "graph.h"

int read_graph(const char *filename, Edge **edges, int *n)
{
    FILE *f = fopen(filename, "r");
    if (!f) return -1;

    int capacity = 10;
    int count = 0;
    int max_node = -1;

    Edge *e = malloc(capacity * sizeof(Edge));
    if (!e) { fclose(f); return -1; }

    while (fscanf(f, "%d %d", &e[count].u, &e[count].v) == 2)
    {
        if (e[count].u > max_node) max_node = e[count].u;
        if (e[count].v > max_node) max_node = e[count].v;
        count++;

        if (count >= capacity)
        {
            capacity *= 2;
            Edge *temp = realloc(e, capacity * sizeof(Edge));
            if (temp == NULL) { 
                fprintf(stderr, "Error: Memory reallocation failed\n");
                free(e); 
                fclose(f);
                return -1;
            }
            e = temp;
        }
    }

    fclose(f);
    *edges = e;
    *n = (max_node < 0) ? 0 : max_node + 1;
    return count;
}



