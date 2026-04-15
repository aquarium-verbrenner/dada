const tECTS = 30;
const lectureEffortPerWeek = (lecture, lectureDuration) => {
    const effortTime = lecture.ECTS * tECTS;
    const timePerWeek = effortTime / lectureDuration;
    const lectureTimeAtHTW = lecture.lectures * 1.5;
    return timePerWeek - lectureTimeAtHTW;
}

const semesterLectures = [
    {ECTS: 5, name: "JavaScript", lectures: 3, inf: true},
    {ECTS: 2, name: "Englisch", lectures: 2, inf: false},
    {ECTS: 5, name: "DatenBanken", lectures: 3, inf: true},
    {ECTS: 3, name: "Interkulturelles Management", lectures: 2, inf: false},
    {ECTS: 8, name: "Programmierung 1", lectures: 3, inf: true},
]

const timeNotInf = semesterLectures
    .filter(l => !l.inf)
    .map(l => lectureEffortPerWeek(l, 15))
    .reduce((s, time) => sum + time, 0);
console.log(timeNotInf);