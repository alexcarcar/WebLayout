console.log("=== function variables (p 192)");
function addThreeSquareAddFiveTakeSquareRoot(x) {
	return Math.sqrt(Math.pow(x+3,2)+5);
}

const answerOld = (addThreeSquareAddFiveTakeSquareRoot(5) + addThreeSquareAddFiveTakeSquareRoot(2)) / addThreeSquareAddFiveTakeSquareRoot (7);
const f = addThreeSquareAddFiveTakeSquareRoot; // aliasing a function for convenience
const answerNew = (f(5)+f(2))/f(7);
console.log(answerOld, answerNew);

console.log("=== namespacing");
const Money = require('./math-money.js');
console.log(Money.calculate(3,4));

console.log("=== functions in an array as a pipeline (p 193)");
const sin = Math.sin;
const cos = Math.cos;
const theta = Math.PI/4;
const zoom = 2;
const offset = [1, -3];

const pipeline = [
	function rotate(p) {
		console.log(`rotate by ${theta*180/Math.PI} degrees`);
		return {
			x: p.x*cos(theta) - p.y*sin(theta),
			y: p.x*sin(theta) + p.y*cos(theta)
		};
	},
	function scale(p) {
		console.log(`scale by ${zoom}`);
		return {x:p.x*zoom, y:p.y*zoom};
	},
	function translate(p) {
		console.log(`tranlate by ${offset}`);
		return {x:p.x+offset[0], y:p.y+offset[1]};
	}
];

const p = {x:1, y:1};
console.log(p);
let p2 = p;
for (let i=0; i<pipeline.length; i++) {
	p2 = pipeline[i](p2);
	console.log(p2);
}
console.log("=== Pass a Function into a Function (p 194)");
function sum(arr, f) {
	// if no function is supplied, use a "null function" that
	// simply returns its argument unmodified
	if (typeof f != 'function') f = x=> x;
	return arr.reduce((a,x)=> a += f(x), 0);
}
console.log(sum([1,2,3])); // 6
console.log(sum([1,2,3], x=>x*x)); // 1+4+9 = 14
console.log(sum([1,2,3], x=>Math.pow(x,3))); // 1+8+27 = 36

console.log("=== Return a Function from a Function (p 195)");
function simpleSumOfSquares(arr) { // "currying" a function with two arguments into a funciton with one arg
	return sum(arr, x=>x*x)
}
function newSummer(f) {
	return arr => sum(arr, f);
} 
const sumOfSquares = newSummer(x => x*x);
const sumOfCubes = newSummer(x => Math.pow(x,3));
console.log(simpleSumOfSquares([1,2,3]), sumOfSquares([1,2,3]), sumOfCubes([1,2,3]));

console.log("=== Recursion");
function findNeedle(haystack) {
	console.log(haystack);
	if (haystack.length === 0) return "no haystack here";
	if (haystack.shift() === 'needle') return "found it"; // shift destroys the array (in-place)
	return findNeedle(haystack); // haystack has one fewer element
}
const haystack = ['hay','hay','needle','hay'];
console.log(findNeedle(haystack));
console.log(haystack);
console.log(findNeedle(['hay','hay','hay','hay']));

function factorial(n) {
	if (n===1) return 1;
	return n * factorial(n-1);
}
console.log(factorial(10), factorial(3), factorial(1));

/*
=== function variables (p 192)
1.3451659672026264 1.3451659672026264
=== namespacing
5
=== functions in an array as a pipeline (p 193)
{ x: 1, y: 1 }
rotate by 45 degrees
{ x: 1.1102230246251565e-16, y: 1.414213562373095 }
scale by 2
{ x: 2.220446049250313e-16, y: 2.82842712474619 }
tranlate by 1,-3
{ x: 1.0000000000000002, y: -0.17157287525381015 }
=== Pass a Function into a Function (p 194)
6
14
36
=== Return a Function from a Function (p 195)
14 14 36
=== Recursion
[ 'hay', 'hay', 'needle', 'hay' ]
[ 'hay', 'needle', 'hay' ]
[ 'needle', 'hay' ]
found it
[ 'hay' ]
[ 'hay', 'hay', 'hay', 'hay' ]
[ 'hay', 'hay', 'hay' ]
[ 'hay', 'hay' ]
[ 'hay' ]
[]
no haystack here
3628800 6 1
*/