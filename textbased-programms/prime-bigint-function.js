/*
 * prime-bigint-function.js
 * Einige Primzahle zum Testen:
 * 22815088913                 (Das Program gibt richtige antwort)
 * 3314192745739               OK
 * 6161791591356884791277      (Das Program kann mit der große Zahl nicht korrekt umgehen)
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	const n = BigInt(argv[0]);
	const primeTest = isPrime(n);
	if (primeTest) {
		terminal.printl(`${n} ist eine Primzahl`);
	} else {
		terminal.printl(`${n} ist keine Primzahl`);
	}
};

const isPrime = (n) => {
	let p = BigInt(n);
	if (p < 2n) {
		return false;
	}
	for(let i = 2n; i <= p/i; ++i) {
		if (p % i === 0n) {
			return false;
		}
	}
	return true;
}