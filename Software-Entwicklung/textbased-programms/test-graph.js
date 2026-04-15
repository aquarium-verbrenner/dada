import {Graph} from "./graph.js"

function testConstructor() {
    const l = {
        0: [1, 4],
        1: [0, 2, 3],
        2: [1],
        3: [1],
        4: [0]
    };
    const g = new Graph();
    //l[0].push("x");
    l[4].push("x");
    g.foreachVertex((v, adj) => {
     console.log(v);
     console.log(adj);
     adj.push("x");
    });
    g.foreachVertex((v, adj) => {
        console.log(v);
        console.log(adj);
    });
}

testConstructor();