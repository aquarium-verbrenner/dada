import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	if( Math.random() < 0.5) {
		terminal.printl("Kopf");
	} else {
		terminal.printl("Zahl");
	}
};
