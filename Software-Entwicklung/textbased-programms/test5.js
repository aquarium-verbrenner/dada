const timeslot = [
    {"begin": "08:15", "end": "09:45" },
    {"begin": "10:00", "end": "11:30" },
    {"begin": "11:45", "end": "13:15" },
    {"begin": "14:15", "end": "15:45" },
    {"begin": "16:00", "end": "17:30" },
    {"begin": "17:45", "end": "19:15" },
];

const htmllist = timeslot.map(t => `<li class="odd" > $(t.begin)`)
console.log(htmllist)