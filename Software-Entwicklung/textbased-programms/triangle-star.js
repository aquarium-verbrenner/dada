/*
 * triangle-star.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let n = Number.parseInt(argv[0], 10);
	const character = "*",
		separator = " ";
	let html = "<table>  ";
	//terminal.printh("<table>  ");
	for (let line = 1; line <= n; ++line) {
		//terminal.printh("<tr>");
		html += "<tr>";
		for (let space = n-line; space > 0; --space) {
			//terminal.printh("<td></td>");
			html += "<td></td>";
		}
		for (let star = 1; star <= line; ++star) {
			//terminal.printh(`<td>${character}</td>`);
			html += `<td>${character}</td>`;
			if (star < line) {
				//terminal.printh("<td></td>");
				html += "<td></td>";
			}
		}
		for (let space = n-line; space > 0; --space) {
			//terminal.printh("<td></td>");
			html += "<td></td>"
		}
		//terminal.printh("</tr>");
		html += "</tr>";
	}
	//terminal.printh("</table>");
	html += "</table>";
	terminal.printh(html);
};
