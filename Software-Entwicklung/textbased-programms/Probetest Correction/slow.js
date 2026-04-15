const provider = [
    {"ag" : "magenta", "speed" : 100, "type" : "ISDN", "peak" : 120},
    {"ag" : "blue", "speed" : 50, "type" : "G4", "peak" : 40},
    {"ag" : "green", "speed" : 400, "type" : "FttH", "peak" : 400},
    {"ag" : "orange", "speed" : 60, "type" : "G3", "peak" : 65},
    {"ag" : "red", "speed" : 200, "type" : "FttH", "peak" : 180},
    {"ag" : "yellow", "speed" : 150, "type" : "ISDN", "peak" : 170},
]

const slow = provider.filter(ag => ag.speed < ag.peak)
console.log(slow);
const mostDiff = provider.reduce((acc, value, idx) => {
    if(acc.length < 1) {
        acc.push(value);
    } else {
        const last = acc[acc.length - 1];
        const diff1 = Math.abs(value.speed - value.peak)
        const diff2 = Math.abs(last.speed - last.peak)
        if (diff1 > diff2) {
            acc[acc.length - 1] = value;
        } else if (diff1 === diff2) {
            acc.push[value]
        }
    }
}, [] )