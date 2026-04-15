import {Graph} from "./graph-vrai-dada";

function testConstructor() {
    const l = {
        0: [1, 4],
        1: [0, 2, 3],
        2: [1],
        3: [1],
        4: [0],
    }
    const g = new Graph(l);
    g.foreachVertex((v, adj) => {
        console.log(v);
        console.log(adj);
        adj.push("x")
    });
    console.log ("Test Mutation")
    g.foreachVertex((v, adj) => {
        console.log(v);
        console.log(adj);
    })

}

testConstructor();