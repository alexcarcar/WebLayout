$(document).ready(function() {
	'use strict';
	const log = console.log;

	class Vehicle {
		constructor() {
			this.passenger = [];
			log("Vehicle created");
		}
		addPassenger(p) {
			this.passenger.push(p);
		}
	}

	class Car extends Vehicle {
		constructor() {
			super();
			log("Car created");
			this.make = "Honda";
		}
		deployAirbags() {
			log("BWOOSH!");
		}
		toString() {
			return `${this.make}`;
		}
	}

	log("---------------------------");
	class Motorcycle extends Vehicle {}
	const c = new Car();
	const m = new Motorcycle();
	/*
	log(c instanceof Car);
	log(c instanceof Vehicle);
	log(m instanceof Car);
	log(m instanceof Motorcycle);
	log(m instanceof Vehicle);
	*/

	log("---------------------------");
	class Super {
		constructor() {
			this.name = 'Super';
			this.isSuper = true;
		}
	}

	// this is valid, but not a good idea...
	Super.prototype.sneaky = 'not recommended!';

	class Sub extends Super {
		constructor() {
			super();
			this.name = 'Sub';
			this.isSub = true;
		}
	}

	const obj = new Sub();
	for (let p in obj) {
		log(`${p}: ${obj[p]}` +
			(obj.hasOwnProperty(p) ? '': ' (inherited)'));
	}
	log("---------------------------");
	log(c.toString());
	log("---------------------------");
	class InsurancePolicy {}
	const ADD_POLICY = Symbol();
	const GET_POLICY = Symbol();
	const IS_INSURED = Symbol();
	const _POLICY = Symbol();
	log("here");
	function makeInsurable(o) {
		o[ADD_POLICY] = function(p) {
			this[_POLICY] = p;
		};
		o[GET_POLICY] = function() {
			return this[_POLICY];
		};
		o[IS_INSURED] = function() {
			return !!this[_POLICY];
		};
	}
	makeInsurable(Car.prototype);
	const car1 = new Car();
	car1[ADD_POLICY](new InsurancePolicy());

	log("---------------------------");
});