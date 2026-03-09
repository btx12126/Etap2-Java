#ifndef GRAPH_H
#define GRAPH_H

typedef struct {
    int u;
    int v;
} Edge;

int read_graph(const char *filename, Edge **edges, int *n);

#endif


