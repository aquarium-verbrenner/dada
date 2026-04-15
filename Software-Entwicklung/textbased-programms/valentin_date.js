import {terminal} from "./dfhi.js";

window.main = (...args) => {
    terminal.clear();

    const d = Number(args[0]);
    const m = Number(args[1]);
    const y = Number(args[2]);

    const days = [
        { id: 0, value: "Dimanche" },
        { id: 1, value: "Lundi" },
        { id: 2, value: "Mardi" },
        { id: 3, value: "Mercredi" },
        { id: 4, value: "Jeudi" },
        { id: 5, value: "Vendredi" },
        { id: 6, value: "Samedi"}
    ];

    const a = Math.floor((14 - m) / 12);
    const y0 = y - a;
    const m0 = m + 12 * a - 2;
    const d0 = (d + y0 + Math.floor(y0 / 4) - Math.floor(y0 / 100) + Math.floor(y0 / 400) + Math.floor((31 * m0) / 12)) % 7;

    const result = days.find((day) => day.id === d0);

    terminal.print(result.value);
};