/*
 * newton-method-sqrt.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const testData = [0, 1.25, 3.758, 4.229, 6.735, 123456.789, (1<<30) + 1];
	for(const c of testData) {
		const cquad = c*c;
		const csqrt = sqrt(cquad);
		const msqrt = Math.sqrt(cquad);
		terminal.printl({"quadrat": cquad, "sqrt":csqrt, "Math.sqrt":msqrt, "expected": c})
	}
};

const sqrt = (c) => {
	const EPSILON = 1E-16;
	let xn = c;
	let q = c/xn; // auxiliary variable to avoid multiple division c/xn
	// !\left| \frac{x^2 - c}{c} \right| > \varepsilon!
	while(Math.abs(xn - q) > EPSILON*q ) { // same as |xn - c/xn| > EPSILON * c/xn
		xn = (q + xn) / 2;
		q = c/xn;
	}
	return xn;
}
