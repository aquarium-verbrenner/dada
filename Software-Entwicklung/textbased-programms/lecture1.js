const tECTS = 30
const lectureEffortPerWeek = (lecture, lectureDuration) => {
    const effortTime = lecture.ECTS * tECTS;
    const timePerWeek=effortTime / lectureDuration;
    const lectureTimeAtHTW =lecture.lectures * 1.5;
    return timePerWeek - lectureTimeAtHTW;
}

const semesterLectures = [
    {ECTS: 5, name: "javascript", lectures: 3, inf: true},
    {ECTS: 2, name: "English", lectures: 2, inf: false},
    {ECTS: 5, name: "Datenbank", lectures: 3, inf: true},
    {ECTS: 3, name: "Interkulturell", lectures: 2, inf: false},
    {ECTS: 8, name: "Prog 1", lectures: 3, inf: true},
]

const timeNoInf = semesterLectures
    .filter(lecture => !lecture.inf)
    .map(lecture => lectureEffortPerWeek(lecture, 15))
    .reduce( (sum, time)=> sum + time, 0 );
console.log(timeNoInf);