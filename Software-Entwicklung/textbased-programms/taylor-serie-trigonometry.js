/**
 * taylor-serie-exp.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	//const x = Number(argv[0]);
	//const x_rad = x * Math.PI / 180;
	const alpha = [0, 30, 45, 60, 90];
	alpha.map(x => x*Math.PI/180).forEach( a => {
		makeTest("Sinus", a, sin, Math.sin);
		makeTest("Cosinus", a, cos, Math.cos);
	});

};


const makeTest = (testName, value, impl, ref) => {
	const result = impl(value);
	const expected = ref(value);
	terminal.print(`${testName} result: ${result} expected : ${expected}\n`);
}

const sin = (x) => {
	let sum = x;
	let term = -(x**3 / 6);
	const xsqr = x*x;
	let g = 1;
	for(let i = 4; sum + term !== sum; i+=2) {
		sum = sum + term;
		g = i*i + i;
		term = - term * (xsqr/g);
	}
	return sum;
}

const cos = (x) => {
	let sum = 1;
	const xsqr = x*x;
	let g = 2;
	let term = -1 * (xsqr / g);
	for(let i = 3; sum + term !== sum; i+=2) {
		sum = sum + term;
		g = i*i + i;
		term = -1 * term * (xsqr/g);
	}
	return sum;
}

