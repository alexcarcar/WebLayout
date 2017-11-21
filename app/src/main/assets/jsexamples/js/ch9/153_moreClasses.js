console.log("=== ES5 functions and ES6 classes");
function Car5(make, model) {
	this.make = make;
	this.model = model;
	this._userGears = ['P', 'N', 'R', 'D'];
	this._userGear = this._userGears[0];
	return this;
}
var honda = Car5("Honda", "Accord");
console.log(honda.make, honda.model, honda._userGear);

class Es6Car {}
function Es5Car() {}
console.log(typeof Es6Car, typeof Es5Car);

console.log("=== prototype examples (p 154)");
class Car {
	constructor(make, model) {
		this.make = make;
		this.model = model;
		this._userGears = ['P', 'N', 'R', 'D'];
		this.userGear = this._userGears[0];
	}

	get userGear() {return this._userGear;}
	set userGear(gear) {
		if (this._userGears.indexOf(gear)<0) {
			throw new Error(`Invalid gear: ${gear}`);
		}
		this._userGear = gear;
	}
	shift(gear) {this.userGear = gear;}
}
const car1 = new Car(), car2 = new Car();
car1.shift('D');
console.log(car1.shift === Car.prototype.shift, car1.userGear); // true 'D'
try {
	car1.shift('d');
} catch(e) {
	console.log(e.message); // invalid gear
}
console.log(car1.shift === car2.shift); // true, all instances point to the same prototype function
car1.shift = function(gear) {this.userGear = gear.toUpperCase();} // similar to overriding
console.log(car1.shift === car2.shift, car1.shift === Car.prototype.shift); // false false
car1.shift('d'); console.log(car1.userGear); // D

console.log("=== Static Methods");
class Auto {
	static getNextVin() {
		return Auto.nextVin++;
	}

	constructor(make, model) {
		this.make = make;
		this.model = model;
		this.vin = Auto.getNextVin();
	}

	static areSimilar(auto1, auto2) {
		return auto1.make===auto2.make && auto1.model===auto2.model;
	}

	static areSame(auto1, auto2) {
		return auto1.vin===auto2.vin;
	}
}
Auto.nextVin = 0;

const auto1 = new Auto("Telsa", "S");
const auto2 = new Auto("Mazda", "3");
const auto3 = new Auto("Mazda", "3");
console.log(auto1.vin, auto2.vin, auto3.vin); // 0 1 2
const similar = Auto.areSimilar;
const same = Auto.areSame;
console.log(similar(auto1, auto2), similar(auto2, auto3)); // false true
console.log(same(auto2, auto3), same(auto2, auto2)); // false true
/*
=== ES5 functions and ES6 classes
Honda Accord P
function function
=== prototype examples (p 154)
true 'D'
Invalid gear: d
true
false false
D
=== Static Methods
0 1 2
false true
false true
*/