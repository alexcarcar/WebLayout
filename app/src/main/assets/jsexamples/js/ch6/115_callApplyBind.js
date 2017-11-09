console.log("=== call, apply, and bind");

// Example 1: call
const simon = {name: "Simon"};
const george = {name: "George"};
function greet() {
	return `Hello, I'm ${this.name}!`;
}
greet();
console.log(greet.call(simon));
console.log(greet.call(george));

// Example 2: call with arguments
function update(birthYear, occupation) {
	this.birthYear = birthYear;
	this.occupation = occupation;
}
update.call(simon, 2007, "major league baseball player");
update.call(george, 2014, "ceo of a tech company");
console.log(simon);
console.log(george);

// Example 3: apply example (similar to call except it uses an array for arguments)
const carol = {name: "Carol"};
const alex = {name: "Alex"};
update.apply(carol, [1977, "doctor"]);
update.apply(alex, [1972, "software engineer"]);
console.log(carol);
console.log(alex);

// Example 4: apply used to built in methods Math.min and Math.max
const arr = [2, 3, -5, 15, 7];
const minArr = Math.min.apply(null, arr); // this can be null
const maxArr = Math.max.apply(null, arr); // this can be null
console.log(minArr, maxArr);

// Example 5: using the spread operator (...) to mimic apply with call
const newAlex = [1972, "ceo of a tech company"];
update.call(alex, ...newAlex);
console.log(alex);
console.log(Math.min(...arr), Math.max(...arr));

// Example 6: using bind to permanently bind an object to a function
const bruce = {name: "Bruce"};
const updateBruce = update.bind(bruce);
updateBruce(1904, "actor");
console.log(bruce);

// Example 7: using bind with a permenant argument
const updateBruce1949 = update.bind(bruce, 1949);
updateBruce1949("singer, songwriter");
console.log(bruce);

/*
=== call, apply, and bind
Hello, I'm Simon!
Hello, I'm George!
{ name: 'Simon',
  birthYear: 2007,
  occupation: 'major league baseball player' }
{ name: 'George',
  birthYear: 2014,
  occupation: 'ceo of a tech company' }
{ name: 'Carol', birthYear: 1977, occupation: 'doctor' }
{ name: 'Alex',
  birthYear: 1972,
  occupation: 'software engineer' }
-5 15
{ name: 'Alex',
  birthYear: 1972,
  occupation: 'ceo of a tech company' }
-5 15
{ name: 'Bruce', birthYear: 1904, occupation: 'actor' }
{ name: 'Bruce',
  birthYear: 1949,
  occupation: 'singer, songwriter' }
*/
