/*
 * harmonic.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const n = Number.parseInt(argv[0]);
	let h = 0;
	for(let i = 1; i <=n; ++i) {
		h += 1/i;
	}
	terminal.printl(`H_${n} = ${h}`);
};
