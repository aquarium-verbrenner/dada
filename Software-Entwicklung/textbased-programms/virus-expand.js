/**
 * virus-expand.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const n = Number.parseInt(argv[0], 10);
	const k = Number.parseFloat(argv[1]);
	terminal.printl(`n = ${n}`);
	terminal.printl(`k = ${k}`);
	terminal.printl("Min Fälle");
	let term = n;
	let t = 0;
	while (t <= 10) {
		let round = Math.round(term);
		let out = `${t}`;
		if (round !== term) {
			out += ` ${round} (${term})`
		} else {
			out += ` ${round};`
		}
		terminal.printl(out);
		term = term*k;
		t++;
	}
};
