/**
 * calendar.js
 *
 */
/**
 * 1 → Januar, 2 → Februar, ... , 12 → Dezember
 *
 * 0 → Sontag, 1 → Montag, ..., 6 → Samstag
 * */

import {terminal} from "./dfhi.js";

const Calendar = {
	months: [undefined,
		"JAN", "FEB", "MÄR", "APR",
		"MAI", "JUN", "JUL", "AUG",
		"SEP", "OKT", "NOV", "DEZ"],
	days: ["SO","MO", "DI", "MI", "DO", "FR", "SA"],
	daysInMonth : [undefined,
		31, 28, 31, 40,
		31, 30, 31, 31,
		30, 31, 30, 31
	],
	firstDay: 1,
	// current date
	date: 1,
	month: 1,
	year: 2021,

	toString: function() {
		return `${this.date}. ${this.month}. ${this.year}`;
	},

	showCalendar: function() {
		let title = `<span class="calendar-title">${this.months[this.month]} ${this.year}</span><br/>\n`;
		let table = `${title}<table><tr>\n`
		// print header
		for(let i = 0; i < this.days.length; ++i) {
			let nameOfDay = this.days[(i+this.firstDay)%7];
			table += `<th>${nameOfDay}</th>`;
		}
		table += "</tr>\n"
		// print (empty) days of last month
		let firstDateOfMonth = new Date(this.year, this.month-1, 1);
		let dayOfFirstDate = firstDateOfMonth.getDay();
		let diff = dayOfFirstDate - this.firstDay;
		let space = "",
			countSpace = diff;
		while(countSpace > 0) {
			--countSpace;
			space += "<td> </td>"
		}
		let firstWeek = "";
		let d = 1;
		for (; d + diff <= 7; d++) {
			firstWeek += `<td>${d}</td>`
		}
		table += `<tr>${space}${firstWeek}</tr>`;
		// append weeks to table
		let week = "";
		let lastDateOfMonth = this.daysInMonth[this.month];
		if (isLeapYear(this.year)) {
			lastDateOfMonth = 29;
		}
		for(;d <= lastDateOfMonth; ++d) {
			week += `<td>${d}</td>`;
			if ( (d + diff) % 7 === 0 ) {
				table += `<tr>${week}</tr>\n`;
				week = "";
			}
		}
		if (week !== "") {
			table += `<tr>${week}</tr>\n`;
		}
		return table;
	},
};

function isLeapYear(year) {
	let leapYear = (year % 4 === 0);
	leapYear = leapYear && (year % 100 !== 0);
	leapYear = leapYear ||  (year % 400 === 0);
	return leapYear;
}

window.main = (...argv) => {
	const month = Number.parseInt(argv[0]);
	const year = Number.parseInt( argv[1] || 2021 );

	Calendar.month = month;
	Calendar.year = year;

	const cal = Calendar.showCalendar();
	terminal.printh(cal);
};

