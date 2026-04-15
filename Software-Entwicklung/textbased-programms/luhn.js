/**
 * luhn.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let sumEvent = 0n;
	let sumOdd = 0n;
	let credit = argv[0];

	let n = BigInt(credit.replace(/[-_\s+]/g, ''));
	while(n > 0) {
		sumOdd += (n % 10n);  // modulo division base 10 to get the last digit
		n = n/10n;            // integer division base 10 to shift credit number one digit to right
		let rest = n % 10n;   // get the second-last digit
		let p = rest*2n;
		sumEvent += (p > 9n) ? (p - 9n) : p;
		n = n/10n;
	}
	console.log({sumOdd, sumEvent});
	const sum =(sumEvent + sumOdd) % 10n;
	if (sum === 0n) {
		terminal.printl(`${credit} may be a valid credit number`);
	} else {
		terminal.printl(`${credit} is not a valid credit number`);
	}
};
