console.log("=== Unsettled Promises (p 212)");

function addTimeout(fn, timeout) {
	if (timeout === undefined) timeout = 1000; // default timeout
	return function(...args) {
		return new Promise(function(resolve, reject){
			const tid = setTimeout(reject, timeout, new Error("promise timed out"));
			fn(...args)
				.then(function(...args) {
					clearTimeout(tid);
					resolve(...args);
				})
				.catch(function(...args) {
					clearTimeout(tid);
					reject(...args);
				});
		});
	}
}

const EventEmitter = require('events').EventEmitter;

// The CountDown class extends EventEmitter, which enables emit events
class Countdown extends EventEmitter {
	constructor(seconds, superstitious) {
		super();
		this.seconds = seconds;
		this.superstitious = !!superstitious;
	}
	// The go method  starts the countdown and returns a promise
	go() {
		const countdown = this;
		const timeoutIds = []; // used to clear unsettled promises
		return new Promise(function(resolve, reject) {
			for(let i=countdown.seconds; i>=0; i--) {
				timeoutIds.push(setTimeout(function(){
					if(countdown.superstitious && i===13) {
						// clear all pending timeouts
						timeoutIds.forEach(clearTimeout); // do not execute remaining timeouts
						return reject(new Error("DEFINITELY NOT COUNTING THAT"));
					}
					// The magic happens when we call countdown.emit('tick', i)
					// Anyone who wants to listen for the "tick" event can do so
					countdown.emit('tick', i);
					if(i===0) resolve();
				}, (countdown.seconds-i)*1000));
			}
		})
	}
}

function launch() {
	return new Promise (function(resolve, reject){
		console.log("Lift off!");
		setTimeout(function(){
			resolve("In orbit!");
		}, 2*1000); // a very fast rocket
	});
}

const c = new Countdown(5).on('tick', i => console.log(i + "..."));

c.go()
	.then(addTimeout(launch, 2*1000))
	.then(function(msg) {
		console.log(msg);
	})
	.catch(function(err) {
		console.error("Houston, we have a problem: " + err.message);
	});
/*
=== Unsettled Promises (p 212)
5...
4...
3...
2...
1...
0...
Lift off!
Houston, we have a problem: promise timed out
*/