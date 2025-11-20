import {terminal} from "./dfhi.js";

window.main =(...args) => {
    terminal.clear()

    const n = Number(args[0]);
    terminal.print(" ." + "_".repeat(2 * n - 1) + ".\n");

    for (let row = 0; row < n; row++) {
        let line = "|";
        for (let col = 0; col < n; col++) {
            if ((row + col) % 2 === 0) {
                line += "# ";
            } else {
                line += "  ";
            }
        }
        line = line.slice(0, -1) + "|";
        terminal.printh(" " + line + "\n");
    }

    terminal.print(" ." + "-".repeat(2 * n - 1) + ".");

};