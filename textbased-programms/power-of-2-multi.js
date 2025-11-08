/*
 * power-of-2-multi.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const n = Number.parseInt(argv[0], 10);
	let power = 1;
	let i = 0;
	while (i <= n) {
		terminal.printl({i, power});
		power *= 2;
		i += 1;
	}
};