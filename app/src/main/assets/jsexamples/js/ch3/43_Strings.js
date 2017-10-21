console.log("Strings (page 43)");
console.log("-----------------");

let currentTemp = 19.5;
const message = `The current temperature is ${currentTemp}\u00b0C`;
console.log(currentTemp, message);
const multiline = "line1\
line2";
const multiline2 = "line1\n\
line2";
console.log("\n====\n", multiline, "\n====\n", multiline2, "\n====");
const multiline3 = `line1
line2`;
console.log(multiline3);

console.log("Numbers as Strings (page 44)");
console.log("----------------------------");
const result1 = 3 + '30'; //3 is converted to a string; result is string '330'
const result2 = 3 * '30'; //'30' is converted to a number; result is numeric 90
console.log(result1, result2);
let heating = true;
let cooling = false;
let truthy = ("false"?true:false);
console.log(heating, cooling, truthy);

const RED = Symbol();
const ORANGE = Symbol("The color of a sunset!");
console.log(RED, ORANGE, RED===ORANGE);

let cTemp; //implicit value of undefined
const tTemp = null; // target temp null -- "not yet known"
cTemp = 19.5;
cTemp = undefined;
console.log(cTemp, tTemp);

/*
Strings (page 43)
-----------------
19.5 'The current temperature is 19.5°C'

====
 line1line2
====
 line1
line2
====
line1
line2
Numbers as Strings (page 44)
----------------------------
330 90
true false true
Symbol() Symbol(The color of a sunset!) false
undefined null
*/