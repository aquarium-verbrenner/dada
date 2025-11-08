/**
 * echo.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	terminal.clear();
	for(let arg of argv) {
		terminal.printl(arg);
	}
};
