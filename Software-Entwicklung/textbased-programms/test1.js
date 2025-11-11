/* Übung 2 */

const toRadians = (degrees) => degrees * Math.PI / 180;
const toDegrees = (radians) => radians * 180 / Math.PI;
const circleDistance = (x1, x2, y1, y2) => {
    const x1Rad = toRadians(x1);
    const x2Rad = toRadians(x2);
    const y1Rad = toRadians(y1);
    const y2Rad = toRadians(y2);

    const a = Math.sin(x1Rad) * Math.sin(x2Rad);
    const b = Math.cos(x1Rad) * Math.cos(x2Rad) * Math.cos(y1Rad - y2Rad);
    const c = Math.acos(a + b);
    return 60 * toDegrees(c);
};

const X1 = 48.87;
const X2 = 37.8;
const Y1 = -2.33;
const Y2 = 122.4;
const d = circleDistance(X1, X2, Y1, Y2);

console.log(d);