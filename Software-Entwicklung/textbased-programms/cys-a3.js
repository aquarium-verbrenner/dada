/**
 * cys-a3.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let a = 0,
		b = 1;
	for(let i = 0; i < 15; ++i) {
		terminal.print(`${a} `);
		a = a + b;
		b = a - b;
	}
};
