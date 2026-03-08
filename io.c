#include <stdio.h>
#include <stdlib.h>
#include "io.h"

int read_numbers(const char *filename, int **arr){
     FILE *f = fopen(filename, "r");

    if (!f)
        return -1;

    int capacity = 10;
    int count = 0;

    int *numbers = malloc(capacity * sizeof(int));

    if (!numbers)
    {
        fclose(f);
        return -1;
    }

    while (fscanf(f, "%d", &numbers[count]) == 1)
    {
        count++;

        if (count >= capacity)
        {
            capacity *= 2;

            int *tmp = realloc(numbers, capacity * sizeof(int));

            if (!tmp)
            {
                free(numbers);
                fclose(f);
                return -1;
            }

            numbers = tmp;
        }
    }

    fclose(f);

    *arr = numbers;
    return count;
}

