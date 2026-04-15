import {isLeapYear, weekDayOfDate, countDaysInMonth} from "./chronos1.js"

function nextSunday(day,month,year) {
    let Array = [];
    let newDay = weekDayOfDate(day, month, year);
    let calculDay = day + 7 - newDay;
    if (calculDay > countDaysInMonth(month, year)) {
        Array.push(calculDay - countDaysInMonth(month, year));
        if (month + 1 > 12) {
            Array.push(1);
            Array.push(year + 1);
        } else {
            Array.push(month + 1, year);
        }
    } else {
        Array.push(calculDay, month, year);
    }
    return Array;
}
console.log(nextSunday(19, 2, 2023));