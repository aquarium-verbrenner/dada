/**
 * taylor-serie-exp.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const x = Number.parseFloat(argv[0]);
	const variant1 = exp1(x);
	const variant2 = exp2(x);
	const variant3 = exp3(x);
	const variant4 = exp4(x);
	let expected = Math.exp(x);
	terminal.printl(
		`variant 1: ${variant1} 
variant 2: ${variant2}
variant 3: ${variant3}
variant 4: ${variant4}
expected : ${expected}`
	)
};



const exp1 = (x) => {
	let sum = 1.0;
	const NUM_OF_TERM = 10;
	//DEBUG: let expression = "1";
	for(let n = 1; n <= NUM_OF_TERM; ++n){
		let num = 1.0,
			den = 1.0;
		for (let i = 1; i <= n; ++i) {
			num *= x;
			den *= i;
		}
		//DEBUG: expression += ` + ${num}/${den}`
		sum += num / den;
		//DEBUG: console.log({n, expression});
	}
	return sum;
}

const exp2 = (x) => {
	let sum = 1.0;
	const NUM_OF_TERM = 1000;
	for(let n = 1; n <= NUM_OF_TERM; ++n){
		let term = 1.0;
		for (let i = 1; i <= n; ++i) {
			term *= x/i;
		}
		sum += term;
	}
	return sum;
}

const exp3 = (x) => {
	let sum = 0.0,
		term = 1.0;
	for(let n = 1; sum !== sum + term; ++n) {
		sum += term;
		term = 1.0;
		for (let i = 1; i <= n; ++i) {
			term *= x/i;
		}
	}
	return sum;
}

const exp4 = (x) => {
	let sum = 0.0,
		term = 1.0;
	for(let i = 1; sum !== sum+term; ++i) {
		sum += term;
		term *= x/i;
	}
	return sum;
}



