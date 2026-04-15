export const calculateRadius = (fs, s) => {
    const alpha = approximateAlpha(fs, s);
    const radius = s/(2*Math.sin(alpha/2));
    return [radius, alpha];
}

const approximateAlpha = (fs, s) => {
    console.log({fs, s});
    const Y = 8*fs/(s**2);
    let left = 0;
    let right = Math.PI;
    // f(alpha) = (alpha - sin(alpha)) / (sin^2(alpha/2))
    const EPSILON = 0.001;
    let alpha = 0 ;
    let y = 0;
    let diff = 2*EPSILON;
    do{
        alpha = (left + right)/2;
        y = (alpha - Math.sin(alpha)) / ( Math.sin(alpha/2)**2 ) ;
        diff = y - Y;
        if(diff < 0) {
            left = alpha;
        }else{
            right = alpha;
        }
    } while( Math.abs(diff) >= EPSILON);
    return alpha;
}

