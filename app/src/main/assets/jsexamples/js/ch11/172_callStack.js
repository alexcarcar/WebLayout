console.log("=== The Call Stack (p 172)");
function a() {
	console.log('a: calling b');
	b();
	console.log('a: done');
}

function b() {
	console.log('b: calling c');
	c();
	console.log('b: done');
}

function c() {
	console.log('c: throwing an error');
	throw new Error('c Error');
	console.log('c: done');
}

function d() {
	console.log('d: calling c');
	c();
	console.log('d: done');
}

try {
	a();
} catch(err) {
	console.log(err.stack);
}

try {
	d();
} catch(err) {
	console.log(err.stack);
}

console.log("\n=== try...catch...finally");
try {
	console.log("this line is executed");
	throw new Error("Whoops");
	console.log("this line is not executed");
} catch(err) {
	console.error(`Error: ${err.message}`);
} finally {
	console.log("this line is finally (always) executed");
}

/*
=== The Call Stack (p 172)
a: calling b
b: calling c
c: throwing an error
Error: c Error
    at c (172_callStack.js:16:8)
    at b (172_callStack.js:10:2)
    at a (172_callStack.js:4:2)
    at Object.<anonymous> (172_callStack.js:27:2)
    at Module._compile (module.js:570:32)
    at Object.Module._extensions..js (module.js:579:10)
    at Module.load (module.js:487:32)
    at tryModuleLoad (module.js:446:12)
    at Function.Module._load (module.js:438:3)
    at Module.runMain (module.js:604:10)
d: calling c
c: throwing an error
Error: c Error
    at c (172_callStack.js:16:8)
    at d (172_callStack.js:22:2)
    at Object.<anonymous> (172_callStack.js:33:2)
    at Module._compile (module.js:570:32)
    at Object.Module._extensions..js (module.js:579:10)
    at Module.load (module.js:487:32)
    at tryModuleLoad (module.js:446:12)
    at Function.Module._load (module.js:438:3)
    at Module.runMain (module.js:604:10)
    at run (bootstrap_node.js:389:7)

=== try...catch...finally
this line is executed
Error: Whoops
this line is finally (always) executed
*/