// comma operator (p. 93)
let x=0, y=10, z;
z = (x++, y++);
console.log(x,y,z); // 1 11 10

// void operator (returns undefined)
console.log(void 0); // undefined

let v, v0;
v = v0 = 9.8;
console.log(v, v0); // 9.8 9.8

const nums = [3, 5, 15, 7, 5];
let n, i=0;
while ((n=nums[i])<10, i++<nums.length) {
	console.log(`Number less than 10: ${n}.`);
}
console.log(`Number greater than 10 found: ${n}.`);
console.log(`${nums.length} numbers remain.`);
/*
Number less than 10: 3.
Number less than 10: 5.
Number less than 10: 15.
Number less than 10: 7.
Number less than 10: 5.
Number greater than 10 found: undefined.
5 numbers remain.
*/

// Destructuring Assignment (p. 98)
// a normal object
const obj = {b:2, c:3, d:4};
const {a,b,c} = obj;
console.log(a,b,c, typeof d); // undefined 2 3 'undefined'

const obj2 = {r:4, s:5, t:6};
let r, s, t;
({r,s,t} = obj2);
console.log(r,s,t); // 4 5 6

// Array Destructuring
const arr = [1, 2, 3, 4];
let [x1, x2] = arr;
let [, , , y1] = arr;
console.log(x1, x2, y1); // 1 2 4

let [u1, u2, ...rest] = arr;
console.log(u1, u2, rest); // 1 2 [ 3, 4 ]

let w1 = 5, w2 = 10;
[w1, w2] = [w2, w1];
console.log(w1, w2); // 10 5
