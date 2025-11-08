// Übungblatt 1
/*
*
* */

/**
 * helloworld-html.js
 *
 */

import {terminal} from "./dfhi.js";

const G = 6.67430;

window.main = (...argv) => {
    const mass1 = Number(argv[0]);
    const mass2 = Number(argv[1]);
    const r = Number(argv[2]);
    const force = G * mass1 * mass2 / (r*r);
    terminal.printh(`${force} N`);
};
