let lecturesData = [
    {   lecture: "javaScript",
        ECTS: 5,
        time: 5.5
    },

    {   lecture: "Programmierung 1",
        ECTS: 8,
        time: 11.5
    },
    
    {   lecture: "Englisch",
        ECTS: 2,
        time: 2.5
    }

];

document.addEventListener("keydown", function(event){
    if (event.key === "Enter"){
        document.getElementById("calculator").click();
    }
});

function TestValues(a, b) {
    if (isNaN(a) || isNaN(b)){
        return false;
    }
    if (a < 0 || b < 0){
        return false;
    }
    return true;
}

function TestResult(totalAufwandproWoche, zeitProDS) {
    if (totalAufwandproWoche < zeitProDS){
        return false;
    }
    return true;
}

function lectureEffortPerWeek(ECTS, vorlesungszeitInWochen, anzahlDS) {
    const totalAufwand = ECTS * 30; 
    const zeitProDS = anzahlDS * 1.5;
    const totalAufwandproWoche = totalAufwand / vorlesungszeitInWochen;
    
    const hausaufwandProWoche = totalAufwandproWoche - zeitProDS;

    if (!TestResult(totalAufwandproWoche, zeitProDS)){
        const resultDiv = document.getElementById("result");
        resultDiv.style.display = "block";
        resultDiv.innerHTML =`
        <p style="color: red;">Die Eingaben müssen überprüft werden.</p>
        <p>Zu viele Stunden/Woche Anwesenheit für die ECTS Anzahl</p>
        `;
        return null;
    }
    
    document.getElementById("result").innerHTML = ""; 
    document.getElementById("result").style.display = "none";

    return {
        "gesamtaufwand": totalAufwand,
        "aufwandProWoche": totalAufwandproWoche,
        "aufwandProDS": zeitProDS,
        "hausaufwandProWoche": hausaufwandProWoche
    };
}

function calculateEffort() {
    const lectureInput = document.getElementById("lecture");
    const ectsInput = document.getElementById("ects");
    const dsInput = document.getElementById("ds");

    const lecture = lectureInput.value;
    const ECTS = parseFloat(ectsInput.value);
    const anzahlDS = parseFloat(dsInput.value);

    if (!TestValues(ECTS, anzahlDS) || lecture.trim() === ""){
        const resultDiv = document.getElementById("result");
        resultDiv.style.display = "block";
        resultDiv.innerHTML = 
        `
        <p style="color: red;">Prüfen Sie Ihre Eingaben.</p>
        <p>Alle Felder müssen ausgefüllt sein</p>
        `;
        return;
    }

    const vorlesungszeitInWochen = 15;
    const result = lectureEffortPerWeek(ECTS, vorlesungszeitInWochen, anzahlDS);
    
    if (!result) {
        return;
    }

    const newLecture = {
        lecture: lecture,
        ECTS: ECTS,
        time: result.hausaufwandProWoche 
    };
    
    lecturesData.push(newLecture);

    addRowsToTable(lecturesData);

    const totalEffort = calculateTotalEffort(lecturesData);
    console.log("Gesamter Hausaufwand aller Fächer:", totalEffort);

    lectureInput.value = "";
    ectsInput.value = "";
    dsInput.value = "";
}

function addRowsToTable(dataArray) {
    const tableBody = document.querySelector("#resultTable tbody");
    
    tableBody.innerHTML = ""; 

    for (const item of dataArray) {
        const timeFormatted = item.time.toFixed(2);

        const newRowHTML = `
            <tr>
                <td>${item.lecture}</td>
                <td>${item.ECTS}</td>
                <td>${timeFormatted} h</td>
            </tr>
        `;

        tableBody.insertAdjacentHTML('beforeend', newRowHTML);
    }
}

function calculateTotalEffort(dataArray) {
    let cpt = 0;
    for (const elem of dataArray){
        cpt += elem.time;
    }
    return cpt;
}

function addrowwithfor(lecture, ECTS, time) {
    const tableBody = document.querySelector("#resultTable tbody");

    for (const item of tableBody){
        let newRowHTML = `
        <tr>
            td>${lecture}</td>
            <td>${ECTS}</td>
            <td>${time} h</td>
        </tr>
    `;
    tableBody.insertAdjacentHTML('beforeend', newRowHTML);
    }
}

function search(lecturesData) {
    let temp = []
    for(let elem of lecturesData){
        if (elem.time >= 5){
            temp.push(elem.lecture)
        }
    }
    return temp
}
console.log(search(lecturesData))