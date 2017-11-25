console.log("=== The Iteration Protocol (p 177)");

class Log {
	constructor() {
		this.messages = [];
	}
	add(message) {
		this.messages.push({message, timestamp:Date.now()});
	}
	[Symbol.iterator]() {
		let i=0;
		const messages = this.messages;
		return {
			next() {
				if (i>=messages.length) {
					return {value: undefined, done: true};
				} else {
					return {value:messages[i++], done: false};
				}
			}
		}
	}
}

const myLog = new Log();
myLog.add("Test message");
myLog.add("Another message");
console.log(myLog);
for (let entry of myLog) {
	console.log(`${entry.message} @ ${entry.timestamp}`);
}

class FibonacciSequence {
	[Symbol.iterator]() {
		let a=0, b=1;
		return {
			next() {
				let rval = {value:b, done:false};
				b += a;
				a = rval.value;
				return rval;
			}
		};
	}
}
const fib = new FibonacciSequence();
let i = 0;
for (let n of fib) {
	console.log(n);
	if(++i > 9) break;
}
/*
=== The Iteration Protocol (p 177)
Log {
  messages:
   [ { message: 'Test message', timestamp: 1511629700712 },
     { message: 'Another message', timestamp: 1511629700712 } ] }
Test message @ 1511629700712
Another message @ 1511629700712
1
1
2
3
5
8
13
21
34
55
*/