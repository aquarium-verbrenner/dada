import {weekDayOfDate, countDaysInMonth, isLeapYear} from "./chronos.js";

function nextSunday(day, month, year) {
   let finalArray = [];
   let Day = weekDayOfDate(day, month, year);
   let finalDay = day + (7 - Day);
   let daysInMonth = countDaysInMonth(month, year);
   if (finalDay > daysInMonth) {
      finalArray.push(finalDay - daysInMonth);
      if (month + 1 > 12) {
         finalArray.push(1, year + 1);
      } else {
         finalArray.push(month + 1, year);
      }
   } else {
      finalArray.push(finalDay, month, year);
   }
   return finalArray;
}
console.log(nextSunday(19, 2, 2023));
console.log(nextSunday(28, 2, 2023));
console.log(nextSunday(31, 12, 2023));