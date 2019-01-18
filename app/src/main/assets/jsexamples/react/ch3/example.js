function whatItMeansToBeFunctional() {
	// You can declare functions with the var keyword the same way you can declare
	// strings, numbers, or any other variables:
	var log = function(message) {
		console.log(message)
	}
	log("In JavaScript functions are variables") // In JavaScript, functions are variables

	// With ES6, we can write the same function using an arrow function	
	var l = message => console.log(message)
	l("This is a test") // This is a test

	// Since functions are variables, we can add them to objects:
	const obj = {
		message: "They can be added to objects like variables",
		log(message) {
			console.log(message)
		}
	}
	obj.log(obj.message) // They can be added to objects like variables

	// We can also add functions to arrays in JavaScript:
	const messages = [
		"They can be inserted into arrays",
		message => console.log(message),
		"like variables",
		message => console.log(message)
	]
	messages[1](messages[0]) // They can be inserted into arrays
	messages[3](messages[2]) // like variables

	// Functions can be sent to other functions as arguments, just like other variables:
	const insideFn = logger => logger("They can be sent to other functions as arguments");
	insideFn(message => console.log(message)) // They can be sent to other functions as arguments

	// They can also be returned from other functions, just like variables:
	var createScream = function(logger) {
		return function(message) {
			logger(message.toUpperCase() + "!!!")
		}
	}
	const scream = createScream(message => console.log(message))
	scream('functions can be returned from other functions')
	scream('createScream returns a function')
	scream('scream invokes that returned function')
	// FUNCTIONS CAN BE RETURNED FROM OTHER FUNCTIONS!!!
	// CREATESCREAM RETURNS A FUNCTION!!!
	// SCREAM INVOKES THAT RETURNED FUNCTION!!!
}
whatItMeansToBeFunctional()

// An imperative approach (focuses on "how" code will perform a task)
function makingURLFriendly() {
	var string = "This is the midday show with Cheryl Waters";
	var urlFriendly = "";
	for (var i=0; i<string.length; i++) {
		if (string[i] === " ") {
			urlFriendly += "-";
		} else {
			urlFriendly += string[i];
		}
	}
	console.log(urlFriendly) // This-is-the-midday-show-with-Cheryl-Waters
}
makingURLFriendly()

// A declarative approach (focuses on "what" code will do to perform a task)
function declarativeMakingURLFriendly() {
	const string = "This is the mid day show with Cheryl Waters"
	const urlFriendly = string.replace(/ /g, "-")
	console.log(urlFriendly) // This-is-the-mid-day-show-with-Cheryl-Waters
}
declarativeMakingURLFriendly()

function functionalConcepts() {
	// Immutability (p 37)
	let color_lawn = {
		title: "lawn",
		color: "#00FF00",
		rating: 0
	}

	const rateColor = function(color, rating) {
		color.rating = rating
		return color
	}

	// In JavaScript, function arguments are references to the actual data. Setting the color's
	// rating like this is bad because it changes or mutates the original color object.
	console.log(rateColor(color_lawn, 5).rating) // 5
	console.log(color_lawn.rating) // 5

	const rateColorCopyObject = function(color, rating) {
		return Object.assign({}, color, {rating:rating})
		// Object.assign is the copy machine; it takes a blank object, copies the color to that object,
		// and overwrites the rating on the copy.
	}
	color_lawn.rating = 4
	console.log(rateColorCopyObject(color_lawn, 5).rating) // 5
	console.log(color_lawn.rating) // 4

	// The Object.assign() method is used to copy the values of all enumerable own properties from
	//  one or more source objects to a target object. It will return the target object.
	let cat = {cat:"meow"}
	let obj = Object.assign({}, cat, {dog:"bark"}, {duck:"quack"})
	console.log(obj) // { cat: 'meow', dog: 'bark', duck: 'quack' }
	console.log(cat) // { cat: 'meow' }
}
functionalConcepts()

function arrayOfColors() { // p 38
	let list = [
		{ title: "Rad Red"},
		{ title: "Lawn"},
		{ title: "Party Pink"}
	]

	let addColor = function(title, colors) {
		// We could create a function that will add colors to that array using Array.push:
		colors.push({ title: title})
		return colors
	}
	console.log(addColor("Glam Green", list).length) // 4
	console.log(list, list.length)
	// [ { title: 'Rad Red' },
	//   { title: 'Lawn' },
	//   { title: 'Party Pink' },
	//   { title: 'Glam Green' } ] 4

	// However, Array.push is not an immutable function. This addColor function changes
	// the original array by adding another field to it. In order to keep the colors array
	// immutable, we must use Array.concat instead:

	list = [
		{ title: "Rad Red"},
		{ title: "Lawn"},
		{ title: "Party Pink"}
	]

	addColor = (title, array) => array.concat({title})
	console.log(addColor("Glam Green", list).length) // 4
	console.log(list, list.length)
	// [ { title: 'Rad Red' },
	//   { title: 'Lawn' },
	//   { title: 'Party Pink' } ] 3
	
	// Array.concat concatenates arrays. In this case, it takes a new object, with a new color
	// title, and adds it to a copy of the original array.
}
arrayOfColors()