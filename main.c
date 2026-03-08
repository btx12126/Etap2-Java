#include <stdio.h>
#include <stdlib.h>
#include "graph.h"
#include "layout.h"

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        printf("Usage: %s graph.txt\n", argv[0]);
        return 1;
    }

    Edge *edges;
    int m = read_graph(argv[1], &edges);

    if (m <= 0)
    {
        printf("Error reading graph\n");
        return 1;
    }
    int n = 10;
    
    double *x = malloc(n * sizeof(double));
    double *y = malloc(n * sizeof(double));

    circle_layout(x, y, n);

    for (int i = 0; i < n; i++)
        printf("%d %.2f %.2f\n", i, x[i], y[i]);

    free(edges);
    free(x);
    free(y);

    return 0;
}
