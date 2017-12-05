console.log("=== Generators (p 213)");
const fs = require('fs');

// Turning Node's error-first callbacks into promises
// Defining nfcall (Node function call):
function nfcall(f, ...args) {
	return new Promise(function(resolve, reject) {
		f.call(null, ...args, function(err, ...args) {
			if(err) return reject(err);
			resolve(args.length<2 ? args[0] : args);
		});
	});
}

// ptimeout (promise timeout)
function ptimeout(delay) {
	return new Promise(function(resolve, reject) {
		setTimeout(resolve, delay);
	});
}

// Next we'll need a "generator runner"
function grun(g) {
	const it = g();
	(function iterate(val) {
		const x = it.next(val);
		if(!x.done) {
			if(x.value instanceof Promise) {
				x.value.then(iterate).catch(err => it.throw(err));
			} else {
				setTimeout(iterate, 0, x.value);
			}
		}
	})();
}

function* theFutureIsNow() {
	const dataA = yield nfcall(fs.readFile, 'a.txt');
	const dataB = yield nfcall(fs.readFile, 'b.txt');
	const dataC = yield nfcall(fs.readFile, 'c.txt');
	yield ptimeout(2*1000);
	yield nfcall(fs.writeFile, 'd.txt', dataA+dataB+dataC);
}

grun(theFutureIsNow);
/*
% type d.txt
a
b
c
*/