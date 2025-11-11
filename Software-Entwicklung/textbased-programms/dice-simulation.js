/*
 * dice-simulation.js
 *
 */

import {terminal} from "./dfhi.js";

/**
 * Simulation eines Würfel
 * */
window.main = (...argv) => {
	const IMG_DIR = "./dice-simulation/assert";

	let min = 1;
	let max = 6;

	let face = Math.floor(Math.random() * (max - min + 1) + min );
	let path = `${IMG_DIR}/${face}.png`;
	let img = `<img width="50px" src="${path}" />`;
	terminal.clear();
	terminal.printh(img);
};
