/**
 * helloworld-html.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let name = argv[0];
	let color = 'blue';
	let greeting = `<span style='color:${color}'>
                    Hallo <b>${name}</b>
                </span>`;
	terminal.printh(greeting);
};
