/*
 * drawing-hands.js
 *
 */

import {terminal} from "./dfhi.js";

const leftHand = () => {
	return rightHand();
}

const rightHand = () => {
	return leftHand();
}

window.main = (...argv) => {
	terminal.printl(leftHand() + " draws first!");
};


