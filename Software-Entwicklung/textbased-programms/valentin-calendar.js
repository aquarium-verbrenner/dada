import {terminal} from "./dfhi.js";

window.main = (...args) => {
    terminal.clear();

    const m = Number(args[0]);
    const y = Number(args[1]);
    const s = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"];

    const y0 = y - Math.floor((14 - m) / 12);
    const x  = y0 + Math.floor(y0 / 4) - Math.floor(y0 / 100) + Math.floor(y0 / 400);
    const m0 = m + 12 * Math.floor((14 - m) / 12) - 2;
    const d0 = (1 + x + Math.floor(31 * m0 / 12)) % 7;

    let joursDansMois = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][m - 1];

    if (m === 2) {
        if ((y % 4 === 0 && y % 100 !== 0) || (y % 400 === 0)) {
            joursDansMois = 29;
        }
    }

    terminal.printl("    " + s[m - 1] + " " + y);
    terminal.printl("Di Lu Ma Me Je Ve Sa");

    let ligne = "";

    for (let i = 0; i < d0; i++) {
        ligne += "   ";
    }

    for (let jour = 1; jour <= joursDansMois; jour++) {
        ligne += (jour < 10 ? " " + jour : jour) + " ";

        if ((jour + d0) % 7 === 0 || jour === joursDansMois) {
            terminal.printl(ligne);
            ligne = "";
        }
    }
};
