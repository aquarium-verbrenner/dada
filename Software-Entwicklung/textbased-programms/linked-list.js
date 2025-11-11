/**
 * linked-list.js
 *
 */

import {terminal} from "./dfhi.js";

window.main = () => {
    let list = {
        head: {
            value: "b",
            next: null
        }
    };
    append(list, "c");
    terminal.printl(toString(list)); // → (head) -> b -> c -> (null)
    insert(list, "a");
    terminal.printl(toString(list)); // → (head) -> a -> b -> c -> (null)
};

const insert = (list, value) => {
	try{
		let head = {
			value: value,
			next: list.head
		};
		list.head = head
	}catch (e) {
		let error = Error("Argument `list` may not have attribute `head`.");
		error.stack += '\nCaused by: '+e.stack;
		throw error;
	}
}

const append = (list, value) => {
	try{
		let nextElement = list.head;
		while(nextElement.next != null) {
			nextElement = nextElement.next;
		}
		nextElement.next = {
			value: value,
			next: null
		}
	} catch (e) {
		let error = Error("Argument `list` may not have attribute `head`.");
		error.stack += '\nCaused by: '+e.stack;
		throw error;
	}
}

const toString = (list) => {
	try{
		let nextElement = list.head;
		let representation = `(head) -> ${nextElement.value}`;
		while(nextElement.next !=null ) {
			nextElement = nextElement.next;
			representation += ` -> ${nextElement.value}`;
		}
		return representation + ` -> (null)`;
	}catch (e) {
		let error = Error("Argument `list` may not have attribute `head`.");
		error.stack += '\nCaused by: '+e.stack;
		throw error;
	}
}



