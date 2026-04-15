const tECTS = 30;

const readData = () => {
    const nameValue = document.getElementById('name').value;
    const ectsValue = parseFloat(document.getElementById('ects').value);
    const dsValue = parseFloat(document.getElementById('lecturePerWeek').value);
    const durationValue = parseFloat(document.getElementById('duration').value);
    calculateEffort(nameValue, ectsValue, dsValue, durationValue);
}

const data = []

const lectureEffortPerWeek = (ects, lectureDuration, lecturesPerWeek) => {
    const totalEffortTime = ects * tECTS;
    const timePerWeek = totalEffortTime / lectureDuration;
    const lectureTimeAtHTW = lecturesPerWeek * 1.5;
    return timePerWeek - lectureTimeAtHTW;
};

const calculateEffort = (nameValue, ectsValue, dsValue, durationValue) => {
    const result = lectureEffortPerWeek(ectsValue, durationValue, dsValue);

    document.getElementById('lectureEffort').innerText = result.toLocaleString('de-DE', {
        minimumFractionDigits: 0,
        maximumFractionDigits: 1
    });
    const lecture = {
        name: nameValue,
        ECTS: ectsValue,
        ds: dsValue,
        duration: durationValue,
        effortPerWeek: result
    }
    data.push(lecture);
    console.log(data);
    renderTable(data);
};

const renderTable = (data) => {
    const table = document.getElementById('lectureTableBody');
    let tbody = '';
    for (const l of data) {
        tbody += renderRow(l.name, l.ECTS, l.ds, l.duration, l.effortPerWeek);
    }
    table.innerHTML = tbody;
}

const renderRow = (nameValue, ectsValue, dsValue, durationValue, result) => {

    const row = "<tr>"+`
        <td>${nameValue.toLocaleString('de-DE')}</td>
        <td>${ectsValue.toLocaleString('de-DE')}</td>
        <td>${dsValue.toLocaleString('de-DE')}</td>
        <td>${durationValue.toLocaleString('de-DE')}</td>
        <td>${result.toLocaleString('de-DE', { maximumFractionDigits: 1 })}</td>
    `;
    return row + "</tr>";
};

document.getElementById('calculateEffort').addEventListener('click', readData);