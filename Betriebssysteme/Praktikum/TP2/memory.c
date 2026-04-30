#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

char *arr;

int main() {
    char buf[32];
    unsigned long nrOfElements;
    unsigned long startIndex, touchCount, increment;
    unsigned long index, count;

    printf("process id == %d\n", getpid());
    printf("how many bytes to allocate? ");
    fgets(buf, sizeof(buf), stdin);
    sscanf(buf, "%lu", &nrOfElements);

    if ((arr = malloc(nrOfElements)) == NULL) {
        perror("allocating array");
        return 1;
    }
    printf("allocated %lu bytes starting at %p ...\n", nrOfElements, arr);

    while (1) {
        printf("index of first element to touch? ");
        fgets(buf, sizeof(buf), stdin);
        sscanf(buf, "%lu", &startIndex);
        printf("touch how many elements? ");
        fgets(buf, sizeof(buf), stdin);
        sscanf(buf, "%lu", &touchCount);
        printf("increment between elements? ");
        fgets(buf, sizeof(buf), stdin);
        sscanf(buf, "%lu", &increment);

        for (index = startIndex, count = 0 ;
                count < touchCount ;
                index += increment, ++count) {
            arr[index] = 42;
        }

            printf("index  == %lu\n", index);
    }

    return 0;
}
