const btnRun = document.getElementById('run');
console.log(btnRun);
btnRun.addEventListener('click', e => {
    const f = document.getElementById('Fs').value;
    const s = document.getElementById('s').value;
    const r = bissection(f, s);
    document.getElementById('text-output').innerHTML = r;
});

function fAlpha (alpha, FS, S) {
    return (alpha - Math.sin(alpha)) / Math.pow(Math.sin(alpha / 2), 2) - 8 * FS / (S * S);
}

function bissection (fs, s, tol = 1e-10) {
    let a = 0.00001;
    let b = Math.PI - 0.00001;
    let mid;

    let fa = fAlpha(a, fs, s);
    let fb = fAlpha(b, fs, s);

    if(fa * fb > 0) {
        console.log("Function does not work, please type other Fs and s values.");
    }

    while ((b - a) > tol) {
        mid = (a + b) / 2;
        let fm = fAlpha(mid, fs, s);

        if (fa * fm <= 0) {
            b = mid;
            fb = fm;
        } else {
            a = mid;
            fa = fm;
        }
    }
    return (a + b) / 2;
}



