/*
 * @author Hong-Phuc Bui
 * initial version 27.12.2018
 * */

import {terminal} from "./dfhi.js";


window.main = (...argv)=> {
	const a = 12;
	const b = 5;
	const c = Math.floor(a/b); // 2
	const d = (a/b) | 0;
	terminal.print(c, d);
};