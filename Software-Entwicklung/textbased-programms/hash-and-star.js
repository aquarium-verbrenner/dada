/**
 * hash-and-star.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let n = Number.parseInt(argv[0]);
	let stars = '<table>';
	// Code to create table (with tr and td....
	let space = '<td> </td>';
	let star = '<td>*</td>';
	// a table with n lines
	for(let line = 0; line < n; ++line) {
		stars += '<tr>';
		// each line has n/2 stars and n/spaces
		for(let col = 0; col < n; ++ col){
			if (col % 2 == 0) {
				stars += star;
			}else {
				stars += space;
			}
		}
		stars += '</tr>';
	}
	stars += '</table>';
	terminal.printh(stars);
};
