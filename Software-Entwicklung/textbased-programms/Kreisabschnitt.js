import {calculateRadius} from "./kreis.js";

const runBnt = document.getElementById("run");
runBnt.addEventListener("click", () => {
    try {
        const fsInput = document.querySelector("#Fs");
        const sInput = document.querySelector("#s");
        const [fs, s] = convertInput(fsInput, sInput);
        console.log({fs, s});
        const [radius,alpha] = calculateRadius(fs, s);
        console.log({radius, alpha});
        const radiusSpan = document.getElementById("radius");
        radiusSpan.innerText = `${radius}`;
        const alphaSpan = document.getElementById("alpha");
        alphaSpan.innerText = `${alpha}`;
    }catch (e) {
        showError(e);
    }
});

const convertInput = (fsInput, sInput) => {
    const fs = fsInput.value;
    const nFs = Number(fs);
    if(isNaN(nFs)) {
        //TODO: set styling von fsInput to error
        throw new Error("Fläche-eingabe ist keine Zahl")
    }
    const s = sInput.value;
    
    const convertInput = (fsInput, sInput) => {
    const fs = fsInput.value;
    const nFs = Number(fs);
    if (isNaN(nFs)) {
        throw new Error("Fläche-eingabe ist keine Zahl");
    }

    const s = sInput.value;
    const nS = Number(s);
    if (isNaN(nS)) {
        throw new Error("Sehnenlänge-eingabe ist keine Zahl");
    }

    return [nFs, nS];
};


const showError = (error) => {
    console.error(error);
}