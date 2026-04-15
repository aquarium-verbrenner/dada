/*
 * point-to-text.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let points = Number.parseFloat(argv[0]);
	if (points < 0) {
		terminal.printl("Kein gültiger Punkt");
	} else if (points < 40) {
		terminal.printl("Nicht ausreichend");
	} else if (points < 50) {
		terminal.printl("Ausreichend");
	} else if (points < 70) {
		terminal.printl("Befriedigend");
	} else if (points < 90) {
		terminal.printl("Gut")
	} else if (points <= 100) {
		terminal.printl("Sehr gut");
	} else {
		terminal.printl("Kein gültiger Punkt");
	}
};
