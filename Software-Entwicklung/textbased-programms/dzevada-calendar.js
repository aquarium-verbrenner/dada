import {terminal} from "./dfhi.js";

window.main =(...args) => {
    terminal.clear()

    const d = Number(args[0]);
    const m = Number(args[1]);
    const y = Number(args[2]);
    const jours = [
        { j: 0, nom: "Dimanche" },
        { j: 1, nom: "Lundi" },
        { j: 2, nom: "Mardi" },
        { j: 3, nom: "Mercredi" },
        { j: 4, nom: "Jeudi" },
        { j: 5, nom: "Vendredi" },
        { j: 6, nom: "Samedi" },
    ];

    const y0 = y - Math.floor(14-m/12)
    const x = y0 + Math.floor(y0/4) - Math.floor(y0/100) + Math.floor(y0/400)
    const m0 = m + 12 * Math.floor(14-m/12) - 2
    const d0 = (d + x + Math.floor(31*m0/12)) % 7

    const resultat = jours.find((jour) => jour.j === d0);

    terminal.print(resultat);
};