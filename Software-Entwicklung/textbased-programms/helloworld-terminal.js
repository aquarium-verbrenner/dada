/**
 * 1.1. Aufbau eines javaScript Programms
 *
 * helloworld-terminal.js
 * print "hello-world" auf dem Browser when the user clicks on "Rerun".
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	terminal.printl("Hello world");
};
