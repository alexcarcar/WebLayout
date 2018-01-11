console.log("=== Accessing Environmental Variables");
const debug = process.env.DEBUG === "1" ? function() {}: console.log;
debug("Visible only if environment variable DEBUG is not set!");
console.log(`Current directory: ${process.cwd().split("assets")[1]}`);
process.chdir(__dirname);
console.log(`New current directory: ${process.cwd().split("assets")[1]}`);

console.log("\n=== Operating System (p 294)");
const os = require('os');
console.log("Hostname: " + os.hostname().split("M")[1]);
console.log("OS type: " + os.type());
console.log("OS platform: " + os.platform());
console.log("OS release: " + os.release());
console.log("OS uptime: " + (os.uptime()/60/60/24).toFixed(1) + " days");
console.log("CPU architecture: " + os.arch());
console.log("Number of CPUs: " + os.cpus().length);
console.log("Total memory: " + (os.totalmem()/1e6).toFixed(1) + " MB");
console.log("Free memory: " + (os.freemem()/1e6).toFixed(1) + " MB");

console.log("\n=== Child Processes");
const exec = require('child_process').exec;

exec('dir /b 2*.js', function(err, stdout, stderr) {
	if (err) return console.error('Error executing "dir"');
	stdout = stdout.toString();
	console.log(stdout);
	stderr = stderr.toString();
	if(stderr!=='') {
		console.error('error:');
		console.error(stderr);
	}
});

console.log("\n=== Streams (p 296)");
fs = require('fs');
path = require('path');
const ws = fs.createWriteStream('stream.txt', {encoding:'utf8'});
ws.write('line 1\n');
ws.write('line 2\n');
ws.end();

const rs = fs.createReadStream('stream.txt', {encoding:'utf8'});
rs.on('data', function(data) {
	console.log('>> data: ' + data.replace('\n', '\\n'));
});
rs.on('end', function(data) {
	console.log('>> end');
});
const rsCopy = fs.createReadStream('stream.txt', {encoding:'utf8'});
const wsCopy = fs.createWriteStream('stream_copy.txt', {encoding:'utf8'});
rsCopy.pipe(wsCopy);
fs.unlink(path.join(__dirname, 'stream.txt'));
fs.unlink(path.join(__dirname, 'stream_copy.txt'));
/*
=== Accessing Environmental Variables
Visible only if environment variable DEBUG is not set!
Current directory: \jsexamples\js\ch20
New current directory: \jsexamples\js\ch20

=== Operating System (p 294)
Hostname: 3582073
OS type: Windows_NT
OS platform: win32
OS release: 6.1.7601
OS uptime: 0.1 days
CPU architecture: ia32
Number of CPUs: 4
Total memory: 3031.5 MB
Free memory: 372.5 MB

=== Child Processes

=== Streams (p 296)
>> data: line 1\n
>> data: line 2\n
>> end
287_app.js
289_files.js
292_arguments.js
292_exitCodes.js
293_os.js
*/