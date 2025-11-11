//Ubung 3
let nombre = 13;
let reste;
let binaire = "";

while (nombre > 0) {
    reste = nombre % 2;
    binaire = reste + binaire;
    nombre = Math.floor(nombre / 2);
}
console.log(binaire);