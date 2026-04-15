/**
 * checks if a year is a leap year.
 *
 * @param year {number} a valid year in gregorian calendar
 *
 * @return {boolean} true for a leaf year, false otherwise
 * */
export function isLeapYear(year) {
    let leapYear = (year % 4 === 0);
    leapYear = leapYear && (year % 100 !== 0);
    leapYear = leapYear || (year % 400 === 0);
    return leapYear;
}
/**
 * finds the weekday of a given date by a tuple of (day, month, year).
 *
 * @param {number} day of month (first day in a month is always 1)
 * @param {number} month (1 for January and 12 for December)
 * @param {number} year (a year in Gregorian calendar)
 *
 * @return {number} a number from 0 (Sunday) to 6 (Saturday)
 * */
export function weekDayOfDate(day, month, year) {
    let y0 = year - ((14-month)/12 | 0);
    let x = y0 + ((y0/4)|0) - ((y0/100)|0) + ((y0/400)|0);
    let m0 = month + 12 * ((14-month)/12 |0) - 2;
    return (day + x + ( (31*m0)/12) | 0 ) % 7;
}
/**
 * counts how many days in a month of a year.
 *
 * @param {number} month a number between 1 (for January) and 12 (for December)
 * @param {number} year a valid year in Gregorian calendar system.
 *
 * @return {number} number of days in the given month of the year (28|29|30|31).
 * */
export function countDaysInMonth(month, year) {
    const daysInMonth = [undefined,
        31, 28, 31, 30,
        31, 30, 31, 31,
        30, 31, 30, 31];
    if (month === 2 && isLeapYear(year)) {
        return 29;
    }
    return daysInMonth[month];
}