console.log("Objects (page 46)");
console.log("=================");

const obj = {};
obj.size;
obj.color = "yellow";
console.log(obj.size, obj.color);

obj["not an identifier"] = 3;
console.log(obj["not an identifier"], obj["color"]);
const SIZE = Symbol();
obj[SIZE] = 8;
console.log(obj[SIZE], obj);
console.log(JSON.stringify(obj));

const sam1 = {
	name: 'Sam',
	age: 4,
};

const sam2 = {name: 'Sam', age: 4}; //declaration on one line
const sam3 = {
	name: 'Sam',
	classification: {		// property values can be objects themselves;
		creature: 'Human',
		country: 'USA'
	}
};

console.log(sam1, sam2, sam3);
console.log(sam3.classification.country);
console.log(sam3["classification"].country);
console.log(sam3.classification["country"]);
console.log(sam3["classification"]["country"]);

sam3.speak = function() {return "Meow!";};
console.log(sam3.speak());
delete sam3.classification;
delete sam3.speak;
console.log(sam3);

const s = "hello";
console.log(s.toUpperCase());

const c = "hello";
s.rating = 3;
console.log(s.rating);