export class Graph {
    #adjList;
    constructor(adjacentList) {
        this.#adjList = JSON.parse(JSON.stringify(adjacentList));
    }

    foreachVertex(callbackFn) {
        for (const v of Object.keys(this.#adjList)) {
            callbackFn(v, this.#adjList[v]);
        }
    }
}