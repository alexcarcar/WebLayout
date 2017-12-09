console.log("=== Substring Matching and Replacing (p 237)");
const input = "As I was going to Saint Ives";
console.log("input:", input);
console.log(input.startsWith("As"), input.endsWith("Ives"), input.startsWith("going", 9));
console.log(input.endsWith("going", 14), input.includes("going"), input.includes("going", 10));
console.log(input.indexOf("going"), input.indexOf("going", 10), input.indexOf("nope"));

/*
=== Substring Matching and Replacing (p 237)
input: As I was going to Saint Ives
true true true
true true false
9 -1 -1
*/