// example3-1.js

// p. 34
let currentTempC = 22; // degrees Celsius
currentTempC = 22.5;
console.log(currentTempC); // 22.5

let targetTempC;
console.log(targetTempC); // undefined

// multiple variables with same let statement
let room1 = "conference_room_a", room2 = "lobby"; 

const ROOM_TEMP_C = 21.5, MAX_TEMP_C = 30;
// ROOM_TEMP_C = 3; // TypeError: Assignment to constant variable.
// const NEW_K; // SyntaxError: Missing initializer in const declaration

let count = 10; // integer literal; count is still a double
const blue = 0x0000ff; // hexadecimal (ff = 255)
const umask = 0o0022; // octal (22 = 18)
const roomTemp = 21.5; // decimal
const c = 3.0e6; // 3.0x10^6
const e = -1.6e-19; // -1.6x10^-19
const inf = Infinity;
const ninf = -Infinity;
const nan = NaN; // "not a number"

const small = Number.EPSILON; // approx 2.2e-16
const max = Number.MAX_VALUE;
const maxInt = Number.MAX_SAFE_INTEGER;
const min = Number.MIN_VALUE;
const minInt = Number.MIN_SAFE_INTEGER;
const nInf = Number.NEGATIVE_INFINITY;
const nan2 = Number.NaN;
const pInf = Number.POSITIVE_INFINITY;

console.log("1\n2\r\n3\t4\'\"\`\$\\");
console.log("De Morgan's law: \u2310(P \u22C0 Q) \u21D4 (\u2310P) \u22C1 (\u2310Q)");
console.log("\xc9p\xe9e is fun, but foil is more fun.");
console.log("\01\v2\b3\f4");

let currentTemp = 19.5;
const message = `The current temperature is ${currentTemp}\u00b0C` ;
console.log(message);
const multiline = "line1\
line2";
console.log(multiline);
const multiline2 = `line
line2`;
console.log(multiline2);

console.log(3 + '30'); // 330
console.log(3 * '30'); // 90
let heating = true;
let cooling = false;

const RED = Symbol();
const ORANGE = Symbol("The color of a sunset!");
console.log(RED === ORANGE); // false

const obj = {color:"yellow"};
console.log(obj.size); // undefined
console.log(obj.color); // "yellow"
console.log(obj.size == undefined) // true
console.log(obj.color == undefined) // false
obj["not an identifier"] = 3;
console.log(obj["not an identifier"] + obj["color"]); // 3yellow
const SIZE = Symbol();
obj[SIZE] = 8;
console.log(obj[SIZE]) // 8

const george = {
	name: 'George',
	age: 4
};

const sam = {
	name: 'Sam',
	classification: {
		kingdom: 'Anamalia',
		phylum: 'Chordata',
		class: 'Mamalia',
		order: 'Carnivoria',
		family: 'Felidae',
		subfamily: 'Felinae',
		genus: 'Felis',
		species: 'catus'
	}
};
console.log(sam.classification.family); // Felidae
console.log(sam["classification"].family); // Felidae
console.log(sam.classification["family"]); // Felidae
console.log(sam["classification"]["family"]); // Felidae

sam.speak = function() { return "Meow!"; };
console.log(sam.speak()); // Meow!
delete sam.classification;
delete sam.speak;
console.log(JSON.stringify(sam)); // {"name":"Sam"}

const s = "hello";
console.log(s.toUpperCase()); // HELLO
s.rating = 3;
console.log(s.rating); // undefined

const a1 = [1, 2, 3, 4];
const a2 = [1, 'two', 3, null];
const a3 = [
	"Sentence 1",
	"Sentence 2",
	"Sentence 3",
	"Sentence 4"
];
const a4 = [
	{ name:"Ruby", hardness:9 },
	{ name:"Diamond", hardness:10 },
	{ name:"Topaz", hardness:8 }
];
const a5 = [
	[1, 3, 5],
	[2, 4, 6]
];
console.log(a5[1][1]); // 4
console.log(a4.length); // 3
const arr = [1, 2, 'c', 4, 5];
arr[2] = 3;
console.log(arr); // [ 1, 2, 3, 4, 5 ]

// Dates p. 51
const now = new Date();
console.log(now); // 2018-11-09T13:45:06.171Z
const halloween = new Date(2018, 9, 31); // zero based: 9=October
const halloweenParty = new Date(2018, 9, 31, 19, 0); // 19:00 = 7:00 pm
console.log(halloweenParty.getFullYear());  // 2018
console.log(halloweenParty.getMonth()); // 9
console.log(halloweenParty.getDate()); // 31
console.log(halloweenParty.getDay()); // 3 (Wed; 0:Sun)
console.log(halloweenParty.getHours()); // 19
console.log(halloweenParty.getMinutes()); // 0
console.log(halloweenParty.getSeconds()); // 0
console.log(halloweenParty.getMilliseconds()); // 0

// Regular Expressions p. 52
// extremely simple email recognizer
const email = /\b[a-z0-9._-]+@[a-z_-]+(?:\.[a-z]+)+\b/;
const testEmail = "alex@mycompany.com";
const testEmail2 = "alex-notemail-mycompany.com";
console.log(testEmail.match(email) != null); // true
console.log(testEmail2.match(email) != null); // false

// US phone number recognizer
const phone = /(:?\+1)?(:?\(\d{3}\)\s?|\d{3}[\s-]?)\d{3}[\s-]?\d{4}/;
const testPhone = "1-415-123-1234";
const testPhone2 = "1-415-123-a12345";
console.log(testPhone.match(phone) != null); // true
console.log(testPhone2.match(phone) != null); // false

// Converting to Numbers
const numStr = "33.3";
const num = Number(numStr); // this creates a number value, *not* an instance of the Number object
console.log(num); // 33.3
const nanStr = "thisIsNotANumber";
console.log(Number(nanStr)); // NaN

// volts is ignored, 16 is parsed in base 10 (radix)
console.log(parseInt("16 volts", 10)); // 16

console.log(parseInt("3a", 16)); // 58 (=3x16+10)
console.log(parseFloat("15.5 kph")); // 15.5

const d = new Date(); // valueOf() gets milliseconds since midnight, January 1, 1970 UTC
console.log(d.valueOf()); // 1541774463327

const arr2 = ["1", true, "hello"];
console.log(arr2.toString()); // 1,true,hello
const n = 0; // "falsy" value
const b1 = !!n; // false
const b2 = Boolean(n); // false
console.log(n + "," + b1 + "," + b2); // 0,false,false
console.log(n===false); // false
console.log(n==false); // true
