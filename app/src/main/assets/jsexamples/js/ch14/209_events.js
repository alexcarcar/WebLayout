console.log("=== Events (p 209)");

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
		return new Promise(function(resolve, reject) {
			for(let i=countdown.seconds; i>=0; i--) {
				setTimeout(function(){
					if(countdown.superstitious && i===13) {
						return reject(new Error("DEFINITELY NOT COUNTING THAT"));
					}
					// The magic happens when we call countdown.emit('tick', i)
					// Anyone who wants to listen for the "tick" event can do so
					countdown.emit('tick', i);
					if(i===0) resolve();
				}, (countdown.seconds-i)*1000);
			}
		})
	}
}

const c = new Countdown(15, true)
	.on('tick', function(i) { // note we can chain the call to 'on'
		if(i>0) console.log(i + "...");
	});

c.go()
	.then(function() {
		console.log('GO!')
	})
	.catch(function(err) {
		console.error(err.message);
	});
/*
=== Events (p 209)
15...
14...
DEFINITELY NOT COUNTING THAT
12...
11...
10...
9...
8...
7...
6...
5...
4...
3...
2...
1...
*/