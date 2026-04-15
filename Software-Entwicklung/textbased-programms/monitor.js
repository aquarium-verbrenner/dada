/**
 * monitor.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	// b:h als ratio, Bruch (numerator/denominator)
	const numerator = Number.parseFloat(argv[0]);
	const denominator = Number.parseFloat(argv[1]);
	// d als Länge
	const r = numerator / denominator;
	const d = Number.parseFloat(argv[2]);
	const b = (d*r)/Math.sqrt(r*r + 1);
	const h = d/Math.sqrt(r*r + 1);
	terminal.printl("Breite: ", b);
	terminal.printl("Höhe: ", h);
};
