#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "graph.h"
#include "layout.h"

int main(int argc, char *argv[])
{
    if (argc < 5)
    {
        printf("Usage: %s graph.txt\n", argv[0]);
        return 1;
    }

    int n =0;
    Edge *edges;
    int m = read_graph(argv[1], &edges, &n);

    if (m <= 0)
    {
        printf("Error reading graph\n");
        return 1;
    }
    
    double *x = malloc(n * sizeof(double));
    double *y = malloc(n * sizeof(double));
    
    if (strcmp(argv[3], "circle") == 0) {
        circle_layout(x, y, n);
    } else {
        random_layout(x, y, n);
    }
    
    if (strcmp(argv[4], "bin") == 0)
{
        FILE *out = fopen(argv[2], "wb");
        if (out) {
            fwrite(&n, sizeof(int), 1, out);
            fwrite(x, sizeof(double), n, out);
            fwrite(y, sizeof(double), n, out);
            fclose(out);
            printf("Ready!\n %s\n", argv[2]);
        }
}
    else 
{
    FILE *out = fopen(argv[2], "w");
    if(out)
    {
        fprintf(out, "%d\n", n);
        for (int i = 0; i < n; i++)
            {
            fprintf(out, "%d %.2f %.2f\n", i, x[i], y[i]);
            }
        fclose(out);
        printf("Ready! \n %s\n", argv[2]);
    } 
}

    free(edges);
    free(x);
    free(y);

    return 0;
}




