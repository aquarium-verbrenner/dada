/* Übung 4 */

let z = 31567n;
let count = 0;
let d;
let summe = 0n;

while (z > 0n) {
    d = z % 10n;
    z = z / 10n;
    if (count % 2 === 0) {
        summe = summe + d;
    } else {
        let x = d * 2n;
        if (x > 9n) {
            x = x - 9n;
        }
        summe = summe + x;
    }
    count = count + 1;
}

const division = summe % 10n

if (division === 0n) {
    console.log("Luhn Zahl.");
} else {
    console.log("Kein Luhn Zahl.");
}