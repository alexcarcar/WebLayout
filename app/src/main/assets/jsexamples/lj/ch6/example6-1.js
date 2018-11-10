// functions (p. 103)
function sayHello() {
	console.log("hello");
}
sayHello(); // hello

function getGreeting() {
	return "greeting";
}
console.log(getGreeting()); // greeting
console.log(getGreeting); // [Function: getGreeting]
const f = getGreeting;
console.log(f()); // greeting

const o = {};
o.f = getGreeting;
console.log(o.f()); // greeting

const arr = [1, 2, 3];
arr[1] = getGreeting;
console.log(arr[1]()); // greeting

function avg(a,b) {
	return (a+b)/2;
}
console.log(avg(5,10)); // 7.5