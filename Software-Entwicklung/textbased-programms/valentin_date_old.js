import {terminal} from "./dfhi.js";

window.main = (...args) => {
    terminal.clear();

    const d = Number(args[0]);
    const m = Number(args[1]);
    const y = Number(args[2]);

    const s = "DLMMJVS";
    const e = "iuaeeea";

    const a = Math.floor((14 - m) / 12);
    const y0 = y - a;
    const m0 = m + 12 * a - 2;
    const d0 = (d + y0 + Math.floor(y0 / 4) - Math.floor(y0 / 100) + Math.floor(y0 / 400) + Math.floor((31 * m0) / 12)) % 7;

    terminal.print(s[d0]);
    terminal.print(e[d0]);
};