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
}
