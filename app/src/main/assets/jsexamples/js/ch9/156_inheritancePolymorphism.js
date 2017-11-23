console.log("=== Inheritance (p 156)");

class Vehicle {
	constructor() {
		this.passengers = [];
		console.log("Vehicle created");
	}
	addPassenger(p) {
		this.passengers.push(p);
	}
	toString() {
		return `This vehicle contains: ${this.passengers}`;
	}
}

class Car extends Vehicle {
	constructor() {
		super();
		console.log("Car created");
	}
	deployAirbags() {
		console.log("BWOOSH!");
	}
}

const v = new Vehicle();
v.addPassenger("Simon");
v.addPassenger("George");
console.log(v.passengers);

const c = new Car();
c.addPassenger("Carol");
c.addPassenger("Alex");
console.log(c.passengers);
try {
	v.deployAirbags();
} catch(e) {
	console.log(e.message);
}
c.deployAirbags();

console.log("=== Polymorphism (p 157)");
class Motorcycle extends Vehicle {}
const m = new Motorcycle();
console.log(c instanceof Car, c instanceof Vehicle); // true true
console.log(m instanceof Car, m instanceof Motorcycle, m instanceof Vehicle); // false true true

console.log("=== Enumerating Object Properties (p 158)");
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
	console.log(`${p}: ${obj[p]}` + (obj.hasOwnProperty(p)?'':' (inherited)'));
}
console.log(Object.keys(obj));
console.log(c, c.toString());

console.log("=== Multiple Inheritance, Mixins, and Interfaces (p 160)")
class InsurancePolicy {}
function makeInsurable(o) {
	o.addInsurancePolicy = function(p) {this.insurancePolicy = p;}
	o.getInsurancePolicy = function() {return this.insurancePolicy;}
	o.isInsured = function() {return !!this.insurancePolicy;}
}
makeInsurable(Car.prototype);
const car1 = new Car();
car1.addInsurancePolicy(new InsurancePolicy());
console.log(car1.isInsured(), c.isInsured()); // true false

console.log("=== Using Symbols in Mixins to avoid collisions (p 161)")
class VintageCarPolicy {}
const ADD_POLICY = Symbol();
const GET_POLICY = Symbol();
const IS_INSURED = Symbol();
const _POLICY = Symbol();
function makeVintageInsurable(o) {
	o[ADD_POLICY] = function(p) {this[_POLICY] = p;}
	o[GET_POLICY] = function() {return this[_POLICY];}
	o[IS_INSURED] = function() {return !!this[_POLICY];}
}
makeVintageInsurable(Car.prototype);
const ford1908 = new Car();
ford1908[ADD_POLICY](new VintageCarPolicy());
console.log(car1[IS_INSURED](), ford1908[IS_INSURED](), ford1908.isInsured()); // false true false

/*
=== Inheritance (p 156)
Vehicle created
[ 'Simon', 'George' ]
Vehicle created
Car created
[ 'Carol', 'Alex' ]
v.deployAirbags is not a function
BWOOSH!
=== Polymorphism (p 157)
Vehicle created
true true
false true true
=== Enumerating Object Properties (p 158)
name: Sub
isSuper: true
isSub: true
sneaky: not recommended! (inherited)
[ 'name', 'isSuper', 'isSub' ]
Car { passengers: [ 'Carol', 'Alex' ] } 'This vehicle contains: Carol,Alex'
=== Multiple Inheritance, Mixins, and Interfaces (p 160)
Vehicle created
Car created
true false
=== Using Symbols in Mixins to avoid collisions (p 161)
Vehicle created
Car created
false true false
*/