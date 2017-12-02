console.log("=== Error-First Callbacks (p 204)");

const fs = require('fs');
const fname = 'may_or_may_not_exist.txt';
fs.readFile(fname, function(err, data) { // the "err" object is first in the call back
	if (err) return console.error(`error reading file ${fname}: ${err.message.length}`);
	console.log(`${fname} contents: ${data.length}`);
});

const fname2 = '204_errorFirst.js';
fs.readFile(fname2, function(err, data) { // the "err" object is first in the call back
	if (err) return console.error(`error reading file ${fname2}: ${err.message.length}`);
	console.log(`${fname2} contents: ${data.length}`);
});
/*
=== Error-First Callbacks (p 204)
error reading file may_or_may_not_exist.txt: 154
204_errorFirst.js contents: 629
*/