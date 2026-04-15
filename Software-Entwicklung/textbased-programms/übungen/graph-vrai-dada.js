export class Graph {
    #adjList;
    constructor(adjacentList) {
        this.#adjList = JSON.parse (JSON.stringify(adjacentList) )
    }

    /**
     *@param callbackFunction: 2-stellige Funktion, 1. Arg Knoten,
     * Argument die entsprechende Adjazenliste
     */



    foreachVertex(callbackFunction) {
        for (const v of Object.keys(this.#adjList) ){
            const adj = Object.assign([], this.#adjList[v]);
            callbackFunction(v, adj);
        }
    }
}