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
		print: function(delay=200) {
			setTimeout(() => {
				console.log(this.resorts.join(", "))
			}, delay)
		}
	}
	tahoe.print()
	// Kirkwood, Squaw, Alpine, Heavenly, Northstar
}
tahoeListArrow()
