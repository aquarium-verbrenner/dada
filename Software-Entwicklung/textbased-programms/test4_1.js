/**
 * @param {Array} result an Array of some text
 * @param {String} targetId an ID of a HTML-div
 * */
function showResult(result, targetId) {
    const target = document.getElementById(targetId);
    for(const text of result) {
        target.innerText += text;
    }
}

