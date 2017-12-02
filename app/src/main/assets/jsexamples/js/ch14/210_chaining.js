console.log("=== Promise Chaining (p 210)");

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

//const c = new Countdown(5) // First Run
const c = new Countdown(15, true) // Second Run
	.on('tick', i => console.log(i + "..."));

c.go()
	.then(launch)
	.then(function(msg) {
		console.log(msg);
	})
	.catch(function(err) {
		console.error("Houston, we have a problem...");
	});
/*
=== Promise Chaining (p 210)
5...
4...
3...
2...
1...
0...
Lift off!
In orbit!
=== Promise Chaining (p 210)
15...
14...
Houston, we have a problem...
*/