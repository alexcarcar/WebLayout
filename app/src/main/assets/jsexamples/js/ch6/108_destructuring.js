console.log("=== Function Signature/Destructuring Arguments (p 108)");
// Example 1:
function fA(x) {
	return `in fA: x=${x}`;
}
console.log(fA()); // the above is called, even though x is not defined
console.log(fA(2,3)); // the above is called, even though fA has two arguments

// Example 2:
function getSentence({subject, verb, object}) { // deconstructing an object into properties
	return `${subject} ${verb} ${object}`;
}
const sentenceObject = {subject:"I", verb:"love", object:"chess"};
console.log(getSentence(sentenceObject));

// Example 3:
function getSentenceFromArray([subject, verb, object]) { // deconstructing arguments from array
	return `${subject} ${verb} ${object}`;
}
const sentenceArray = ["I", "love", "chess"];
console.log(getSentenceFromArray(sentenceArray));

// Example 4:
function addPrefix(prefix, ...words) { // using the spread operator to collect remaining args
	const prefixedWords = [];
	for (let i=0; i<words.length; i++) {
		prefixedWords[i] = prefix + words[i];
	}
	return prefixedWords;
}
console.log(addPrefix("con", "verse", "vex").join());

// Example 5:
function fDefault(a, b="default", c=3) { // in ES6 default values can be set
	return `${a} - ${b} - ${c}`;
}
console.log(fDefault(5,6,7));
console.log(fDefault(5,6));
console.log(fDefault(5));
console.log(fDefault());

/*
=== Function Signature/Destructuring Arguments (p 108)
in fA: x=undefined
in fA: x=2
I love chess
I love chess
converse,convex
5 - 6 - 7
5 - 6 - 3
5 - default - 3
undefined - default - 3
*/