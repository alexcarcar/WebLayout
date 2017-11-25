console.log("=== rainbow generator (p 180)");
function* rainbow() {
	yield 'red';
	yield 'orange';
	yield 'yellow';
}
for (let color of rainbow()) {
	console.log(color);
}

function* kids() {
	yield 'Simon';
	yield 'George';
}
for (let kid of kids()) {
	console.log(kid);
}

console.log("=== yield Expressions and Two-Way Communication");
function* interrogate() {
	const name = yield "What is your name?";
	const color = yield "What is your favorite color?";
	return `${name}'s favorite color is ${color}.`;
}
const it = interrogate();
console.log(it.next()); // {value: "What is your name?", done:false}
console.log(it.next('George')); // {value: "What is your favorite color?", done:false}
console.log(it.next('green')); // {value: "George's favorite color is green.", done:true}

function* abc() {
	yield 'a';
	yield 'b';
	return 'c';
}
const itAbc = abc();
console.log(itAbc.next());
console.log(itAbc.next());
console.log(itAbc.next());
console.log(itAbc.next());
for (let l of abc()){
	console.log(l);
}
/*
=== rainbow generator (p 180)
red
orange
yellow
Simon
George
=== yield Expressions and Two-Way Communication
{ value: 'What is your name?', done: false }
{ value: 'What is your favorite color?', done: false }
{ value: 'George\'s favorite color is green.', done: true }
{ value: 'a', done: false }
{ value: 'b', done: false }
{ value: 'c', done: true }
{ value: undefined, done: true }
a
b
*/