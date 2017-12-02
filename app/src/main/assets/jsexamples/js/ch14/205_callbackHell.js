console.log("=== Callback Hell (p 205)");

const fs = require('fs');
function readSketchyFile() {
	try {
		fs.readFile('does_not_exist.txt', function(err, data) {
			// Note the "err" is thrown in call back function
			// Therefore "err" is not caught because the call back is executed after 
			// execution thread passes the try-catch block
			if(err) throw err;
		});
	} catch(err) {
		console.log('warning: minor issue occured, program continuing');
	}
}
readSketchyFile(); // try catch does not catch error

/*
=== Callback Hell (p 205)
205_callbackHell.js:10
                        if(err) throw err;
                                ^
Error: ENOENT: no such file or directory, open 'does_not_exist.txt' at Error (native)
*/