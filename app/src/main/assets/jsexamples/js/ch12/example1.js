$(document).ready(function() {
	'use strict';
	const log = console.log;
	log("---------------------------------");
	/*
	const book = [
		"Twinkle, twinkle",
		"Little star",
		"How I wonder",
		"What you are"
	];
	const it = book.values(); */
	log("---------------------------------");
	class Log  {
		constructor() {
			this.messages = [];
		}
		add(message) {
			this.messages.push({message, timestamp: Date.now()});
		}
		[Symbol.interator]() {
			return this.messages.values();
		}
	}
	const diary = new Log();
	diary.add("First day at sea");
	diary.add("spotted whale");
	diary.add("spotted another vessel");
	/*
	for(let entry of diary)
		log(`${entry.message} @ ${entry.timestamp}`);
	*/

	log("---------------------------------");
	class FibonacciSequence {
		[Symbol.interator]() {
			let a = 0, b = 1;
			return {
				next() {
					let rval = { value: b, done: false};
					b += a;
					a = rval.value;
					return rval
				}
			};
		}
	}
	const fib = new FibonacciSequence();
	let i = 0;
	/*
	for(let n of fib) {
		log(n);
		if(++i > 9) break;
	}
	*/
	log("---------------------------------");
	function* rainbow() {
		yield 'red';
		yield 'yellow';
		yield 'orange';
		yield 'blue';
	}
	const it = rainbow();
	log(it.next());
	log(it.next());
	log(it.next());
	log(it.next());
	log(it.next());

	log("---------------------------------");
	function* interrogate() {
		let name = yield "What is your name?";
		let color = yield "What is your favorite color?";
		return `${name}'s favorite color is ${color}.`;
	}
	const it2 = interrogate();
	log(it2.next());
	log(it2.next("George"));
	log(it2.next("red"));
	log("---------------------------------");
	function* abc() {
		yield 'a';
		yield 'b';
		return 'c';
	}
	const it3 = abc();
	log(it3.next());
	log(it3.next());
	log(it3.next());
	log(it3.next());
	for(let l of abc()) {
		log(l);
	}
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");

});