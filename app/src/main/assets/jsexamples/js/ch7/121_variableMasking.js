console.log("=== global scope (p 120)");

// Example 1: global scope
let name = "Irena"; // global
let age = 25; // global
function greet() {
	console.log(`Hello, ${name}!`);
}
function getBirthYear() {
	return new Date().getFullYear() - age;
}
greet();
console.log(getBirthYear());

// Example 2: global scope
let user = {
	name: "Simon",
	age: 10 
}
function greetUser() {
	console.log(`Hello, ${user.name}!`);
}
function getBirthYearUser() {
	return new Date().getFullYear() - user.age;
}
greetUser();
console.log(getBirthYearUser());

// Example 3: global scope
let georgeUser = {
	name: "George",
	age: 3
}
function greetAnyUser(user) {
	console.log(`Hello, ${user.name}!`);
}
function getAnyBirthYearUser(user) {
	return new Date().getFullYear() - user.age;
}
greetAnyUser(georgeUser);
console.log(getAnyBirthYearUser(georgeUser));

console.log("=== Block Scope (p 121)");
// Example 4: block scope
console.log('before block');
{
	console.log('inside block');
	const xInsideBlock = 3;
	console.log(xInsideBlock);
}
console.log(`outside block x=${typeof xInsideBlock}`); // undefined

console.log("=== Variable Masking");
// Example 5: variable masking
{
	// block 1
	const x = 'blue';
	console.log(x);
}
console.log(typeof x);
{
	// block 2
	const x = 3;
	console.log(x);
}
console.log(typeof x);

// Example 6: variable masking (nested)
{
	// outer block
	let x = 'blue'; // blue
	console.log(x);
	{
		// inner block
		let x = 3;
		console.log(x); // 3
	}
	console.log(x); // blue
}
console.log(typeof x); // undefined

// Example 7: variable masking (complicated)
{
	// outer block
	let x = {color: "blue"};
	let y = x; // y and x refer to the same object
	let z = 3;
	{
		// inner block
		let x = 5; // outer x now masked
		console.log(x); // 5
		console.log(y.color); // y (and x in the outer scope) is still in scope
		y.color = "red";
		console.log(z) // 3; z is not masked
	}
	console.log(x.color); // red
	console.log(y.color); // red
	console.log(z);
}

/*
=== global scope (p 120)
Hello, Irena!
1992
Hello, Simon!
2007
Hello, George!
2014
=== Block Scope (p 121)
before block
inside block
3
outside block x=undefined
=== Variable Masking
blue
undefined
3
undefined
blue
3
blue
undefined
5
blue
3
red
red
3
*/