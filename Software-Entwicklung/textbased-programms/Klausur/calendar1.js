import {weekDayOfDate, countDaysInMonth, isLeapYear} from "./chronos.js";

function showNextSunday() {
    let day = document.getElementById("day");
    let month = document.getElementById("month");
    let year = document.getElementById("year");
    let finalString;
    let Day = weekDayOfDate(day, month, year);
    let finalDay = day + (7 - Day);
    let daysInMonth = countDaysInMonth(month, year);
    if (finalDay > daysInMonth) {
        finalString = finalDay - daysInMonth;
        if (month + 1 > 12) {
            finalString += ".1." + (year + 1);
        } else {
            finalString += "." + (month + 1) + "." + year;
        }
    } else {
        finalString = finalDay + "." + month + "." + year;
    }
    return finalString;
}
console.log(showNextSunday(19, 2, 2023));
console.log(showNextSunday(28, 2, 2023));
console.log(showNextSunday(31, 12, 2023));