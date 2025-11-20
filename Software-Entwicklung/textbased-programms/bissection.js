import {terminal} from "./dfhi.js";

window.main =(...args) => {
    terminal.clear()

    const d = Number(args[0]);
    const alpha = Number(args[2]);
    const Fs = Number(args[3]);
    const s = Number(args[4]);

    function fAlpha (alpha, Fs, s) {
        return (alpha - Math.sin(alpha)) / Math.pow(Math.sin(alpha / 2), 2) - 8 * Fs / (s * s);
    }

    function bissection (Fs, s) {
        let a = 0;
        let b = Math.PI;
        let mid;

        let fa = fAlpha(a, Fs, s);
        let fb = fAlpha(b, Fs, s);

        if(fa * fb > 0) {
            terminal.print("Function does not work, please type other Fs and s values.");
        }

        while
    }


};