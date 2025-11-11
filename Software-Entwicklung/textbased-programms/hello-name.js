/*
 * @author Hong-Phuc Bui
 * initial version 27.12.2018
 * */

import {terminal} from "./dfhi.js";


window.main = (...argv) => {
	let name = argv[0];
	terminal.print(`Hallo, ${name}!`)
};