import {terminal} from "./dfhi.js";

function isLeapYear(year) {
    let leapYear = (year % 4 === 0);
    leapYear = leapYear && (year % 100 !== 0);
    leapYear = leapYear ||  (year % 400 === 0);
    return leapYear;
}

class Calendar {
    static months = [undefined,
        "JANVIER", "FÉVRIER", "MARS", "APRIL",
        "MAI", "JUIN", "JUILLET", "AOÛT",
        "SEPTEMBRE", "OCTOBRE", "NOVEMBRE", "DÉCEMBRE"];

    static days = ["Dim", "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam"];

    static daysInMonth = [undefined,
        31, 28, 31, 30,
        31, 30, 31, 31,
        30, 31, 30, 31
    ];

    constructor(month, year, firstDay = 1) {
        this.date = 1;
        this.month = month;
        this.year = year;
        this.firstDay = firstDay;
    }

    getDaysInMonth() {
        if (this.month === 2 && isLeapYear(this.year)) {
            return 29;
        }
        return Calendar.daysInMonth[this.month];
    }

    toString() {
        return `${this.date}. ${this.month}. ${this.year}`;
    }

    showCalendar() {
        const monthName = Calendar.months[this.month];
        let title = `<span class="calendar-title">${monthName} ${this.year}</span><br/>\n`;
        let table = `${title}<table class="calendar"><tr>\n`;

        for (let i = 0; i < Calendar.days.length; ++i) {
            let nameOfDay = Calendar.days[(i + this.firstDay) % 7];
            table += `<th>${nameOfDay}</th>`;
        }
        table += "</tr>\n";

        const firstDateOfMonth = new Date(this.year, this.month - 1, 1);
        const dayOfFirstDate = firstDateOfMonth.getDay();

        let diff = (dayOfFirstDate - this.firstDay + 7) % 7;

        let space = "";
        for (let i = 0; i < diff; ++i) {
            space += "<td> </td>";
        }

        const lastDateOfMonth = this.getDaysInMonth();
        let dayCounter = 1;
        let week = "";
        let totalCells = 0;

        table += `<tr>${space}`;
        totalCells += diff;

        while (dayCounter <= lastDateOfMonth) {
            week += `<td>${dayCounter}</td>`;
            dayCounter++;
            totalCells++;

            if (totalCells % 7 === 0) {
                table += `${week}</tr>\n`;
                week = "";
                if (dayCounter <= lastDateOfMonth) {
                    table += `<tr>`;
                }
            }
        }

        if (week !== "") {
            while (totalCells % 7 !== 0) {
                week += "<td> </td>";
                totalCells++;
            }
            table += `${week}</tr>\n`;
        }

        table += "</table>";
        return table;
    }
}


window.main = (...argv) => {
    const month1 = Number.parseInt(argv[0] || new Date().getMonth() + 1);
    const year1 = Number.parseInt( argv[1] || new Date().getFullYear() );
    const month2 = Number.parseInt(argv[2] || new Date().getMonth() + 1);
    const year2 = Number.parseInt( argv[3] || new Date().getFullYear() );

    const cal1 = new Calendar(month1, year1, 1);
    const cal2 = new Calendar(month2, year2, 1);

    const output = `
        <div style="display: flex; gap: 40px; justify-content: center;">
            <div style="flex-grow: 1;">
                ${cal1.showCalendar()}
            </div>
            <div style="flex-grow: 1;">
                ${cal2.showCalendar()}
            </div>
        </div>
    `;

    const style = `
        <style>
            .calendar-title { font-weight: bold; font-size: 1.2em; }
            .calendar { border-collapse: collapse; width: 100%; text-align: center; }
            .calendar th, .calendar td { border: 1px solid #ccc; padding: 5px; }
            .calendar th { background-color: #f0f0f0; }
        </style>
    `;

    terminal.printh(style + output);
};