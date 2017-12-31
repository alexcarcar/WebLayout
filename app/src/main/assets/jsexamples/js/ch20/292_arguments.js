console.log(process.argv);

/* TRIAL 1:
% node 292_arguments.js file1 file2 file3
[ 'C:\\node\\node-v6.11.0-win-x86\\node.exe',
  'C:\\Users\\jsexamples\\js\\ch20\\292_arguments.js',
  'file1',
  'file2',
  'file3' ]
*/

const fs = require('fs');
const filenames = process.argv.slice(2);
console.log(filenames);

/*
[ 'file1', 'file2', 'file3' ]
*/

let counts = filenames.map(f => {
	try {
		const data = fs.readFileSync(f, {encoding:'utf8'});
		return `${f}: ${data.split('\n').length}`;
	} catch(err) {
		return `${f}: couldn't read file`;
	}
});
console.log(counts.join('\n'));

/* TRIAL 1: No files in system:

file1: couldn't read file
file2: couldn't read file
file3: couldn't read file
*/

/* TRIAL 2: Counts the number of lines in each file (i.e. 2)

% echo apple > file1
% echo banana > file2
% echo carrot > file3

file1: 2
file2: 2
file3: 2
*/