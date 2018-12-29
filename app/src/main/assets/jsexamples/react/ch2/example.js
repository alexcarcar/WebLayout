// Declaring Variables in ES6: p10-11
function declaringVariables() {
	// ----- const
	var pizza = true
	pizza = false
	console.log(pizza) // false

	// We cannot reset the value of a constant variable, and it will generate a console error
	// if we try to overwrite the value:
	const pizza2 = true
	// pizza2 = false
	// TypeError: Assignment to constant variable.
	
	// ----- let
	var topic = "JavaScript"
	if (topic) {
		// If a variable is created inside of an if/else block, that variable is not scoped to the block:
		var topic = "React"
		console.log('block', topic) // block React
	}
	console.log('global', topic) // global React

	var topic2 = "JavaScript"
	if (topic2) {
		// With the let keyword, we can scope a variable to any code block. Using let protects the value
		// of the global variable:
		let topic2 = "React"
		console.log('block', topic2) // React
	}
	console.log('global', topic2) // JavaScript
}
declaringVariables()

// Template strings provide us with an alternative to string concatenation
function templateStrings() {
	const firstName = "George"
	const middleName = "Alexander"
	const lastName = "Carcar"
	console.log(lastName + ", " + firstName + " " + middleName)
	// Carcar, George Alexander
	console.log(`${lastName}, ${firstName} ${middleName}`)
	// Carcar, George Alexander
}
templateStrings()

// Template strings honor whitespace, making it easier to draft up email templates, code
// examples, or anything else that contains whitespace.
function formLetter(firstName, middleName, lastName, qty, price, event, ticketAgent) {
	return `
	Hello ${firstName},

	Thanks for ordering ${qty} tickets to ${event}.

	Order Details
		${firstName} ${middleName} ${lastName}
		${qty} x $${price} = $${qty*price} to ${event}

	You can pick your tickets up at will call 30 minutes before
	the show.

	Thanks,
	${ticketAgent}`
}
console.log(formLetter("Simon", "Alexander", "Carcar", 34, 45.99, "Giants Game", "Mr. Box Office"))
// 
//        Hello Simon,
//
//        Thanks for ordering 34 tickets to Giants Game.
//
//        Order Details
//                Simon Alexander Carcar
//                34 x $45.99 = $1563.66 to Giants Game
//
//        You can pick your tickets up at will call 30 minutes before
//        the show.
//
//        Thanks,
//        Mr. Box Office
//

// Default Parameters
function defaultParameters() {
	const logActivity = function(name="Alex", activity="chess") {
		console.log(`${name} loves ${activity}`)
	}

	logActivity()
	logActivity("Simon")
	logActivity("Simon", "sports")
	// Alex loves chess
	// Simon loves chess
	// Simon loves sports
}
defaultParameters()

function defaultParametersWithObjects() {
	const defaultPerson = {
		name: {
			first: "Alex",
			last: "Carcar"
		},
		favActivity: "chess"
	}

	const logActivity = function(p=defaultPerson){
		console.log(`${p.name.first} loves ${p.favActivity}`)
	}

	logActivity()
	// Alex loves chess
}
defaultParametersWithObjects()

// Arrow Functions
function arrowFunctions() {
	var lordify = function(firstname) {
		return `${firstname} of Canterbury`
	}
	console.log( lordify("Dale") ) // Dale of Canterbury
	console.log( lordify("Daryle") ) // Daryle of Canterbury

	var cantify = firstname => `${firstname} of Canterbury`
	console.log(cantify("Alex")) // Alex of Canterbury

	var landify = (firstName, land) => {
		if (!firstName) {
			throw new Error('A firstName is required to lordify')
		}
		if (!land) {
			throw new Error('A lord must have a land')
		}
		return `${firstName} of ${land}`
	}
	console.log(landify("Caesar", "Rome")) // Caesar of Rome
	// landify("Budy") // Error: A lord must have a land
	// landify("", "Germany") // Error: A firstName is required to lordify
	// landify() // Error: A firstName is required to lordify
}
arrowFunctions()

// Regular functions do not block this. For example, this becomes something else in
// the setTimeout callback, not the tahoe object:

function tahoeList() {
	var tahoe = {
		resorts: ["Kirkwood","Squaw","Alpine","Heavenly","Northstar"],
		print: function(delay=1000) {
			setTimeout(function() {
				console.log(this.resorts.join(", "))
			}, delay)
		}
	}
	// tahoe.print() // Cannot read property 'join' of undefined
}
tahoeList()

// we can use the arrow function syntax to protect the scope of this: (p 17)
function tahoeListArrow() {
	var tahoe = {
		resorts: ["Kirkwood","Squaw","Alpine","Heavenly","Northstar"],
		print: function(delay=0) {
			setTimeout(() => {
				console.log(this.resorts.join(", "))
			}, delay)
		}
	}
	tahoe.print()
	// Kirkwood, Squaw, Alpine, Heavenly, Northstar
}
tahoeListArrow()

