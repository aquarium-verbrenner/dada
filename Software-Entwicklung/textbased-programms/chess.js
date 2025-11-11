/**
 * chess.js
 * \
 *   \__________________
 line | Anfangzeichen
 0    | #
 1    | <space>
 2    | #

 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let n = Number.parseInt(argv[0]);
	terminal.clear();
	printTopBottomLine(n);
	const black = '#',
		  white = '*';
	for(let line = 0; line < n; ++line) {
		terminal.print("|");
		for(let row = 0; row < n; ++row) {
			const idx = (row+line) % 2;
			if(idx === 0) {
				terminal.print(black);
			} else {
				terminal.print(white);
			}
		}
		terminal.printl("|");
	}
	printTopBottomLine(n, '-');
};


const printTopBottomLine = (n, symbol='_') => {
	terminal.print('.');
	for(let i = 0; i < n; ++i) {
		terminal.print(symbol);
	}
	terminal.printl('.')
}