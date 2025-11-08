/*
 * binary.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let n = BigInt(argv[0]);
	let power = 1n;
	const LIMIT = n / 2n;
	// find the largest power of 2, that <= n/2
	while(power <= LIMIT) {
		power *= 2n;
	}
	let convert = "";
	while(power > 0) {
		if (n < power) {
			convert += "0";
		} else {
			convert += "1";
			n -= power;
		}
		power /= 2n;
	}
	terminal.printl(convert);
};
