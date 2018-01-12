'use strict';

console.log("=== Freezing (p 306)");
const appInfo = {
	company: 'Alex Software, Inc.',
	version: '1.3.5',
	buildId: '0ad9dfd-390234-ad9032-932c32293',
	copyright() {
		return `(c) ${new Date().getFullYear()}, ${this.company}`;
	}
};
Object.freeze(appInfo);
console.log("Is frozen?", Object.isFrozen(appInfo));
try {appInfo.newProp = 'test'} catch (e) {console.log(e.message);}
try {delete appInfo.company} catch (e) {console.log(e.message);}
try {appInfo.company = 'test'} catch (e) {console.log(e.message);}
try {Object.defineProperty(appInfo, 'company', {enumerable:false});} catch (e) {console.log(e.message);}
console.log(appInfo.copyright());

console.log("\n=== Sealing (p 307)");
class Logger {
	constructor(name) {
		this.name = name;
		this.log = [];
	}
	add(entry) {
		this.log.push({
			log: entry,
			timestamp: Date.now()
		});
	}
}
const log = new Logger("Captain's Log");
Object.seal(log);
console.log("Is sealed?", Object.isSealed(log));
log.name = "Captain's Boring Log"; // OK
log.add("Another boring day at sea..."); // OK
try {log.newProp = 'test'} catch (e) {console.log(e.message);}
console.log(log);
log.name = "test"; // OK
try {delete log.name} catch (e) {console.log(e.message);}
try {Object.defineProperty(log, 'log', {enumerable:false});} catch (e) {console.log(e.message);}
console.log(log);

console.log("\n=== Extensible (p 307)");

