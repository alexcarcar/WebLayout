'use strict';

console.log("=== Object Property Attributes (p 303)");
const obj = {foo: "bar", foo2: "bar2"};
console.log(obj);
console.log(Object.getOwnPropertyDescriptor(obj, 'foo'));
Object.defineProperty(obj, 'foo', {writable:false});
try {
	obj.foo = 3;
} catch(err) {
	console.log(err.message);
}
obj.foo2 = 3;
console.log(obj);
console.log(Object.getOwnPropertyDescriptor(obj, 'foo')); // notice foo is still "bar"


console.log("\n=== Define Property (p 304)");
const apple = {name:"apple"};
Object.defineProperty(apple, 'color', {
	// adding an accessor property
	get: function() {
		return this.color;
	},
	set: function(value) {
		this.color = value;
	}
});
console.log(Object.getOwnPropertyDescriptor(apple, 'color'));


const alex = {};
Object.defineProperty(alex, 'name', {
	value: 'Alex'
});
console.log("\n" + alex.name);
Object.defineProperty(alex, 'greet', {
	value: function() { return `Hello, my name is ${this.name}!`; }
});
console.log(alex.greet());

console.log("\n=== Making properties none enumerable (p 305)");
const arr = [3, 1.5, 9, 2, 5.2];
arr.sum = function() {return this.reduce((a,x) => a+x);}
arr.avg = function() {return this.sum()/this.length;}
Object.defineProperty(arr, 'sum', {enumerable:false});
Object.defineProperty(arr, 'avg', {enumerable:false});
Object.defineProperty(arr, 'count', {
	value: function() {return this.reduce((a,x) => a+1)},
	enumerable:false
});
console.log(arr.sum(), arr.avg(), arr.count());

console.log("\n=== Defining multiple properties");
const prime = [2, 3, 5, 11, 13, 17, 19, 23];
Object.defineProperties(prime, {
	sum: {
		value: function() {return this.reduce((a,x) => a+x);},
		enumerable: false
	},
	avg: {
		value: function() {return this.sum()/this.length;},
		enumerable: false
	}});
console.log(prime, prime.sum(), prime.avg());

/*
=== Object Property Attributes (p 303)
{ foo: 'bar', foo2: 'bar2' }
{ value: 'bar',
  writable: true,
  enumerable: true,
  configurable: true }
Cannot assign to read only property 'foo' of object '#<Object>'
{ foo: 'bar', foo2: 3 }
{ value: 'bar',
  writable: false,
  enumerable: true,
  configurable: true }

=== Define Property (p 304)
{ get: [Function: get],
  set: [Function: set],
  enumerable: false,
  configurable: false }

Alex
Hello, my name is Alex!

=== Making properties none enumerable (p 305)
20.7 4.14 7

=== Defining multiple properties
[ 2, 3, 5, 11, 13, 17, 19, 23 ] 93 11.625

*/