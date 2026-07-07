#include <stdio.h>

int main() {
    double nettopreis;

    printf("Geben Sie den Nettopreis ein : ");
    if (scanf("%lf", &nettopreis) != 1) {
        printf("Fehler bei der Eingabe.\n");
        return 1;
    }
 
    double mwst = nettopreis * 0.20;
    double bruttopreis = nettopreis + mwst;
    double skonto = bruttopreis * 0.02;
    double rechnungsbetrag = bruttopreis - skonto;

    printf("\n%-20s Euro %7.2f\n", "Nettopreis", nettopreis);
    printf("%-20s Euro %7.2f\n", "+ 20% MwSt", mwst);
    printf("=================================\n");
    printf("%-20s Euro %7.2f\n", "Bruttopreis", bruttopreis);
    printf("%-20s Euro %7.2f\n", "- 2% Skonto", skonto);
    printf("=================================\n");
    printf("%-20s Euro %7.2f\n", "Rechnungsbetrag", rechnungsbetrag);

    return 0;
}