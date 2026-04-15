const accSum = (flyTime, init = 0) => {
    const acc = [];
    let delay =init;
    for (const t of flyTime) {
        acc.push(t);
        delay = delay + t.DURATION;
        t.DURATION = delay;
    }
    return acc;
}


const accSumPure = (flyTime, init = 0) => {
    const acc = [];
    let delay =init;
    for (const t of flyTime) {
        const c = Object.assign({}, t)
        acc.push(c);
        delay = delay + c.DURATION;
        c.DURATION = delay;
    }
    return acc;
}