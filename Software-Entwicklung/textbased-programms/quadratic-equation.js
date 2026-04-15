/*
 * quadratic-equation.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const a = Number(argv[0]),
		  b = Number(argv[1]),
		  c = Number(argv[2]);
	const delta = b*b - 4*a*c;
	const d = Math.sqrt(delta);
	const x1 = (-b + d) / (2*a),
		  x2 = (-b - d) / (2*a);
	
	terminal.printl(`Equation: ${a}x^2 + (${b})x + (${c})`);
	terminal.printl(`first solution: ${x1}`);
	terminal.printl(`second solution: ${x2}`);
};
