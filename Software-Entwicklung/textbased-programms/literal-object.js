/**
 * literal-object.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = (...argv) => {
	let v1 = undefined,
		v2 = undefined,
		v3 = undefined;
	for(let i = 0; i < 3; ++i){
		let obj = {
			key1: "value 1",
			key2: "value 2"
		};
		switch (i) {
			case 0:{v1 = obj; break;}
			case 1:{v2 = obj; break;}
			case 2:{v3 = obj; break;}
		}
	}
    terminal.print(v1);
    terminal.print(v2);
    terminal.print(v3);
};
