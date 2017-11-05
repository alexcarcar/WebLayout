console.log("=== typeof Operator (p 96)");
console.log(undefined, typeof undefined);
console.log(null, typeof null);
console.log({}, typeof {});
console.log(true, typeof true);
console.log(1, typeof 1);
console.log("", typeof "");
console.log(Symbol(), typeof Symbol());
console.log(function() {}, typeof function() {});

console.log("=== void Operator (p 96)");
console.log(void 0);
console.log(void (3+9));

console.log("=== Assignment Operators (p 97)");
let v, v0;
v = v0 = 9.8;
console.log(v, v0);
const nums = [3, 5, 15, 7, 5];
let n, i=0;
while((n=nums[i]) < 10, i++ < nums.length) {
	console.log(`Number less than 10: ${n}.`);
}
console.log(`Number greater than 10 found: ${n}.`);
console.log(`${nums.length} numbers remain.`);

console.log("=== Destructing Assignment (p 98)");
let d;
const obj = {b:2, c:3, d:4};
const {a, b, c} = obj;
console.log(a, b, c, d);

const objX = {x:3, y:1, z:4};
let x, y, z;
({x,y,z} = objX);
console.log(x,y,z);

console.log("=== Array Destructing (p 98)");
const arr = [1, 2, 3];
let [ax, ay] = arr;
console.log(ax, ay);
const arr2 = [1, 2, 3, 4, 5];
let [a2x, a2y, ...a2rest] = arr2;
console.log(a2x, a2y, a2rest);
let switchA = 1228, switchB = 506;
[switchA, switchB] = [switchB, switchA];
console.log(switchA, switchB);

console.log("=== Template Strings (p 100)");
const roomTempC = 21.5;
let currentTempC = 19.5;
const message = `The current temperature is ` +
	`${currentTempC-roomTempC}\u00b0C different than room temperature.`;
const fahrenheit = `The current temperature is ${currentTempC*9/5 +32}\u00b0F`;
console.log(message);
console.log(fahrenheit);

console.log("=== Short-Circuit Logical OR Expressions (p 101)");
let options = null;
if (!options) options = {};
console.log(options);

options = null;
console.log(options,options?true:false);
options = options || {};
console.log(options);

/*
=== typeof Operator (p 96)
undefined 'undefined'
null 'object'
{} 'object'
true 'boolean'
1 'number'
 string
Symbol() 'symbol'
[Function] 'function'
=== void Operator (p 96)
undefined
undefined
=== Assignment Operators (p 97)
9.8 9.8
Number less than 10: 3.
Number less than 10: 5.
Number less than 10: 15.
Number less than 10: 7.
Number less than 10: 5.
Number greater than 10 found: undefined.
5 numbers remain.
=== Destructing Assignment (p 98)
undefined 2 3 undefined
3 1 4
=== Array Destructing (p 98)
1 2
1 2 [ 3, 4, 5 ]
506 1228
=== Template Strings (p 100)
The current temperature is -2°C different than room temperature.
The current temperature is 67.1°F
=== Short-Circuit Logical OR Expressions (p 101)
{}
null false
{}
*/