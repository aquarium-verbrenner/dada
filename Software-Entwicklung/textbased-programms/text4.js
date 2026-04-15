function f(n) {
    let result = 1;
    for (let i = 2; i <= n; i++) result *= i;
    return result;
}

function Sinus(x, terms = 10) {
    let sum = 0;
    for (let n = 0; n < terms; n++) {
        let sign = n % 2 === 0 ? 1 : -1;
        sum += sign * Math.pow(x, 2 * n + 1) / f(2 * n + 1);
    }
    return sum;
}

function Kosinus(x, terms = 10) {
    let sum = 0;
    for (let n = 0; n < terms; n++) {
        let sign = n % 2 === 0 ? 1 : -1;
        sum += sign * Math.pow(x, 2 * n) / f(2 * n);
    }
    return sum;
}

console.log("sin(1) =", Sinus(1));
console.log("cos(1) =", Kosinus(1));
