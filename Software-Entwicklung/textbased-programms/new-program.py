# Program zum Erstellen ein neu JS-Program
import sys
import os.path

"""
create a HTML and a JS file with the same name.

Require: Python3

Usage:

    new-program.py <program-name>
"""


program_name = sys.argv[1]

html_template = \
"""<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>{program}</title>	
	<link rel="stylesheet" href="dom-output.css" />
	<link rel="stylesheet" href="dfhi.css" />
</head>
<body>
<p class="description">(Passen Sie die Beschreibung des Programs hier an.)</p>
<label for="argv"><code>main</code>'s arguments:</label> <input type="text" id="argv" name="argv" />
<button name="run" id="run" >Rerun</button>


<pre id="text-output"></pre>
<script type="module" src="{program}.js"></script>

</body>
</html>
"""

js_template = \
"""/**
 * {program}.js
 *
 */

import {{terminal}} from "./dfhi.js";

window.main = (...argv) => {{
	terminal.print("{program}");
}};
"""

def write_program(file_name, template, program_name):
    code = template.format(program=program_name)
    # print("Write " + code + " to file " + file_name)
    if os.path.exists(file_name):
        raise ValueError("File " + file_name + " already exists")
    else:
        with open(file_name,"w") as f:
            f.write(code)


write_program(program_name + ".html", html_template, program_name)
write_program(program_name + ".js", js_template, program_name)

