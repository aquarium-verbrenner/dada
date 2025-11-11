/**
 * euclidean-algorithm.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let a = Number.parseInt(argv[0], 10);
	let b = Number.parseInt(argv[1], 10);
	let t = b;
	while (b!== 0) {
		t = b;
		b = a % b;
		a = t;
	}

	terminal.printl(a);
};
