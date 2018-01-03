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
