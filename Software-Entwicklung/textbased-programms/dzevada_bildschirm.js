import {terminal} from "./dfhi.js";

window.main =(...args) => {
    terminal.clear()

    const z = Number(args[0]);
    const n = Number(args[1]);
    const d = Number(args[2]);

    const r = z/n
    const h = d/Math.sqrt(r**2+1)
    const b = r*h


    terminal.print(b + "\n");
    terminal.print(h);
};