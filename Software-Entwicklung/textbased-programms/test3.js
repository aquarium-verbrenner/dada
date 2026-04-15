let b = 6;
let a = 3;
let start = a;
const rest = a % 7;
if (rest !== 0) {
    start = a + (7 - rest);
}

for (let x = start; x <= b; x += 7) {
    console.log(x);
}
