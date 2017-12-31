const fs = require('fs');
fs.readdir('data', function(err,files) {
	if (err) {
		console.error("Fatal error: couldn't read data directory");
		process.exit(1);
	}
	const txtFiles = files.filter(f=>/\.txt/i.test(f));
	if(txtFiles.length===0) {
		console.log("No .txt files to process");
		process.exit(0);
	}
});

/* TRIAL 1: No directory "data"

% node 292_exitCodes.js
Fatal error: couldn't read data directory

*/

/* TRIAL 2: No text files in "data" directory

% mkdir data

% node 292_exitCodes.js
No .txt files to process

*/

/* TRIAL 3: text file in "data" directory

% echo a > data\a.txt

% node 292_exitCodes.js

*/