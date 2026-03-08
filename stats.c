#include "stats.h"

int minimum(int *arr, int n)
{
    int min = arr[0];

    for (int i = 1; i < n; i++)
    {
        if (arr[i] < min)
            min = arr[i];
    }
    return min;
}

int maximum(int *arr, int n)
{
    int max = arr[0];

    for (int i = 1; i < n; i++)
    {
        if (arr[i] > max)
            max = arr[i];
    }
   return max;
}

double average(int *arr, int n)
{
     int sum = 0;

    for (int i = 0; i < n; i++)
    {
        sum += arr[i];
    }
   return (double)sum / n;
}