// The destructuring assignment allows you to locally scope fields within an object and
// to declare which values will be used.
function destructuringAssignment() {
	var sandwich = {
		bread: "dutch crunch",
		meat: "tuna",
		cheese: "swiss",
		toppings: ["lettuce", "tomato", "mustard"]
	}
	var {bread, meat} = sandwich
	console.log(bread, meat) // dutch crunch tuna

	var lordify = regularPerson => {
		console.log(`${regularPerson.firstname} of Canterbury`)
	}
	var regularPerson = {
		firstname: "Alex",
		lastname: "Carcar"
	}
	lordify(regularPerson) // Alex of Canterbury

	var structify = ({firstname}) => {
		console.log(`${firstname} of Canterbury`)
	}
	structify(regularPerson) // Alex of Canterbury

	// Values can also be destructured from arrays. Imagine that we wanted to assign the
	// first value of an array to a variable name:
	var [firstResort] = ["Kirkwood", "Squaw", "Alpine"]
	console.log(firstResort) // Kirkwood
	var [,,thirdResort] = ["Kirkwood", "Squaw", "Alpine"]
	console.log(thirdResort) // Alpine
}
destructuringAssignment()

// Object literal enhancement is the opposite of destructuring. It is the process of restructuring
// or putting back together. With object literal enhancement, we can grab variables
// from the global scope and turn them into an object
function objectLiteralEnhancement() {
	var name = "Tallac"
	var elevation = 9738
	var funHike = {name,elevation}
	console.log(funHike) // {name: "Tallac", elevation: 9738}
}
objectLiteralEnhancement()

// We can also create object methods with object literal enhancement or restructuring
function objectMethod() {
	var name = "Tallac"
	var elevation = 9738
	var print = function() {
		console.log(`Mt. ${this.name} is ${this.elevation} feet tall`)
	}
	var funHike = {name,elevation,print}
	funHike.print() // Mt. Tallac is 9738 feet tall
}
objectMethod()

// When defining object methods, it is no longer necessary to use the function keyword
function definingObjectMethods() {
	const name = "George"
	const sound = "wow"
	const skier = {
		name,
		sound,
		powderYell() {
			let yell = this.sound.toUpperCase()
			console.log(`${yell} ${yell} ${yell}!!!`)
		},
		speed(mph) {
			this.speed = mph
			console.log('speed:', mph)
		}
	}
	skier.powderYell() // WOW WOW WOW!!!
	skier.speed(65) // speed: 65
}
definingObjectMethods()

// The spread operator (...)
// ------------------------------------------------------------------------------------------------
//
// The spread operator is three dots (...) that perform several different tasks. First, the
// spread operator allows us to combine the contents of arrays.
function combineContents() {
	var peaks = ["Tallac", "Ralston", "Rose"]
	var canyons = ["Ward", "Blackwood"]
	var tahoe = [...peaks, ...canyons]
	console.log(tahoe.join(', ')) // Tallac, Ralston, Rose, Ward, Blackwood
}
combineContents()

// In a world with the spread operator, we don’t have to mutate the original array; we
// can create a copy of the array and then reverse it
function reverseCopy() {
	var peaks = ["Tallac", "Ralston", "Rose"]
	var [last] = [...peaks].reverse()
	console.log(last) // Rose
	console.log(peaks.join(', ')) // Tallac, Ralston, Rose
}
reverseCopy()

// The spread operator can also be used to get some, or the rest, of the items in the array
function getTheRest() {
	var lakes = ["Donner", "Marlette", "Fallen Leaf", "Cascade"]
	var [, ...rest] = lakes
	console.log(rest.join(", ")) // "Marlette, Fallen Leaf, Cascade"
}
getTheRest()

// We can also use the spread operator to collect function arguments as an array. Here,
// we build a function that takes in n number of arguments using the spread operator,
// and then uses those arguments to print some console messages:
function collectArguments() {
	const directions = function directions(...args) {
		var [start, ...remaining] = args
		var [finish, ...stops] = remaining.reverse()
		console.log(`drive through ${args.length} towns`)
		console.log(`start in ${start}`)
		console.log(`the destination is ${finish}`)
		console.log(`stopping ${stops.length} times in between`)
	}
	directions(
		"Truckee",
		"Tahoe City",
		"Sunnyside",
		"Homewood",
		"Tahoma"
	)
	// drive through 5 towns
	// start in Truckee
	// the destination is Tahoma
	// stopping 3 times in between
}
collectArguments()

// Using the spread operator with objects is similar to using it with arrays. In this example,
// we’ll use it the same way we combined two arrays into a third array, but instead of arrays,
// we’ll use objects:
function combiningObjects() {
	var morning = {
		breakfast: "oatmeal",
		lunch: "peanut butter and jelly"
	}
	var dinner = "mac and cheese"
	var backpackingMeals = {
		// ...morning
		breakfast: morning.breakfast,
		lunch: morning.lunch,
		dinner
	}
	console.log(backpackingMeals)
	// { breakfast: 'oatmeal',
	// lunch: 'peanut butter and jelly',
	// dinner: 'mac and cheese' }
}
combiningObjects()

// Promises
// -------------------------------------------------------------------------------------------

// The promise makes a request to the API. If the promise is successful, the data will load.
// If the promise is unsuccessful, an error will occur:
function makingPromises() {
	const getFakeMembers = count => new Promise((resolves, rejects) => {
		const api = `https://api.randomuser.me/?nat=US&results=${count}`
		const request = new XMLHttpRequest()
		request.open('GET', api)
		request.onload = () =>
			(request.status === 200) ?
			resolves(JSON.parse(request.response).results) :
			reject(Error(request.statusText))
		request.onerror = (err) => rejects(err)
		request.send()
	})

	// The then function can be chained on to do something once the promise has been fulfilled.
	// This is called composition. We’ll also use an additional callback that handles errors:
	getFakeMembers(5).then(
		members => console.log(members),
		err => console.error(
		new Error("cannot load members from randomuser.me"))
	)
	// Error: cannot load members from randomuser.me
}
makingPromises()
