/*
 * prime-bigint.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const n = BigInt(argv[0]);
    // factor is used after the for-loop, therefore var
	for (var factor = 2n; factor <= n/factor; ++factor) {
		if (n % factor === 0n) {
			break;
		}
	}
	if (factor > n/factor) {
		terminal.printl(`${n} ist eine Primzahl`);
	} else {
		terminal.printl(`${n} ist keine Primzahl`);
	}
};
