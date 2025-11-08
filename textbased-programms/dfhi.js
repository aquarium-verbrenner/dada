/**
 * @author Hong-Phuc Bui
 * initial version 27.12.2018
 *
 * At a glance, this file provides a mini platform to test javascript code as a style of traditional
 * console based programming language. It creates an input field for argument vectors, a div
 * for standard output, and an Object DomOut for printing something to the standard output div.
 *
 * This file can be linked into an HTML File with the tag <script>. To use
 * this file, one must provide a javascript function with signature
 *
 * <pre>
 * window.main = function(... argv)
 * {
 *   // .... code here
 * }
 * </pre>
 *
 * This function is called when the button with id "run" is clicked.A value in input field with id "argv" is split in
 * an array of string and passed to main. Some example how an input are splitted:
 *
 *  *Input*                 → *argv*
 *  hello world             → ["hello", "world"]
 *  Vincent "van Gogh"      → ["vincent", "van Gogh"]
 *  12 34 56                → ["12", "34", "56"]
 *
 * */

import {DomOutput} from "./DomIO.js";
// "private" variable, only for this file
const OUTPUT_ID = 'text-output';
const INPUT_ID = 'argv';
// Create Output Terminal
export let terminal = new DomOutput(OUTPUT_ID);


/**
 *  Calls the function main, if the function main throws any error, print it in the
 *  Terminal and log it into the Browser console.
 *
 *  The input of a user in input-field 'argv' is split to an array, every whitespaces are used as separator.
 *  If a Part of the input is framed in a double or a single quote pair, it is parsed as a single argument.
 *  For Example:
 *
 *  *Input*                 → *argv*
 *  hello world             → ["hello", "world"]
 *  Vincent "van Gogh"      → ["vincent", "van Gogh"]
 *  12 34 56                → ["12", "34", "56"]
 *
 */
function runMain() {
	try {
		if ( typeof main === "function") {
			let argvElement = document.getElementById(INPUT_ID);
			if (argvElement) {
				if (argvElement.files) {
					if (argvElement.files.length > 0) {
						main(...argvElement.files);
					}
				} else {
					let argumentsList = argvElement.value.trim();
					if (argumentsList.length > 0) {
						const parser = {
							"string": /([^\s"]+)|"([^"]*)"/ ,
							"word": /[+\-.\w]+/,
							"space": /\s+/
						};
						let tokens = tokenize(argumentsList, parser, "unknown");
						let argv = [];
						for(const t of tokens) {
							console.log(t);
							if(t.type === "word") {
								argv.push(t.token);
							} else if (t.type === "string") {
								let token = t.token;
								if (token.startsWith('"')) {
									argv.push(token.slice(1, token.length-1));
								} else {
									argv.push(token);
								}
							}
						}
						main(...argv);
					}else {
						main();
					}
				}
			}else {
				main();
			}
		} else {
			throw new Error("Function window.main = function(...argv) is not defined!");
		}
	}catch (ex) {
		console.error(ex);
		terminal.printl(ex);
	}
}


function init() {
	try {
		//Empty every output in console
		//document.getElementById(OUTPUT_ID).innerHTML = "";
		//Student can the test the code in main() by giving something in <input id="run"/>
		document.getElementById("run").addEventListener("click", runMain);
	} catch (e) {
		console.error(e);
	}
}

/**
 * Origin work here: https://gist.github.com/borgar/451393/7698c95178898c9466214867b46acb2ab2f56d68
 * This work is credited to https://gist.github.com/borgar
 *
 * Tiny tokenizer
 *
 * - Accepts a subject string and an object of regular expressions for parsing
 * - Returns an array of token objects
 *
 * tokenize('this is text.', { word:/\w+/, whitespace:/\s+/, punctuation:/[^\w\s]/ }, 'invalid');
 * result => [{ token="this", type="word" },{ token=" ", type="whitespace" }, Object { token="is", type="word" }, ... ]
 *
 */
function tokenize ( s, parsers, deftok ) {
	let m, r, t, tokens = [];
	while ( s ) {
		t = null;
		m = s.length;
		for ( const [key,parser] of Object.entries(parsers) ) {
			r = parser.exec( s );
			// try to choose the best match if there are several
			// where "best" is the closest to the current starting point
			if ( r && ( r.index < m ) ) {
				t = {
					token: r[ 0 ],
					type: key,
					matches: r.slice( 1 )
				}
				m = r.index;
			}
		}
		if ( m ) {
			// there is text between last token and currently
			// matched token - push that out as default or "unknown"
			tokens.push({
				token : s.substr( 0, m ),
				type  : deftok || 'unknown'
			});
		}
		if ( t ) {
			// push current token onto sequence
			tokens.push( t );
		}
		s = s.substr( m + (t ? t.token.length : 0) );
	}
	return tokens;
}

/* call init when DOM is loaded */
document.addEventListener("DOMContentLoaded", init);
