const triangleSerie = () => {
    let n = 0;
    let f = 0;
    return () => {
        n = n + 1
        f = f + n
        return f
    }
}