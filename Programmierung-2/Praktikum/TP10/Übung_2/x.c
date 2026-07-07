#include <stdio.h>

int main() {
    int lignes, colonnes;

    // Ablesen der Maße 
    printf("Geben Sie die Anzahl der Zeilen ein: ");
    scanf("%d", &lignes);
    printf("Geben Sie die Anzahl der Spalten ein: ");
    scanf("%d", &colonnes);
    printf("\n"); 

    // Verschachtelte Schleifen zur Erzeugung der Matrix
    for (int i = 0; i < lignes; i++) {
        for (int j = 0; j < colonnes; j++) {

            // Erste oder letzte Zeile
            if (i == 0 || i == lignes - 1) {
                if (j == 0 || j == colonnes - 1) {
                    printf("*");
                } else {
                    printf("-");
                }
            }
            
            // Zwischenlinien
            else {
                if (j == i || j == (colonnes - 1 - i)) {
                    printf("*");
                } else {
                    printf("-");
                }
            }
        }
        printf("\n"); // Zeilenumbruch für jede Zeile
    }

    printf("\n"); 
    return 0;
}