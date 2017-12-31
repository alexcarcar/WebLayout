console.log("=== Filesystem Access (p 289)");

const fs = require('fs');
const path = require('path');

console.log("Directory: " + __dirname.split("assets")[1]);
console.log(`Writing "hello.txt"`);
fs.writeFile(path.join(__dirname, 'hello.txt'), 'hello from Node!', function(err){
	if (err) return console.log('Error writing to file.');
});

console.log("\n=== Examples of Reading/Writing Files");
fs.readFile(path.join(__dirname, 'hello.txt'), function(err, data){
	if (err) return console.log('Error reading file.');
	console.log(`Reading "hello.txt"`);
	console.log(data);
});

fs.readFile(path.join(__dirname, 'hello.txt'), {encoding:'utf8'}, function(err, data){
	if (err) return console.log('Error reading file.');
	console.log(`Reading "hello.txt" (utf8)`);
	console.log(data);
});

try {
	fs.writeFileSync(path.join(__dirname, 'helloSync.txt'), 'hello (sync) from Node!');
} catch(err) {
	console.log('Error writing (sync) file.');
}

try {
	const data = fs.readFileSync(path.join(__dirname, 'helloSync.txt'), {encoding:'utf8'});
	console.log(data);
} catch(err) {
	console.log('Error reading (sync) file.')
}

// removing created files
fs.unlinkSync(path.join(__dirname, 'hello.txt'));
fs.unlinkSync(path.join(__dirname, 'helloSync.txt'));

// listing the contents of the current directory
fs.readdir(__dirname, function(err, files){
	if(err) return console.error('Unable to read directory contents');
	console.log(`Contents of ${__dirname.split("assets")[1]}:`);
	console.log(files.map(f=>'\t'+f).join('\n'));
});
/*
=== Filesystem Access (p 289)
Directory: \jsexamples\js\ch20
Writing "hello.txt"

=== Examples of Reading/Writing Files
hello (sync) from Node!
Contents of \jsexamples\js\ch20:
        287_app.js
        289_files.js
        alexCalculate.js
        app.js
        hello.txt
        mainCalculate.js
        mathLibrary.js
        myDebugLogger.js
        node.html
        simonCalculate.js
Reading "hello.txt" (utf8)
hello from Node!
Reading "hello.txt"
<Buffer 68 65 6c 6c 6f 20 66 72 6f 6d 20 4e 6f 64 65 21>
*/